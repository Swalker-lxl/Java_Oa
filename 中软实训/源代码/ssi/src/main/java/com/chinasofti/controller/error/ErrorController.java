package com.chinasofti.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
	

	@RequestMapping("/noSession.do")
	public String noSession() {
		return "/error/noSession";
	}

}
