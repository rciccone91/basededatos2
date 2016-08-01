package com.ar.cmsistemas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ar.cmsistemas.db.DataSource;

import oracle.jdbc.OracleTypes;

public class UsuarioDao {

	public Boolean loginUser(String usr, String passw) {
		Connection connection = null;
		CallableStatement cs = null;
		Boolean b=null;
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{ ? = call tp_dba.consultas_inmobiliaria.login_user(?,?)}";
			cs = connection.prepareCall(call);

			cs.registerOutParameter(1, OracleTypes.NUMBER);
			cs.setString(2, usr);
			cs.setString(3, passw);		
			cs.execute();
			Integer existe = cs.getInt(1);
			
			if(existe ==1){
				b = true;
			}
			else
			{
				b=false;
			}

			
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
		
		return b;
	}

	public boolean existeUsuario(String usuario) {
		Connection connection = null;
		CallableStatement cs = null;
		Boolean b=null;
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{ ? = call tp_dba.consultas_inmobiliaria.existe_user(?)}";
			cs = connection.prepareCall(call);

			cs.registerOutParameter(1, OracleTypes.NUMBER);
			cs.setString(2, usuario);
			cs.execute();
			
			Integer existe = cs.getInt(1);
			
			if(existe ==0){
				b = true;
				System.out.println("Es valido");
			}
			else
			{
				b=false;
				System.out.println("Ya existe el usuario");
			}

			
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
		
		return b;
	}

	public void saveUsuario(String usuario, String password) {
		
		Connection connection = null;
		CallableStatement cs = null;
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.abm_inmobiliaria.save_usuario(?,?)}";
			cs = connection.prepareCall(call);

			cs.setString(1, usuario);
			cs.setString(2, password);
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
