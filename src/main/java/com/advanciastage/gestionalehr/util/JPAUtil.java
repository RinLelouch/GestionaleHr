package com.advanciastage.gestionalehr.util;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			try {
				Properties props = new Properties();
				props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
				InitialContext cxt = new InitialContext();
				DataSource dataSource = (DataSource) cxt.lookup("java:comp/env/jdbc/gestionaleHR");
				props.put("javax.persistence.nonJtaDataSource", dataSource);
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, props);
			} catch (NamingException e) {
				e.printStackTrace();
				throw new RuntimeException("Errore durante il recupero della risorsa JNDI.", e);
			}
		}
		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
}
