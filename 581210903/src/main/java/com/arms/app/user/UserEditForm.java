package com.arms.app.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserEditForm {
	@NotNull
	private Integer userid;
	@NotEmpty
	private String nickname;
	private String username;
	@NotEmpty
	private String password;
 
	private String avartar;
}