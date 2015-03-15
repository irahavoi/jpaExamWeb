package com.rahavoi.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ShoppingBean
 */
@Stateless
@LocalBean
public class ShoppingBean {

	public String getBeanInfo(){
		return "ShoppingBean - Stateless Session Bean";
	}
}
