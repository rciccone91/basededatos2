package com.ar.cmsistemas.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ar.cmsistemas.dao.PropiedadDao;
import com.ar.cmsistemas.db.JDBCUtils;
import com.ar.cmsistemas.domain.*;
import com.ar.cmsistemas.helper.CommonHelper;

//@ManagedBean(name="propiedadService", eager = true)
//@ApplicationScoped
public class PropiedadService {
	
	private PropiedadDao dao = new PropiedadDao();
	ImagenService imagenService = new ImagenService();
    
//    @PostConstruct
	//TODO- pasar como parametro el tipo de operación que tenga que ir
    public List<Propiedad> getPropiedadesByOperacion(Integer op) {
    	return dao.getPropiedadesByOperacion(op);
    }
     
    private Propiedad getMockedProperty() {
    	Date fecha = new Date();
    	fecha = Calendar.getInstance().getTime();
    	
    	Propiedad p =new Propiedad();
    	p.setActivo(true);
    	p.setAmbientes(3);
    	p.setBanios(1);
    	p.setDesc("Esta es la descripcion");
    	p.setDireccion("San Martin 547");
    	p.setFechaDeConstruccion(fecha);
    	p.setHabitaciones(1);
    	p.setId(1);
    	p.setPrecio(9000000);
		return p;
	}
    
    public void savePropiedad(Propiedad p) throws SQLException, Exception{
    	dao.save(p);
    }
    
    public Propiedad getPropiedadById(Integer id){
    	Propiedad propiedad = dao.getPropiedadById(id);
		return propiedad;
    } 
    
    public List<Propiedad> getPropiedades(){
    	List<Propiedad> props = dao.getPropiedades();
		return props;
    }

	public void updatePropiedad(Propiedad p) throws SQLException, Exception {
		dao.update(p);
	} 


}
