package com.verinite.assetmangementtool.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name="tbl_assets")
public class AssetsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "asset_id",nullable = false)
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
