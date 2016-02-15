package com.investproj.test;

import org.junit.Ignore;
import org.junit.Test;

import com.investproj.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Ignore
	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
