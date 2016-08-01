package com.ar.cmsistemas.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {

    private static DataSource     datasource;
    private BasicDataSource ds;

    private DataSource() throws IOException, SQLException, PropertyVetoException, ClassNotFoundException {
        ds = new BasicDataSource();
        Class.forName ("oracle.jdbc.OracleDriver");
        ds.setUsername("TP_USUARIOAPP");
        ds.setPassword("usuarioapp");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
       
        ds.setMaxTotal(100);
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);

    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException, ClassNotFoundException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}
