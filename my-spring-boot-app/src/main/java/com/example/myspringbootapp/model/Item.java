package com.example.myspringbootapp.model;


import javax.persistence.Table;

import com.example.myspringbootapp.enums.ItemType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "item")
public class Item {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	@Enumerated(EnumType.STRING)
	 	@Column(name = "type")
	    private ItemType type;
	 	 
	 	@Column(name = "name")
	 	private String name;
	 	
	 	@ManyToOne
	    @JoinColumn(name = "permission_group_id")
	    private PermissionGroup permissionGroup;
	 	
	 	@ManyToOne
	    @JoinColumn(name = "parent_id")
	    private Item parent;

}
