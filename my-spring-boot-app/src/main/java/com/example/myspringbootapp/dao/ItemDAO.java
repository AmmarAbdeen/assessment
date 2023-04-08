package com.example.myspringbootapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myspringbootapp.model.Item;

@Repository
public interface ItemDAO  extends JpaRepository<Item, Long>{
	
	Item findByName(String name);
}
