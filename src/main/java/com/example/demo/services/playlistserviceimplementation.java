package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.playlist;
import com.example.demo.repositary.playlistrepositary;


@Service
public class playlistserviceimplementation implements playlistservice
{   @Autowired
   playlistrepositary repo;
	@Override
	public void addplaylist(playlist playlist) {
		repo.save(playlist);
	}
	@Override
	public List<playlist> fetchallplaylist() {
		
		return repo.findAll();
	}

}
