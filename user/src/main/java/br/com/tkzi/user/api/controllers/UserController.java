package br.com.tkzi.user.api.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.user.domain.dto.UserRecordDto;
import br.com.tkzi.user.domain.model.User;
import br.com.tkzi.user.domain.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
		var userModel = new User();
		BeanUtils.copyProperties(userRecordDto, userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userModel));
	}

}
