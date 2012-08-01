package com.umang.common.HiberSpring;

public class MainClass {
	public static void main(String args[]){
		HibernateDAO hiberDAO = new HibernateDAO();
		long address = hiberDAO.saveAddress(1,"Mukherjee Nagar","Delhi",110009);
		System.out.println(address);
	}
}
