package com.ar.cmsistemas.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.ar.cmsistemas.helper.SessionHelper;
import com.ar.cmsistemas.service.UsuarioService;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	
	private String user;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	//validate login
		public String login() {
			UsuarioService service = new UsuarioService();
			boolean valid = service.loginUser(user, password);
			if (valid) {
				HttpSession session = SessionHelper.getSession();
				session.setAttribute("username", user);
				return "index.html";
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Usuario o password incorrecta",
								"Por favor, ingrese la password y usuario correctos."));
				return "login.xhtml";
			}
		}

		//logout event, invalidate session
		public String logout() {
			HttpSession session = SessionHelper.getSession();
			session.invalidate();
			return "login.xhtml";
		}
	
	

}
