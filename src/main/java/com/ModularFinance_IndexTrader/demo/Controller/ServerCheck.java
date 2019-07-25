package com.ModularFinance_IndexTrader.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ServerCheck {

	@GetMapping("/check")
	public String check() {
		String checking = "Server is on";
		return checking;
	}
}
