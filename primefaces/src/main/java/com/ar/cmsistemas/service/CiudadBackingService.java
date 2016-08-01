package com.ar.cmsistemas.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ar.cmsistemas.domain.Ciudad;

@ManagedBean(name="ciudadBackingService", eager = true)
@ApplicationScoped
public class CiudadBackingService {

	private List<Ciudad> ciudades;
	CiudadService ciudadService = new CiudadService();
	
	
    @PostConstruct
    public void init() {
//    	ciudades = ciudadService.getCiudades();
//    	
//    	// ESTO ESTA MOCKEADO, DESPUES VAMOS A LLAMAR A LA BASE PARA
//    	//TRAER LOS TIPO DE OPERACIONES
//    	
////    	Zona z = new Zona(1,"Zona norte");
////    	ciudades.add(new Ciudad(1,"Pilar",z));
////    	ciudades.add(new Ciudad(2,"San Miguel",z));
    }
     
    public List<Ciudad> getCiudades() {
        return ciudadService.getCiudades();
    } 
    
    public Ciudad getCiudadById(Integer id) {
        return ciudadService.getCiudadById(id);
    } 
}
