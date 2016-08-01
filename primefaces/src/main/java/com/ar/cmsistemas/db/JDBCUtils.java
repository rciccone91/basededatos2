package com.ar.cmsistemas.db;

import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.pool.OracleConnectionCacheManager;

import java.util.Locale;
import java.util.Properties;
import java.sql.*;

public class JDBCUtils {
    private final  static String CACHE_NAME = "DBCACHE";
    private  static OracleDataSource ods = null;

        static {
            System.out.println("OracleDataSource Initialization");
            try {
//            	Class.forName("oracle.jdbc.driver.OracleDriver");
//            	 Locale.setDefault(Locale.ENGLISH);
                ods = new OracleDataSource();
                ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
                ods.setUser("TP_USUARIOAPP");
                ods.setPassword("usuarioapp");
                // caching parms
                ods.setConnectionCachingEnabled(true);
                ods.setConnectionCacheName(CACHE_NAME);
                Properties cacheProps = new Properties();
                cacheProps.setProperty("MinLimit", "3");
                cacheProps.setProperty("MaxLimit", "50");
                cacheProps.setProperty("InitialLimit", "1");
                cacheProps.setProperty("ConnectionWaitTimeout", "5");
                cacheProps.setProperty("ValidateConnection", "true");

                ods.setConnectionCacheProperties(cacheProps);

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    /**
     * private constructor for static class
     */
    private JDBCUtils() { }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
      return getConnection("env. unspecified");
    }


    public static Connection getConnection(String algo)
       throws SQLException, ClassNotFoundException
    {
//      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("Request connection for " + algo);
      if (ods == null) {
          throw new SQLException("OracleDataSource is null.");
      }
      return ods.getConnection();
    }

    public static void closePooledConnections() throws SQLException{
      if (ods != null ) {
          ods.close();
      }
    }

    public static void listCacheInfos() throws SQLException{
      OracleConnectionCacheManager occm =
          OracleConnectionCacheManager.getConnectionCacheManagerInstance();
      System.out.println
          (occm.getNumberOfAvailableConnections(CACHE_NAME)
              + " connections are available in cache " + CACHE_NAME);
      System.out.println
          (occm.getNumberOfActiveConnections(CACHE_NAME)
              + " connections are active");

    }
 }