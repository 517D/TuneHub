package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.song;
import com.example.demo.repositary.songrepositsry;
@Service
public class songserviceImplemetation implements songservice{
	@Autowired	
	songrepositsry repo;
	@Override
	public void addsong(song song) {
		repo.save(song);

	}
	@Override
	public List<song> fetchallsongs() {

		return repo.findAll();
	}
	@Override
	public boolean songexit(String name) {
		if(repo.findByName(name)==null) {
			return false;
		}
		else {
			return true;
		}
	
	}
	@Override
	public void updatesong(song song) {
	repo.save(song);
		
	}

}
