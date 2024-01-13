package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.playlist;
import com.example.demo.entity.song;
import com.example.demo.services.playlistservice;
import com.example.demo.services.songservice;



@Controller
public class playlistcontrooler {
	@Autowired
	songservice songsr;
	@Autowired
	playlistservice playlistservice;
	@GetMapping("/createplaylist")
	public String createplaylist(Model model)
	{
		List<song> songlist=songsr.fetchallsongs();
		model.addAttribute("songs", songlist);
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute playlist playlist) {
		playlistservice.addplaylist(playlist);
		List<song>songList=playlist.getSongs();
		for(song s:songList) {
			s.getPlaylists().add(playlist);
			songsr.updatesong(s);
		}
		return "adminhome";
	}
	@GetMapping("/viewalllist")
	public String viewalllist(Model model) {
		List<playlist> allplayList=playlistservice.fetchallplaylist();
		model.addAttribute("allplayList", allplayList);
		return "displayplaylist";
	}

}
