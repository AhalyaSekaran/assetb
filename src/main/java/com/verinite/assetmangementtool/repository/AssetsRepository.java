package com.verinite.assetmangementtool.repository;

import com.verinite.assetmangementtool.entity.AssetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssetsRepository extends JpaRepository<AssetsEntity, Number> {


	List<AssetsEntity> findByStatus(String str);
	
	@Query(value = "select laptop_count from tbl_Count where id=?1",nativeQuery = true)	
	int getTotal(int id);

	AssetsEntity findBySerialNumber(String id);

	@Query(value ="select * from tbl_assets where location=?1",nativeQuery = true)
	List<AssetsEntity> findByLocation(String location);
	List<AssetsEntity> findByPurchaseDate(String purchaseDate);

	@Query(value ="select * from tbl_assets where location=?1",nativeQuery = true)
	String getLocation(String location);

	//	AssetsEntity findByPurcheseDate(String purcheseDate);
//	@Query(value = 	"select * from tbl_assets where  purchase_date=?1",nativeQuery = true)
//	String getpurchaseDate(String purchasedate);
	@Query(value = "select * from tbl_assets where  status=?1",nativeQuery = true)

	List<AssetsEntity> findassets(String status);
	@Query(value ="select * from tbl_assets where location=?1 and purchase_date=?2 and status=?3 ",nativeQuery = true)

	List<AssetsEntity> findassets(String location, String purchasedate, String status);

//	String getstatus(String status);
//
//	List<AssetsEntity> findassets(String assinged);

//	AssetsEntity findByLocation1(String location);
//	@Query(value ="select * from tbl_assets where location=?1",nativeQuery = true)
//	String getLocation1(String location);


//	@Query(value = "", nativeQuery = true)
//	AssetsEntity findByAssertId(int id);

	

	
	
	

}
