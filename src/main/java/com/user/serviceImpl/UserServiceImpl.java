package com.user.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public UserEntity addUser(UserEntity userEntity) {
		return repository.save(userEntity);
	}

	@Override
	public List<UserEntity> getAllUser() {
		return (List<UserEntity>) repository.findAll();
	}

	@Override
	public Optional<UserEntity> getUserById(int userId) {
		return repository.findById(userId);
	}

	@Override
	public UserEntity updateUserById(UserEntity userEntity, int userId) {
		UserEntity userFromDB = repository.findById(userId).get();
		userFromDB.setFirstName(userEntity.getFirstName());
		userFromDB.setLastName(userEntity.getLastName());
		userFromDB.setEmailId(userEntity.getEmailId());
		userFromDB.setUserName(userEntity.getUserName());
		userFromDB.setPassword(userEntity.getPassword());
		return repository.save(userFromDB);
	}

	@Override
	public String deleteUserById(int userId) {
		repository.deleteById(userId);
		return "user " + userId + " deleted successfully";
	}

}
