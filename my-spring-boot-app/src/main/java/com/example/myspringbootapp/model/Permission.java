package com.example.myspringbootapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "permissions")
public class Permission {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "permission_level")
	private String permissionLevel;
	
	@ManyToMany(mappedBy = "permissions")
	private Set<PermissionGroup> permissionGroups = new HashSet<>();
}
