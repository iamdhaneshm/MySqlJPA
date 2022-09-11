package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.entity.UserEntity;

public interface UserService {
public UserEntity addUser(UserEntity userEntity);
public List<UserEntity> getAllUser();
public Optional<UserEntity> getUserById(int userId);
public UserEntity updateUserById(UserEntity userEntity,int userId);
public String deleteUserById(int userId);
}
