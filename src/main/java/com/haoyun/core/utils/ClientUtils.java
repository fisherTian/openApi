package com.haoyun.core.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haoyun.core.security.ClientSession;
import com.haoyun.core.security.ClientSessionHolder;
import com.haoyun.model.SysUser;

public class ClientUtils {
	public static String CLIENT_SESSION = "CLIENT_SESSION";
	public static String CLIENT_ADMIN = "CLIENT_ADMIN";

	public static ClientSession getCS() {
		return ClientSessionHolder.getClientSession();
	}

	public static Object get(String key) {
		if (getCS() == null) {
			return null;
		}
		return getCS().getAttribute(key);
	}

	public static void set(String key, Object value) {
		getCS().addAttribute(key, value);
	}

	public static void remove(String key) {
		getCS().removeAttribute(key);
	}

	public static SysUser currentUser() {
		return (SysUser) getCS().getAttribute(CLIENT_ADMIN);
	}
	
	public static Long currentUserId() {
		return ((SysUser) getCS().getAttribute(CLIENT_ADMIN)).getUserId();
	}
	
	public static void forgetme(HttpServletRequest request, HttpServletResponse resp) {
        request.getSession().invalidate();
    }
	
}