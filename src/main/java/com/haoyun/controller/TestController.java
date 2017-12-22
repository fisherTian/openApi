package com.haoyun.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping(value="/data",method=RequestMethod.GET)
	@ResponseBody
	public Map data(){
		Map result = new HashMap();
		result.put("data", "你好，颢云！");
		return result;
	}

}
