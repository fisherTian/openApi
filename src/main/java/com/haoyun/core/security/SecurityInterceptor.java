package com.haoyun.core.security;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.haoyun.core.utils.AppConfig;
import com.haoyun.core.utils.TokenProcessor;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
	
	private static String unfilteredURIs = AppConfig.getUnfilteredURIs();
	private Pattern regex = null;
	
	private void init() {
		regex = Pattern.compile(unfilteredURIs);
	}

	public SecurityInterceptor() {
		super();
		this.init();
	}
	

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI().substring(request.getContextPath().length());
		
		if (regex.matcher(requestURI).matches()) {
			return true;
		}
		boolean auth = TokenProcessor.getInstance().isTokenValid(request);
		if (!auth) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
//		HttpSession session = request.getSession(true);
//		ClientSession cs = (ClientSession) session.getAttribute("CLIENT_SESSION");
//		ClientSessionHolder.setClientSession(cs);
		return true;
	}


}
