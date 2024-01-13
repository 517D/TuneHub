package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.user;

public interface userrepositary extends JpaRepository<user, Integer>{
   public user findByEmail(String email); 
	

}
