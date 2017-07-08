package com.chinasofti.controller.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class LayoutController {

	@RequestMapping("/west.do")
	public String west() {
		return "/layout/west";
	}

	@RequestMapping("/south.do")
	public String south() {
		return "/layout/south";
	}

	@RequestMapping("/east.do")
	public String east() {
		return "/layout/east";
	}

	@RequestMapping("/north.do")
	public String north() {
		return "/layout/north";
	}

	@RequestMapping("/center.do")
	public String center() {
		return "/layout/center";
	}

}
