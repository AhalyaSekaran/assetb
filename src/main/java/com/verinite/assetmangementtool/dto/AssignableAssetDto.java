package com.verinite.assetmangementtool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AssignableAssetDto {
	
	private String empId;
	private String serialNumber;
	private Date assignedDate;
	private String assignedBy;

}
