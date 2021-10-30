package br.com.doeparasuaparoquia.virtus.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class VitusTokenFilter extends OncePerRequestFilter {

	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain) throws IOException, ServletException{
		// aqui eu faço a "mágica"
		
		System.out.println("A requisiçao passou pelo filtro");
		
		// a validaçao do token
		if (request.getHeader("Authorization") != null) {
			Authentication auth = VirtusTokenUtil.decodeToken(request);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		// encaminho a solicitacao
		filterChain.doFilter(request, response);
	}

}
