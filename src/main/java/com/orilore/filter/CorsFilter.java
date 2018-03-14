package com.orilore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter{
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse hres = (HttpServletResponse)response;
		hres.setHeader("Access-Control-Allow-Origin", "*");//允许所有域名向本项目发起请求
		hres.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
		hres.setHeader("Access-Control-Allow-Methods", "POST, GET");  
        hres.setHeader("Access-Control-Max-Age", "3600");
        chain.doFilter(request, hres);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
