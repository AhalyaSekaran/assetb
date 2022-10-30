package com.verinite.assetmangementtool.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tbl_asset_names")
public class AssetNameDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assetNameId;
	private String assetName;
}
