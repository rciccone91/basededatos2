package com.ar.cmsistemas.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ar.cmsistemas.dao.CiudadDao;
import com.ar.cmsistemas.dao.PropiedadDao;
import com.ar.cmsistemas.db.JDBCUtils;
import com.ar.cmsistemas.domain.Ciudad;
import com.ar.cmsistemas.domain.Propiedad;

public class CiudadService {

	private CiudadDao dao = new CiudadDao();
	private List<Ciudad> ciudades;
	
	
	public Ciudad getCiudadById(Integer id){
		return dao.getCiudadById(id);
	}


	public List<Ciudad> getCiudades() {
		return dao.getCiudades();
	}


	public void saveCiudad(String ciudad) {
		dao.saveCiudad(ciudad);
	}
	
}
