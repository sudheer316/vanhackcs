package com.sudheer.vanhack.cs.miniurl.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author SUDHESHA
 *
 */
public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miniurl");
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
}
