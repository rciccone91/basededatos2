package com.ar.cmsistemas.bean;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import com.ar.cmsistemas.helper.SessionHelper;

@ManagedBean(name = "menuBean", eager = true)
public class MenuBean {

	//logout event, invalidate session
	public String logout() {
		System.out.println("Entro al logput");
		HttpSession session = SessionHelper.getSession();
		session.invalidate();
		return "login.xhtml";
	}
}
