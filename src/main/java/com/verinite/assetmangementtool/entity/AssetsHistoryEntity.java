package com.verinite.assetmangementtool.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name ="tbl_assets_history")
public class AssetsHistoryEntity {	
	

	



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long historyId;
	private int assetId;
	private String assetName;
	private String serialNumber;
	private Date returnDate;
	private String status;
	private String type;
	private String purchaseDate;
	private String warrantyDate;
	private String empId;
	private String location;
	private String modelName;
	private String operatingSystem;
	private Date assignedDate;
	private String assignedBy;
	

	
	
}
