package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.example.demo.entity.user;
import com.example.demo.repositary.userrepositary;

import ch.qos.logback.core.joran.conditional.ElseAction;
@Service
public class userserviceImplemetation implements userservice{
	@Autowired
	userrepositary ur;
	@Override
	public String adduser(user usr) {
		ur.save(usr);
		return "user add succesufully";
	}
	@Override
	public boolean emailexit(String email) {
		if(ur.findByEmail(email)==null)
		{
			return false;
		}
		else {
			return true;
		}

	}
	@Override
	public boolean validateuser(String email, String password)
	{
		user user=ur.findByEmail(email);
		String db_pass=user.getPassword();
		if(password.equals(db_pass))
		{
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String getRole(String email) {
		user user=ur.findByEmail(email);
		return user.getRole();

	}
	@Override
	public user getUser(String email) {
		return ur.findByEmail(email);
	}
	@Override
	public void updateuser(user user) {
		 ur.save(user);
		
	}




}
