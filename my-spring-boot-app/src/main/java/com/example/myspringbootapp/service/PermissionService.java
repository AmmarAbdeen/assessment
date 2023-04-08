package com.example.myspringbootapp.service;


import org.springframework.stereotype.Service;

import com.example.myspringbootapp.enums.PermissionLevel;
import com.example.myspringbootapp.model.Item;
import com.example.myspringbootapp.model.Permission;
import com.example.myspringbootapp.model.PermissionGroup;


@Service
public class PermissionService {
	
	public Permission createPermission(String permissionType) {
		Permission permission = new Permission();
		permission.setPermissionLevel(permissionType);
		permission.setUserEmail("usr@mail.com");
		return permission;
	}
	
	public boolean checkUserPermission(PermissionGroup permissionGroup,String permissionLevel) {
		for(Permission permission : permissionGroup.getPermissions() ) {
			if(permission.getPermissionLevel().equals(permissionLevel)) {
				return true;
			}
		}
		return false;		
	}

}
