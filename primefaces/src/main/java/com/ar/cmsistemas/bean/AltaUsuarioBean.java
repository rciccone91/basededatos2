package com.ar.cmsistemas.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ar.cmsistemas.service.UsuarioService;

@ManagedBean(name = "altaUsuarioBean")
@ViewScoped
public class AltaUsuarioBean {

	private String usuario;
	private String password;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String guardar(){
		UsuarioService service = new UsuarioService();
		boolean valid = service.existeUsuario(usuario);
		if (valid) {
			service.saveUsuario(usuario,password);
			return "index.html";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Usuario ya registrado en el sistema",
							"Por favor, ingrese un usuario diferente a dar de alta."));
			return "altaUsuario.xhtml";
		}
		
	}
}
