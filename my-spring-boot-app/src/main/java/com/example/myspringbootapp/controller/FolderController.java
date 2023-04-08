package com.example.myspringbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.myspringbootapp.Response;
import com.example.myspringbootapp.model.Item;
import com.example.myspringbootapp.service.ItemService;


@RestController
@RequestMapping("/api/folder")
public class FolderController {

	@Autowired
	private ItemService itemService;


	@PostMapping(value = "/addfolder")
	public ResponseEntity<?> createFolder() {
		try {
			Item item = itemService.createFolder("backend", "stc-assessments");
			return ResponseEntity.ok(item);
		} catch (Exception e) {
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
					.body(new Response("2", e.getMessage())
							.toString());
		}

	}
}
