package com.arms.app.user;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arms.domain.service.UserService;
@Controller
public class UserEditController {

	@Autowired
	UserService userService;
	
	
	/*
	@RequestMapping("/user/editaccount")
	public ModelAndView signup(ModelAndView modelAndView){
		modelAndView.setViewName("user/editacc");
		modelAndView.addObject("UserEditForm", new UserEditForm());
		return modelAndView;
	}

	 */


	
	@RequestMapping(value = "/user/editaccount/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id, ModelAndView modelAndView, Principal principal) {
 
		modelAndView.addObject("user", userService.findOne(id));
		modelAndView.addObject("userEditForm", userService.setUserEditForm(id));
		modelAndView.setViewName("user/editacc");
		return modelAndView;
	}

	@RequestMapping(value = "/user/editaccount", method = RequestMethod.POST)
	public Object edit(@Validated UserEditForm userEditForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, ModelAndView modelAndView, Principal principal)
			throws NoSuchAlgorithmException {
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("user", userService.findOne(userEditForm.getId()));
			modelAndView.setViewName("user/editacc");
			return modelAndView;
		}
		 userService.updateUser(userEditForm);
		 redirectAttributes.addFlashAttribute("message", "User was updated.");
		return "redirect:/";
	}

	
}
