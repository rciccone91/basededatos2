package com.ar.cmsistemas.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ar.cmsistemas.dao.TipoDeOperacionDao;
import com.ar.cmsistemas.domain.TipoDeOperacion;
 

 
@ManagedBean(name="tipoDeOperacionService", eager = true)
@ApplicationScoped
public class TipoDeOperaciónService {
    
    @PostConstruct
    public void init() {
    }
     
    public List<TipoDeOperacion> getTipoDeOperaciones() {
        TipoDeOperacionDao dao = new TipoDeOperacionDao();
        return dao.getTiposDeOperaciones();
    } 

    public TipoDeOperacion getTipoDeOperacionById(Integer id){
    	TipoDeOperacionDao dao = new TipoDeOperacionDao();
    	return dao.getTipoDeOperacionById(id);
    }
}
