package com.ar.cmsistemas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ar.cmsistemas.db.DataSource;
import com.ar.cmsistemas.domain.TipoDeOperacion;
import com.ar.cmsistemas.domain.TipoDePropiedad;

import oracle.jdbc.OracleTypes;

public class TipoDePropiedadDao {
	
public List<TipoDePropiedad> getTiposDePropiedades() {
		
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<TipoDePropiedad> lista = new ArrayList<TipoDePropiedad>();
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.consultas_inmobiliaria.get_tipo_de_propiedades(?)}";
			cs = connection.prepareCall(call);
			
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(1);
			
			while (rs.next()) {
				TipoDePropiedad pr = new TipoDePropiedad();
				pr.setId(rs.getInt("tipo_de_propiedad_id"));
				pr.setDescripcion(rs.getString("descripcion"));
				lista.add(pr);
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
		return lista;
	}

public TipoDePropiedad getTipoDePropiedadById(Integer id) {
	Connection connection = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	TipoDePropiedad pr = new TipoDePropiedad();
	try {
		connection = DataSource.getInstance().getConnection();
		String call = "{call tp_dba.consultas_inmobiliaria.get_tipo_de_prop_by_id(?,?)}";
		cs = connection.prepareCall(call);
		
		cs.setInt(1, id);
		cs.registerOutParameter(2, OracleTypes.CURSOR);
		cs.execute();
		rs = (ResultSet)cs.getObject(2);
		
		while (rs.next()) {
			pr.setId(rs.getInt("tipo_de_propiedad_id"));
			pr.setDescripcion(rs.getString("descripcion"));
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
	return pr;
}

}
