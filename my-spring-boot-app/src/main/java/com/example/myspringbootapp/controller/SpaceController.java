package com.example.myspringbootapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.myspringbootapp.model.Item;
import com.example.myspringbootapp.model.PermissionGroup;
import com.example.myspringbootapp.service.PermissiomGroupService;
import com.example.myspringbootapp.service.ItemService;


@RestController
@RequestMapping("/api/space")
public class SpaceController {
	
	@Autowired
	private ItemService itemService; 
	@Autowired
	private PermissiomGroupService permissiomGroupService; 
	
	@PostMapping(value = "/addspace")
	public ResponseEntity<?> createSpace() {
		
			PermissionGroup permissionGroup = permissiomGroupService.createPermissionGroupWithViewAndEditAccess("Admin");
		
			Item item = itemService.createSpace("stc-assessments", permissionGroup);
			
			return ResponseEntity.ok(item);
		
	}

}
