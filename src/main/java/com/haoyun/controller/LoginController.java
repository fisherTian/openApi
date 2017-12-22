package com.haoyun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.haoyun.core.security.ClientSession;
import com.haoyun.core.security.ClientSessionHolder;
import com.haoyun.core.utils.ClientUtils;
import com.haoyun.core.utils.MD5Util;
import com.haoyun.core.utils.TokenProcessor;
import com.haoyun.model.SysUser;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@RequestMapping(value="/in",method=RequestMethod.POST)
	@ResponseBody
	public Map login(String account,String password, HttpServletRequest request){
		Map result = new HashMap();
		result.put("auth", false);
		if(account.equals("admin")&&password.equals("123456")){
			
			result.put("auth", true);
			
			String token = TokenProcessor.getInstance().saveToken(request);
			result.put("token", token);
			
			SysUser user = new SysUser();
			user.setName("颢云科技");
			user.setMail("123@qq.com");
			user.setAvatar("./assets/img/zorro.svg");
			
			result.put("user", user);
			result.put("role", "aa");
			
			
			HttpSession session = request.getSession(true);
            ClientSession cs = (ClientSession) session.getAttribute(ClientUtils.CLIENT_SESSION);
            if (null == cs) {
                cs = new ClientSession();
            }
            
            ClientSessionHolder.setClientSession(cs);
            session.setAttribute(ClientUtils.CLIENT_SESSION, cs);
		}
		return result;
	}
	
}
