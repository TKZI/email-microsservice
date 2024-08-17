package br.com.tkzi.user.domain.service;

import org.springframework.stereotype.Service;

import br.com.tkzi.user.api.producer.UserProducer;
import br.com.tkzi.user.domain.model.User;
import br.com.tkzi.user.domain.repositores.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	
	private final UserRepository userRepository;
	private final UserProducer userProducer;
	
	public UserService(UserRepository userRepository, UserProducer userProducer) {
		this.userRepository = userRepository;
		this.userProducer = userProducer;
	}
	
	@Transactional
	public User saveUser(User user) {
		var userModel  =  userRepository.save(user);
		userProducer.publishMessageEmail(userModel);
		return userModel;
	}

}
