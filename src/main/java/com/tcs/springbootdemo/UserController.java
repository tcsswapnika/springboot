package com.tcs.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController { // spring bean, act as required receiver

	@Autowired
	IUserService userService;

	@GetMapping("/getuser")
	public String getUser() {
		System.out.println("welcome");
		return "hello";
	}

	@PostMapping("/user")
	public void saveUser(@RequestBody User user) {
		userService.save(user);
		System.out.println(user.getFirstName());
	}
}
