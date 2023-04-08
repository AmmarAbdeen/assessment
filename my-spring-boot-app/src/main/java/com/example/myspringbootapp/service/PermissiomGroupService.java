package com.example.myspringbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringbootapp.dao.PermissionGroupDAO;
import com.example.myspringbootapp.enums.PermissionLevel;
import com.example.myspringbootapp.model.Permission;
import com.example.myspringbootapp.model.PermissionGroup;

@Service
public class PermissiomGroupService {
	
	@Autowired
	private PermissionGroupDAO permissionGroupDAO;
	@Autowired
	private PermissionService permissionService;
	
	public PermissionGroup createPermissionGroupWithViewAndEditAccess(String permissionGroupName) {
		PermissionGroup permissionGroup = new PermissionGroup();
		permissionGroup.setGroupName(permissionGroupName);
		
		Permission viewPermission = permissionService.createPermission(PermissionLevel.VIEW.toString());
		
		Permission editPermission = permissionService.createPermission(PermissionLevel.EDIT.toString());
		
		permissionGroup.addPermission(editPermission);
		permissionGroup.addPermission(viewPermission);
		
		return permissionGroupDAO.save(permissionGroup);
		
	}
	

}
