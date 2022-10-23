package com.cruzeiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//	Esse mapeamento leva para a main-menu
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}
