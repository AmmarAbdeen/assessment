package com.example.myspringbootapp.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.myspringbootapp.dao.FileDAO;
import com.example.myspringbootapp.enums.PermissionLevel;
import com.example.myspringbootapp.model.File;
import com.example.myspringbootapp.model.Item;

@Service
public class FileService {
	@Autowired
	private FileDAO fileDAO;
	@Autowired
	private PermissionService permissionService;
	
	public File createFile(Item fileItem,MultipartFile uploadedFile) throws IOException {
		File file = new File();
		file.setBinary(uploadedFile.getBytes());
		file.setItem(fileItem);
		return fileDAO.save(file);
	}

	public File viewFileMetadata (String fileName) throws Exception{
		File file = fileDAO.findByItemName(fileName);
		if(!permissionService.checkUserPermission(file.getItem().getPermissionGroup(),PermissionLevel.VIEW.toString())) {
			throw new Exception("You don't have permission to view this file");
			}
		return file;
	}
	
	public byte[] downloadFileAsBinary (String fileName) throws Exception{
		File file = fileDAO.findByItemName(fileName);
		if(!permissionService.checkUserPermission(file.getItem().getPermissionGroup(),PermissionLevel.VIEW.toString())) {
			throw new Exception("You don't have permission to download this file");
			}
		return file.getBinary();
	}
}
