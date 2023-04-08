package com.example.myspringbootapp.service;

import com.example.myspringbootapp.enums.PermissionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.myspringbootapp.dao.ItemDAO;
import com.example.myspringbootapp.enums.ItemType;
import com.example.myspringbootapp.model.File;
import com.example.myspringbootapp.model.Item;
import com.example.myspringbootapp.model.PermissionGroup;




@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private FileService fileService;
	
	public Item createSpace (String spaceName,PermissionGroup permissionGroup) {
		Item space = new Item();
		space.setName(spaceName);
		space.setType(ItemType.SPACE);
		space.setPermissionGroup(permissionGroup);
		
		return itemDAO.save(space);
	}
	
	public Item createFolder (String folderName,String parentName) throws Exception{
		Item parentSpace = itemDAO.findByName(parentName);
		if(!permissionService.checkUserPermission(parentSpace.getPermissionGroup(), PermissionLevel.EDIT.toString())) {
			throw new Exception("You don't have permission to create a folder in this space");
		}			
		Item folder = new Item();
		folder.setName(folderName);
		folder.setType(ItemType.FOLDER);
		folder.setPermissionGroup(parentSpace.getPermissionGroup());
		folder.setParent(parentSpace);
		return itemDAO.save(folder);
	}
	
	public void createFileItem (String fileName,String parentName,MultipartFile uploadedFile ) throws Exception{
		Item parentSpace = itemDAO.findByName(parentName);
		if(!permissionService.checkUserPermission(parentSpace.getPermissionGroup(),PermissionLevel.EDIT.toString())) {
			throw new Exception("You don't have permission to create a file in this folder");
		}			
		Item fileItem = new Item();
		fileItem.setName(fileName);
		fileItem.setType(ItemType.FOLDER);
		fileItem.setPermissionGroup(parentSpace.getPermissionGroup());
		fileItem.setParent(parentSpace);
        fileItem =  itemDAO.save(fileItem);
        
       fileService.createFile(fileItem,uploadedFile);
        		
	}

	
}
