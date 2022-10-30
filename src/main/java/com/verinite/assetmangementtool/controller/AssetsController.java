package com.verinite.assetmangementtool.controller;


import com.verinite.assetmangementtool.dto.AssetCounterDto;
import com.verinite.assetmangementtool.dto.AssetNameDTO;
import com.verinite.assetmangementtool.entity.AssetsEntity;
import com.verinite.assetmangementtool.service.AssetNameServiceImpl;
import com.verinite.assetmangementtool.service.AssetService;
import com.verinite.assetmangementtool.service.AssetServiceImpl;
import com.verinite.assetmangementtool.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/assetManager/v1/")
public class AssetsController implements ApplicationRunner {
	@Autowired
	AssetNameServiceImpl assetNameServiceImpl;
	@Autowired
	AssetServiceImpl assetService;
	@PostMapping("asset/saveAsset")
	public Object save(@Valid @RequestBody AssetsEntity asset) {
		//LOGGER.debug("Hited Asset save method");
		return assetService.saveAsset(asset);
	}
	@PostMapping("asset/save/bulk")
	public Object BulkSave( @RequestBody List<AssetsEntity> assetList) {
			assetList.forEach(asset->assetService.saveAsset(asset));
			return "Saved Successfully";
	}
	@GetMapping("asset/id/{id}")
	public Object getById(@PathVariable String id) {
		//LOGGER.debug("Hited getById endpoint");
		return assetService.getAssetBySerialNumber(id);
	}
	@GetMapping("asset/getall")
	public List<AssetsEntity> getAll(){
		//LOGGER.debug("Hited getAll endPoint");
		return assetService.getAllAssets();
	}
	@PostMapping("asset/update")
	public Object update(@RequestBody AssetsEntity asset) {
		System.out.println(asset.getAssetName());
		return assetService.updateAsset(asset);
	}
	@GetMapping("asset/delete/{id}")
	public Object delete(@PathVariable int id) {
		//LOGGER.debug("hited delete endPoint");
		System.out.println(id);
		return assetService.deleteAsset(id);
	}
	@GetMapping("asset/get/by/status/{status}")
	public List<AssetsEntity> getThroughStatus(@PathVariable String status){
		//LOGGER.debug("Hited getThroughState endPoint");
		return assetService.getThroughStatus(status);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {


	}
	@GetMapping("asset/assigned")
	public int getAssignedCount() {
		return assetService.getCountOfAssigned();
	}
	@GetMapping("asset/unassigned")
	public int getUnAssignedCount() {
		return assetService.getCountOfUnassigned();
	}
	@GetMapping("asset/laptopcount/{id}")
	public int getLaptopCount(@PathVariable String id) {
		return assetService.getLaptopCountByLocation(id);
	}
	@GetMapping("asset/total/laptop/count")
	public int getTptalLaptopCount() {
		return assetService.totalLaptops();
	}
	@GetMapping("asset/unassigned/{id}")
	public int getUnAssignedByLocation(@PathVariable String id) {
		return assetService.getCountOfUnassignedByLocation(id);
	}
	@GetMapping("asset/get/total/unassigned")
	public List<AssetCounterDto> getUnassignedAndLaptops(){
		return assetService.getUnassignedAndTotalLaptops();
}
	@GetMapping("asset/get/under/warenty")
	public List<AssetsEntity> getLaptopsUnderWarenty() {
		assetService.getLaptopsUnderWarenty();
		return assetService.getLaptopsUnderWarenty();
	}
	@GetMapping("asset/get/over/warenty")
	public List<AssetsEntity> getLaptopsOverWarenty() {
		assetService.getLaptopsOverWarenty();
		return assetService.getLaptopsOverWarenty();
	}
	@GetMapping("asset/return/{serialNo}/{empId}")
	public String returned(@PathVariable String serialNo,@PathVariable String empId) {
		assetService.saveHistory(serialNo,empId);
		return "stored Successfully";
	}
	@PostMapping("assetname/save")
	public AssetNameDTO saveAssetName(@RequestBody AssetNameDTO assetNameDTO)
	{
		return assetNameServiceImpl.save(assetNameDTO);
	}
	@GetMapping("assetname/getall")
	public List<AssetNameDTO> getAllAssetNames(){
		return assetNameServiceImpl.getAll();
	}
	@GetMapping("asset/getUnassigned")
	public List<AssetsEntity> getUnAssigned(){
		return assetService.getUnAssigned();
	}



	@Autowired
	ExcelService fileService;
	@GetMapping("/download/d/{assetid}")
	public ResponseEntity<Resource> getFile() {
		String filename = "tutorials.xlsx";
		InputStreamResource file = new InputStreamResource(fileService.load());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}

	@GetMapping("/download/loc/{location}")
	public ResponseEntity<Resource> getFile1(@PathVariable String location) {
		if (location.equalsIgnoreCase("pune")) {
			String filename = "tutorials.xlsx";
			InputStreamResource file = new InputStreamResource(fileService.load1(location));
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(file);
		} else if (location.equalsIgnoreCase("chennai")) {

			String filename = "tutorialsChennai.xlsx";
			InputStreamResource file = new InputStreamResource(fileService.load1(location));
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(file);
		}
		return null;
	}
	@GetMapping("/download/pur/{purchaseDate}")
	public ResponseEntity<Resource> getFile3(@PathVariable String purchaseDate) {
		String filename = "tutorials.xlsx";
		InputStreamResource file = new InputStreamResource(fileService.load4(purchaseDate));
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);

	}


	@GetMapping("/download/stat/{status}")
	public ResponseEntity<Resource> getFile2(@PathVariable String status) {
		if (status.equalsIgnoreCase("assigned")) {
			String filename = "assigned.xlsx";
			InputStreamResource file = new InputStreamResource(fileService.load1(status));
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(file);
		} else if (status.equalsIgnoreCase("unassigned")) {

			String filename = "unassigned.xlsx";
			InputStreamResource file = new InputStreamResource(fileService.load1(status));
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(file);
		}
		return null;
	}

	@GetMapping("/downloadReport/{location}/{purchasedate}/{status}")
	public ResponseEntity<Resource> getFile4(@PathVariable String location,@PathVariable String purchasedate,@PathVariable String status) {
		String filename = "All.xlsx";
		InputStreamResource file = new InputStreamResource(fileService.load3(location,purchasedate,status));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}
}
