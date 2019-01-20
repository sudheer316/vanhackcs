package com.sudheer.vanhack.cs.miniurl.urls;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import com.sudheer.vanhack.cs.miniurl.util.JPAUtil;


/**
 * @author SUDHESHA
 *
 */
public class UrlMapDAO {

	// save Account
	/**
	 * @param urlMap
	 */
	public void save(UrlMap urlMap) {
		System.out.println("Inside save...");
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		// set time stamps
		if (urlMap.getCreatedOn() == null) {
			urlMap.setCreatedOn(Calendar.getInstance());
		}
		em.persist(urlMap);
		em.getTransaction().commit();
		em.close();
	}

	public void merge(UrlMap urlMap) {
		System.out.println("Inside merge...");
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		// set time stamps
		if (urlMap.getCreatedOn() == null) {
			urlMap.setCreatedOn(Calendar.getInstance());
		}
		em.merge(urlMap);
		em.getTransaction().commit();
		em.close();
	}

	// query unique Account
	public UrlMap findByID(String shortUrl) {
		System.out.println("Inside findByID...");
		EntityManager em = new JPAUtil().getEntityManager();
		UrlMap urlmap = em.createQuery("select distinct c from UrlMap c where c.shotrurl='"+shortUrl+"'", UrlMap.class).getSingleResult();
		return urlmap;
	}

	// query all Accounts
	public List<UrlMap> findAll() {
		System.out.println("Inside findAll...");
		EntityManager em = new JPAUtil().getEntityManager();
		List<UrlMap> urlsList = em.createQuery("select c from UrlMap c", UrlMap.class).getResultList();
		return urlsList;
	}

	// delete Account
	public void delete(UrlMap urlMap) {
		System.out.println("Inside delete...");
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.remove(urlMap);
		em.getTransaction().commit();
		em.close();
	}
}
