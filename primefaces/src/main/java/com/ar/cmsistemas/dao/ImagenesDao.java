package com.ar.cmsistemas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ar.cmsistemas.db.DataSource;
import com.ar.cmsistemas.domain.Ciudad;
import com.ar.cmsistemas.domain.Imagen;
import com.ar.cmsistemas.helper.CommonHelper;

import oracle.jdbc.OracleTypes;

public class ImagenesDao {

	public static List<Imagen> getImagenesByProp(Integer id) {
		
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<Imagen> imagenes = new ArrayList<Imagen>();
		try {
			connection = DataSource.getInstance().getConnection();
			String call = "{call tp_dba.consultas_inmobiliaria.get_imagenes_by_prop(?,?)}";
			cs = connection.prepareCall(call);
			
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(2);
			
			while (rs.next()) {
				Imagen i = new Imagen();
				i.setId(rs.getInt("imagen_id"));
				i.setArchivo(rs.getString("image_path"));
				i.setActiva(CommonHelper.convertToJavaBoolean(rs.getString("active")));
				imagenes.add(i);
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
		
		return imagenes;
	}

}
