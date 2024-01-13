package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.song;

public interface songrepositsry extends JpaRepository<song, Integer>{
  

public song findByName(String name);
}
