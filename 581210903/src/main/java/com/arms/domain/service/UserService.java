package com.arms.domain.service;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.arms.app.user.UserDataForm;
import com.arms.app.user.UserEditForm;
import com.arms.domain.component.PasswordEncoder;
 
import com.arms.domain.entity.User;
@Service
public class UserService extends AppService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void createUser(UserDataForm userAddForm) throws NoSuchAlgorithmException {
	Date nowDate = Calendar.getInstance().getTime();
	User user = new User();
	user.setNickname(userAddForm.getNickname());
	user.setUsername(userAddForm.getUsername());
	user.setAvartar(userAddForm.getAvartar()==null? "/images/defaultavatar.jpg" :userAddForm.getAvartar());
	
	
	user.setPassword(passwordEncoder.hashMD5(userAddForm.getPassword()));
	user.setCreated(nowDate);
	user.setUpdated(nowDate);
	userRepository.save(user);
	
	}
	public Page<User> findAllUser(Pageable pageable){
		return userRepository.findAll(pageable);
		}
	
	public User findOne(int userId) {
		return userRepository.findOne(userId);
		}
	public UserEditForm setUserEditForm(int userId) {
		User user = userRepository.findOne(userId);
		UserEditForm userEditForm = new UserEditForm();
		userEditForm.setId(user.getId());
		userEditForm.setNickname(user.getNickname());
		userEditForm.setUsername(user.getUsername());
		userEditForm.setAvartar(user.getAvartar());
		return userEditForm;
		}
	public void updateUser(UserEditForm userEditForm) throws NoSuchAlgorithmException {
			Date nowDate = Calendar.getInstance().getTime();
			User user = userRepository.findOne(userEditForm.getId());
			user.setNickname(userEditForm.getNickname());
			user.setPassword(passwordEncoder.hashMD5(userEditForm.getPassword()));
			user.setAvartar(userEditForm.getAvartar());
			user.setUpdated(nowDate);
			userRepository.save(user);
		}
	public void deleteUser(int userId){
		userRepository.delete(userId);
		}
	
	 
}