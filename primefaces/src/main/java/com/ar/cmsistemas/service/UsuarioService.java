package com.ar.cmsistemas.service;

import com.ar.cmsistemas.dao.UsuarioDao;

public class UsuarioService {
	UsuarioDao dao = new UsuarioDao();
	
	public Boolean loginUser(String usr,String passw){
		return dao.loginUser(usr,passw);
	}

	public boolean existeUsuario(String usuario) {
		return dao.existeUsuario(usuario);
	}

	public void saveUsuario(String usuario, String password) {
		dao.saveUsuario(usuario,password);
	}

}
