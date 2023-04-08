package com.example.myspringbootapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myspringbootapp.model.Permission;

@Repository
public interface PermissionDAO extends JpaRepository<Permission, Long>{

}
