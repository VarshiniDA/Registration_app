package com.registrationapp.model;
//Abstraction
public interface DAOService {
	public void connectDB();
	public boolean verifyCredentials(String email,String password);
	public void saveRegistration(String name, String city, String email, String mobile);
}
