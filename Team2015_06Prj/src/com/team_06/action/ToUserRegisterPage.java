package com.team_06.action;

import com.opensymphony.xwork2.ActionSupport;

public class ToUserRegisterPage extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Override
	public String execute(){
		return "register";
	}
}
