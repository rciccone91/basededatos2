package com.ar.cmsistemas.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ar.cmsistemas.domain.Propiedad;

@ManagedBean(name="propiedadBackingService", eager = true)
@ApplicationScoped
public class PropiedadBackingService {

	public List<Propiedad> getPropiedades(){
		PropiedadService ps = new PropiedadService();
		return ps.getPropiedades();
	}
	
	public Propiedad getPropiedadById(Integer id){
		PropiedadService ps = new PropiedadService();
		return ps.getPropiedadById(id);
	}
}
