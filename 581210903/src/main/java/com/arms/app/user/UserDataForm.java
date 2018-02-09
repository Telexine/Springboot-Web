package com.arms.app.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserDataForm {
	@NotEmpty
	private String nickname;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String avatar;
}