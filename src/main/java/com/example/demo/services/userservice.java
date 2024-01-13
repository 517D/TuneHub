package com.example.demo.services;

import com.example.demo.entity.user;

public interface userservice {
	public String adduser(user user);
	public boolean emailexit(String email);
    public boolean validateuser(String email,String password);
	public String getRole(String email);
	public user  getUser(String email);
    public void updateuser(user user);
		
	
}
