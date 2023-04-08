package com.example.myspringbootapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "permission_group")
public class PermissionGroup {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "group_name")
 	private String groupName;

	 @ManyToMany
	 @JoinTable(
	        name = "permission_group_permissions",
	        joinColumns = @JoinColumn(name = "permission_group_id"),
	        inverseJoinColumns = @JoinColumn(name = "permission_id")
	  )
	 private Set<Permission> permissions = new HashSet<>();

	 public void addPermission(Permission permission) {
		 	permissions.add(permission);
		 	permission.getPermissionGroups().add(this);
	    }
	 
	 public void removePermission(Permission permission) {
	    	permissions.remove(permission);
	    	permission.getPermissionGroups().remove(this);
	    }

}
