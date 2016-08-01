package com.ar.cmsistemas.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ar.cmsistemas.dao.ImagenesDao;
import com.ar.cmsistemas.domain.*;
import com.ar.cmsistemas.helper.PropertiesHelper;

//@ManagedBean(name="imagenService", eager = true)
//@ApplicationScoped
public class ImagenService {
	
	
	public List<Imagen> getImagenesByProp(Integer id){
		return ImagenesDao.getImagenesByProp(id);
	}

}
