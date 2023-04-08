package com.example.myspringbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.myspringbootapp.Response;
import com.example.myspringbootapp.model.File;
import com.example.myspringbootapp.model.Item;
import com.example.myspringbootapp.service.FileService;
import com.example.myspringbootapp.service.ItemService;

import lombok.extern.apachecommons.CommonsLog;

@RestController
@RequestMapping("/api/file")
public class FileController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private FileService fileService;

	@PostMapping(value = "/addfile")
	public ResponseEntity<?> createFile(@RequestParam("uploadedFile") MultipartFile uploadedFile) {
		try {
			itemService.createFileItem("assessment.pdf", "backend",uploadedFile);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new Response("0","Success"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
					.body(new Response("2", e.getMessage())
							.toString());
		}

	}
	
	@GetMapping("/viewfile/{fileName}")
	public ResponseEntity<?> getFileMetadata(@PathVariable String fileName) {
		try {
			 File file= fileService.viewFileMetadata(fileName);
			return ResponseEntity.ok(file);
		} catch (Exception e) {
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
					.body(new Response("2", e.getMessage())
							.toString());
		}
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<?> downloadFile(@PathVariable String fileName) {
		try {	
		    byte[] binary= fileService.downloadFileAsBinary(fileName);
		    HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.attachment().filename(fileName).build());
            
            return new ResponseEntity<>(binary, headers, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
					.body(new Response("2", e.getMessage())
							.toString());
		}
	}
	

}
