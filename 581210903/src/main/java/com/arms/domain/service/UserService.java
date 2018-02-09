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
	user.setAvartar(userAddForm.getAvatar()==null? "/images/defaultavatar.jpg" :userAddForm.getAvatar());
	
	
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
	public UserEditForm setUserDataForm(int userId) {
		User user = userRepository.findOne(userId);
		UserEditForm userEditForm = new UserEditForm();
		userEditForm.setUserid(user.getId());
		userEditForm.setNickname(user.getNickname());
		userEditForm.setUsername(user.getUsername());
		return userEditForm;
		}
	public void updateUser(UserEditForm userEditForm) throws NoSuchAlgorithmException {
		Date nowDate = Calendar.getInstance().getTime();
		User user = userRepository.findOne(userEditForm.getUserid());
		user.setNickname(userEditForm.getNickname());
		user.setPassword(passwordEncoder.hashMD5(userEditForm.getPassword()));
		user.setUpdated(nowDate);
		userRepository.save(user);
		}
	public void deleteUser(int userId){
		userRepository.delete(userId);
		}
	
	 
}