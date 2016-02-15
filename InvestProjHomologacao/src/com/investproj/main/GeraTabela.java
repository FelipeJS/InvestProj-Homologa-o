package com.investproj.main;

import com.investproj.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();	
	}

}
