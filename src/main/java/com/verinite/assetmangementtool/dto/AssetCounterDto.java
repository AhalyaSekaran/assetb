package com.verinite.assetmangementtool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssetCounterDto {
	private String location;
	private int unAssigned;
	private int total;

}
