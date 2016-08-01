package com.ar.cmsistemas.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ar.cmsistemas.service.CiudadService;

@ManagedBean(name = "altaCiudadBean")
@ViewScoped
public class AltaCiudadBean {
	
	private String ciudad;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void guardar(){
		CiudadService service = new CiudadService();
		service.saveCiudad(ciudad);
	}
	
}
