package com.verinite.assetmangementtool.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@Entity
@Table(name="tbl_assined_assets")
public class AssignedAssetsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="assigned_assets_id")
	private int assignedAssetsId;
	
	private int assetId;
	
	

	private String assetName;
	
	

	private String serialNumber;
	
	

	private String empId;
	
	

	private String status;
	
	

	private String type;
	
	
	private String purchaseDate;
	
	
	private String warrantyDate;
	
	private String location;
	
	private String modelName;
	
	
	private String operatingSystem;
	private Date returnDate;
	private String addedBy;
	private Date assignedDate;
	private String assignedBy;
}
