package com.ar.cmsistemas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;

import com.ar.cmsistemas.db.DataSource;
import com.ar.cmsistemas.db.JDBCUtils;
import com.ar.cmsistemas.domain.Propiedad;
import com.ar.cmsistemas.domain.TipoDeOperacion;
import com.ar.cmsistemas.helper.CommonHelper;
import com.ar.cmsistemas.service.CiudadService;
import com.ar.cmsistemas.service.ImagenService;
import com.ar.cmsistemas.service.TipoDeOperaciónService;
import com.ar.cmsistemas.service.TipoDePropiedadService;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class PropiedadDao{
		
	
	public void save(Propiedad p) throws SQLException, Exception{
		
		Connection connection = null;
		CallableStatement cs = null;
		try {
			
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.abm_inmobiliaria.insert_propiedad(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			// Testing Purposes
//			String call = "{call tp_dba.abm_inmobiliaria.insert_proooopiedad(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cs = connection.prepareCall(call);
			cs.setString(1, p.getDireccion());
			cs.setString(2, p.getDesc());
			cs.setInt(3, p.getAmbientes());
			cs.setInt(4, p.getBanios());
			cs.setInt(5, p.getSuperficieCubierta());
			cs.setInt(6, p.getPrecio());
			cs.setInt(7,p.getTipoDeOperacion().getId());
			cs.setInt(8,p.getTipoDePropiedad().getId());
			cs.setString(9, CommonHelper.convertToOracleBoolean(p.getActivo()));
			cs.setInt(10, p.getCiudad().getId());
			cs.setInt(11, p.getHabitaciones());
			cs.setInt(12, p.getSuperficieTotal());
			cs.setDate(13, (new Date(p.getFechaDeConstruccion().getTime())));
			cs.setFloat(14, p.getLongitud().floatValue());
			cs.setFloat(15, p.getLatitud().floatValue());
			cs.setDate(16, (new Date(p.getCreateDate().getTime())));
			cs.setString(17, p.getCreateUser());
			cs.setString(18, p.getUpdateUser());
			cs.setDate(19, null);
				
			cs.execute();
			
		} catch (SQLException s) {
			System.out.println("Error: ");
			System.out.println(s.getMessage() +  " - " + "SQLState: "+s.getSQLState());
			s.printStackTrace();
			throw s;
		} catch (Exception e) {
			System.out.println("Error: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
            if (cs != null) try { cs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }

	}

	public List<Propiedad> getPropiedadesByOperacion(Integer op) {
		
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<Propiedad> propiedades = new ArrayList<Propiedad>();
		CiudadService ciudadService = new CiudadService();
		ImagenService imagenService = new ImagenService();
		TipoDeOperaciónService tipoDeOperacionService = new TipoDeOperaciónService();
		TipoDePropiedadService tipoDePropiedadService = new TipoDePropiedadService();

		
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.consultas_inmobiliaria.get_props_by_operacion(?,?)}";
			cs = connection.prepareCall(call);
			connection.prepareCall(call);
			cs.setInt(1, op);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(2);
			
	    	while(rs.next()){
	    		Propiedad p = new Propiedad();
				p.setId(rs.getInt("propiedad_id"));
	    		p.setActivo(CommonHelper.convertToJavaBoolean(rs.getString("active")));
	    		p.setAmbientes(rs.getInt("ambientes"));
	    		p.setBanios(rs.getInt("banios"));
	    		//Setear ciudad
				p.setCiudad(ciudadService.getCiudadById(rs.getInt("ciudad_id")));
	    		p.setCreateDate(rs.getDate("create_date"));
	    		// Usuario de create
	    		p.setCreateUser(rs.getString("create_user"));
	    		p.setDesc(rs.getString("descripcion"));
	    		p.setDireccion(rs.getString("direccion"));
	    		p.setFechaDeConstruccion(rs.getDate("fecha_de_construccion"));
	    		p.setHabitaciones(rs.getInt("habitaciones"));
	    		p.setId(rs.getInt("propiedad_id"));
	    		p.setLatitud(Double.valueOf(rs.getFloat("latitud")));
	    		p.setLongitud(Double.valueOf(rs.getFloat("longitud")));
	    		p.setPrecio(rs.getInt("precio"));
	    		p.setSuperficieCubierta(rs.getInt("superficie_cubierta"));
	    		p.setSuperficieTotal(rs.getInt("superficie_total"));
				p.setImagenes(imagenService.getImagenesByProp(p.getId()));
	    		// Tipo de Op y Tipo de Prop
	    		p.setTipoDeOperacion(tipoDeOperacionService.getTipoDeOperacionById(rs.getInt("tipo_de_operacion_id")));
	    		p.setTipoDePropiedad(tipoDePropiedadService.getTipoDePropiedadById(rs.getInt("tipo_de_propiedad_id")));
	    		p.setUpdateDate(rs.getDate("update_date"));
	    		// Usuario de update
	    		p.setUpdateUser(rs.getString("update_user"));

	    		propiedades.add(p);
	    	}
			

		} catch (SQLException s) {
			System.out.println("Error: ");
			s.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: ");
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (cs != null) try { cs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }
		return propiedades;
	}

	public Propiedad getPropiedadById(Integer id) {
	
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Propiedad propiedad = new Propiedad();
		CiudadService ciudadService = new CiudadService();
		ImagenService imagenService = new ImagenService();
		TipoDeOperaciónService tipoDeOperacionService = new TipoDeOperaciónService();
		TipoDePropiedadService tipoDePropiedadService = new TipoDePropiedadService();
		
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.consultas_inmobiliaria.get_prop_by_id(?,?)}";
			cs = connection.prepareCall(call);
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(2);
			
			while(rs.next()){
				propiedad.setId(rs.getInt("propiedad_id"));
				propiedad.setActivo(CommonHelper.convertToJavaBoolean(rs.getString("active")));
				propiedad.setAmbientes(rs.getInt("ambientes"));
				propiedad.setBanios(rs.getInt("banios"));
				//Setear ciudad
				propiedad.setCiudad(ciudadService.getCiudadById(rs.getInt("ciudad_id")));
				propiedad.setCreateDate(rs.getDate("create_date"));
				// Usuario de create
				propiedad.setCreateUser(rs.getString("create_user"));
				propiedad.setDesc(rs.getString("descripcion"));
				propiedad.setDireccion(rs.getString("direccion"));
				propiedad.setFechaDeConstruccion(rs.getDate("fecha_de_construccion"));
				propiedad.setHabitaciones(rs.getInt("habitaciones"));
				propiedad.setId(rs.getInt("propiedad_id"));
				propiedad.setLatitud(Double.valueOf(rs.getFloat("latitud")));
				propiedad.setLongitud(Double.valueOf(rs.getFloat("longitud")));
				propiedad.setPrecio(rs.getInt("precio"));
				propiedad.setSuperficieCubierta(rs.getInt("superficie_cubierta"));
				propiedad.setSuperficieTotal(rs.getInt("superficie_total"));
				propiedad.setImagenes(imagenService.getImagenesByProp(id));
				// Tipo de Op y Tipo de Prop
				propiedad.setTipoDeOperacion(tipoDeOperacionService.getTipoDeOperacionById(rs.getInt("tipo_de_operacion_id")));
				propiedad.setTipoDePropiedad(tipoDePropiedadService.getTipoDePropiedadById(rs.getInt("tipo_de_propiedad_id")));
				propiedad.setUpdateDate(rs.getDate("update_date"));
				// Usuario de update
				propiedad.setUpdateUser(rs.getString("update_user"));
			}
			
		} catch (SQLException s) {
			System.out.println("Error: ");
			s.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: ");
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (cs != null) try { cs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }
		return propiedad;
	}
	
	public List<Propiedad> getPropiedades() {
		
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<Propiedad> props = new ArrayList<Propiedad>();
		CiudadService ciudadService = new CiudadService();
		ImagenService imagenService = new ImagenService();
		TipoDeOperaciónService tipoDeOperacionService = new TipoDeOperaciónService();
		TipoDePropiedadService tipoDePropiedadService = new TipoDePropiedadService();
		try {
			
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.consultas_inmobiliaria.get_props(?)}";
			cs = connection.prepareCall(call);

			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(1);
			
			while(rs.next()){
				Propiedad propiedad = new Propiedad();
				propiedad.setId(rs.getInt("propiedad_id"));
				propiedad.setActivo(CommonHelper.convertToJavaBoolean(rs.getString("active")));
				propiedad.setAmbientes(rs.getInt("ambientes"));
				propiedad.setBanios(rs.getInt("banios"));
				//Setear ciudad
				propiedad.setCiudad(ciudadService.getCiudadById(rs.getInt("ciudad_id")));
				propiedad.setCreateDate(rs.getDate("create_date"));
				// Usuario de create
				//p.setCreateUser(rs.getString("create_user"));
				propiedad.setDesc(rs.getString("descripcion"));
				propiedad.setDireccion(rs.getString("direccion"));
				propiedad.setFechaDeConstruccion(rs.getDate("fecha_de_construccion"));
				propiedad.setHabitaciones(rs.getInt("habitaciones"));
				propiedad.setId(rs.getInt("propiedad_id"));
				propiedad.setLatitud(Double.valueOf(rs.getFloat("latitud")));
				propiedad.setLongitud(Double.valueOf(rs.getFloat("longitud")));
				propiedad.setPrecio(rs.getInt("precio"));
				propiedad.setSuperficieCubierta(rs.getInt("superficie_cubierta"));
				propiedad.setSuperficieTotal(rs.getInt("superficie_total"));
				propiedad.setImagenes(imagenService.getImagenesByProp(propiedad.getId()));
				// Tipo de Op y Tipo de Prop
				propiedad.setTipoDeOperacion(tipoDeOperacionService.getTipoDeOperacionById(rs.getInt("tipo_de_operacion_id")));
				propiedad.setTipoDePropiedad(tipoDePropiedadService.getTipoDePropiedadById(rs.getInt("tipo_de_propiedad_id")));
				propiedad.setUpdateDate(rs.getDate("update_date"));
				// Usuario de update
				propiedad.setUpdateUser(rs.getString("update_user"));
				props.add(propiedad);
			}
			
		} catch (SQLException s) {
			System.out.println("Error: ");
			s.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: ");
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (cs != null) try { cs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }
		
		return props;
	}

	public void update(Propiedad p) throws SQLException,Exception {
		Connection connection = null;
		CallableStatement cs = null;
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.abm_inmobiliaria.update_propiedad(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cs = connection.prepareCall(call);
			cs.setInt(1, p.getId()); //			prop_id               IN NUMBER,
			cs.setString(2, p.getDireccion()); //v_direccion             IN VARCHAR2, 
			cs.setString(3, p.getDesc()); //v_descripcion           IN VARCHAR2, 
			cs.setInt(4, p.getAmbientes()); //v_ambientes             IN NUMBER,
			cs.setInt(5, p.getBanios()); //v_banios                IN NUMBER, 
			cs.setInt(6, p.getSuperficieCubierta()); //v_superficie_cubierta   IN NUMBER, 
			cs.setInt(7, p.getPrecio()); //v_precio                IN NUMBER, 
			cs.setInt(8,p.getTipoDeOperacion().getId()); //v_tipo_de_operacion_id  IN NUMBER, 
			cs.setInt(9,p.getTipoDePropiedad().getId()); //v_tipo_de_propiedad_id  IN NUMBER,
			cs.setString(10, CommonHelper.convertToOracleBoolean(p.getActivo())); //v_active                IN VARCHAR2,
			cs.setInt(11, p.getCiudad().getId()); //v_ciudad_id             IN NUMBER, 
			cs.setInt(12, p.getHabitaciones()); //v_habitaciones          IN NUMBER, 
			cs.setInt(13, p.getSuperficieTotal()); //v_superficie_total      IN NUMBER,
			cs.setDate(14, new Date(p.getFechaDeConstruccion().getTime())); //v_fecha_de_construccion IN DATE, 
			cs.setFloat(15, p.getLongitud().floatValue()); //v_longitud              IN FLOAT, 
			cs.setFloat(16, p.getLatitud().floatValue()); //v_latitud               IN FLOAT, 
			cs.setDate(17, new Date(p.getCreateDate().getTime())); //v_create_date           IN DATE, 
			cs.setString(18, p.getCreateUser()); //v_create_user           IN VARCHAR2, 
			cs.setDate(19, new Date(p.getUpdateDate().getTime())); //v_update_date           IN DATE, 
			cs.setString(20, p.getUpdateUser()); //v_update_user           IN VARCHAR2
			
			cs.execute();
			
		} catch (SQLException s) {
			System.out.println("Error: ");
			System.out.println(s.getMessage() +  " - " + "SQLState: "+s.getSQLState());
			s.printStackTrace();
			throw s;
		} catch (Exception e) {
			System.out.println("Error: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
            if (cs != null) try { cs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }
	}
}
