package com.ar.cmsistemas.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ar.cmsistemas.dao.TipoDePropiedadDao;
import com.ar.cmsistemas.domain.TipoDePropiedad;

@ManagedBean(name="tipoDePropiedadService", eager = true)
@ApplicationScoped
public class TipoDePropiedadService {


	private List<TipoDePropiedad> tipoDePropiedades;
    
    @PostConstruct
    public void init() {
//    	tipoDePropiedades = new ArrayList<TipoDePropiedad>();
//    	
//    	// ESTO ESTA MOCKEADO, DESPUES VAMOS A LLAMAR A LA BASE PARA
//    	//TRAER LOS TIPO DE OPERACIONES
//    	tipoDePropiedades.add(new TipoDePropiedad(1,"Casa"));
//    	tipoDePropiedades.add(new TipoDePropiedad(2,"Departamento"));
    }
     
    public List<TipoDePropiedad> getTipoDePropiedades() {
    	TipoDePropiedadDao dao = new TipoDePropiedadDao();
        return dao.getTiposDePropiedades();
    }

	public TipoDePropiedad getTipoDePropiedadById(Integer id) {
		TipoDePropiedadDao dao = new TipoDePropiedadDao();
		return dao.getTipoDePropiedadById(id);
	} 
}
