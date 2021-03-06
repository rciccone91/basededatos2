package com.ar.cmsistemas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ar.cmsistemas.db.DataSource;
import com.ar.cmsistemas.db.JDBCUtils;
import com.ar.cmsistemas.domain.Ciudad;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class CiudadDao {

	public Ciudad getCiudadById(Integer id){

		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Ciudad ciudad = new Ciudad();
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.consultas_inmobiliaria.get_ciudad_by_id(?,?)}";
			cs = connection.prepareCall(call);
			
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(2);
			
			while (rs.next()) {
				ciudad.setId(rs.getInt("ciudad_id"));
				ciudad.setCiudad(rs.getString("nombre"));
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
		
		return ciudad;
	}

	public List<Ciudad> getCiudades() {
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.consultas_inmobiliaria.get_ciudades(?)}";
			cs = connection.prepareCall(call);
			
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(1);
			
			while (rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setId(rs.getInt("ciudad_id"));
				ciudad.setCiudad(rs.getString("nombre"));
				ciudades.add(ciudad);
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
		
		return ciudades;
	}

	public void saveCiudad(String ciudad) {
		Connection connection = null;
		CallableStatement cs = null;
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.abm_inmobiliaria.save_ciudad(?)}";
			cs = connection.prepareCall(call);
			
			cs.setString(1, ciudad);
			cs.execute();
			
		} catch (SQLException s) {
			System.out.println("Error: ");
			s.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: ");
			e.printStackTrace();
		}finally {
            if (cs != null) try { cs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }
	}
}
