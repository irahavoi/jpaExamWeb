package com.rahavoi.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CartBean
 */
@Stateful
@LocalBean
public class CartBean {
	
	Integer calledTimes = 0;

    public String getInfo(){
    	calledTimes++;
    	return "Cart - Stateful Session Bean. (" + calledTimes + ")";
    }

}
