package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.song;
import com.example.demo.services.songservice;

@Controller
public class songcontroler {
	@Autowired
	songservice sr;
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute song song) {
		boolean songstates=sr.songexit(song.getName());
		if(songstates==false) {
			sr.addsong(song);
			System.out.println("song add");

		}
		else {
			System.out.println("son already exit");
		}
		return "home";
	}

	@GetMapping("/viewsong")
	public String viewsong(Model model) {
		List<song>songlist=sr.fetchallsongs();
		model.addAttribute("song", songlist);
		return "displaysong";
	}
	@GetMapping("/playsong")
	public String playsong(Model model) {
		boolean premeum=false;
		if (premeum==true) {
			List<song>songlist=sr.fetchallsongs();
			model.addAttribute("song", songlist);
			return "displaysong";
		}else {
			{
				return"makepayment";
			}
		}

	}
}