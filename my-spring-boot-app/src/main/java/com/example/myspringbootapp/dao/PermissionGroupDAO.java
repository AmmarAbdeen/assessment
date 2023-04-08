package com.example.myspringbootapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myspringbootapp.model.PermissionGroup;


@Repository
public interface PermissionGroupDAO extends JpaRepository<PermissionGroup, Long>{

}
