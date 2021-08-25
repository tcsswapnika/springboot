package com.tcs.springbootdemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springbootdemo.User;
import com.tcs.springbootdemo.exceptions.UserNotFoundException;
import com.tcs.springbootdemo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController { // spring bean, act as required receiver

	@Autowired
	IUserService userService;

	@GetMapping()
	public Iterable<User> getUser() {
		System.out.println("called");
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	private Optional<User> getUser(@PathVariable("id") Integer id) {
		return userService.getUser(id);

	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<User> exception(UserNotFoundException userNotFoundException) {
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping // method+Path
	private void updateUser(@RequestBody User user) {
		userService.save(user);
		System.out.println(user.getFirstName());

	}

	@PostMapping
	public void saveUser(@RequestBody User user) {
		userService.save(user);
		System.out.println(user.getFirstName());
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
	}
}
