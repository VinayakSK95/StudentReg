package com.example.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Component
public class MyFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtUtil1 jwtUtil;
	
	@Autowired
	UserRepo UserRepo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		String path=request.getServletPath();
		if(path.startsWith("/login"))
			filterChain.doFilter(request, response);
		else
		{
			int index=path.indexOf("mytokenstarts")+13;
			String token=path.substring(index);
			String username=jwtUtil.extractUsername(token);
			User user=UserRepo.findByUsername(username);
			UserDetails userDetails=new UserDetailService(user);
			if(jwtUtil.validateToken(token, userDetails))
			{
				request.setAttribute("user", user);
				filterChain.doFilter(request, response);
			}
			else
			{
				throw new IOException();
			}
		}
		
	}
}
