package com.example.myspringbootapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myspringbootapp.model.File;

@Repository
public interface FileDAO extends JpaRepository<File, Long> {
	
	File findByItemName (String fileName);

}
