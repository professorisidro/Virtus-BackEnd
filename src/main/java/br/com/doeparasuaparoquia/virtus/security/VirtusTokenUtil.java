package br.com.doeparasuaparoquia.virtus.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.doeparasuaparoquia.virtus.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class VirtusTokenUtil {
	
	private static final String SECRET_KEY  ="&V1rtu5Appl1c@ti0nD0n@t10nF0rP@r0qu1@s";
	private static final long   EXPIRATION  = 3*1440*60*1000; // 3 dias de validade
//	private static final long   EXPIRATION  = 20*1000;
	private static final String PREFIX      = "Bearer ";
	private static final String HEADER_AUTH = "Authorization";
	
	public static String generateToken(Usuario usuario) {
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		String jwt = Jwts.builder()
						.setSubject(usuario.getLogin())
						.setIssuer("*ProjectVirtus*")
						.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION))
						.signWith(secretKey, SignatureAlgorithm.HS256)
						.compact();
		
		System.out.println("token gerado = "+jwt);
		return PREFIX + jwt;
	}
	
	public static boolean isIssuerValid(String issuer) {
		return issuer.equals("*ProjectVirtus*");
	}
	
	public static boolean isSubjectValid(String subject) {
		return subject != null && subject.length()>0;
	}
	
	public static boolean isExpirationValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));
	}
	
	public static Authentication decodeToken(HttpServletRequest request) {
		String token = request.getHeader(HEADER_AUTH);
		token = token.replace(PREFIX, "");
		
		Jws<Claims> jwsClaims = Jwts.parserBuilder()
									.setSigningKey(SECRET_KEY.getBytes())
									.build()
									.parseClaimsJws(token);
		
		String userName = jwsClaims.getBody().getSubject();
		String issuer   = jwsClaims.getBody().getIssuer();
		Date   dataExp  = jwsClaims.getBody().getExpiration();
		
		if (isSubjectValid(userName) && isIssuerValid(issuer) && isExpirationValid(dataExp)) {
			 return new UsernamePasswordAuthenticationToken(userName, null, Collections.emptyList());
		}
		return null;
	}
}
