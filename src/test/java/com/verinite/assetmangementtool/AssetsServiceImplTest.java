package com.verinite.assetmangementtool;


import com.verinite.assetmangementtool.entity.AssetsEntity;
import com.verinite.assetmangementtool.repository.AssetsRepository;
import com.verinite.assetmangementtool.service.AssetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AssetsServiceImplTest {

    @Mock
    AssetsRepository assetRepo;

    @Mock
    AssetServiceImpl assetService;

    AssetsEntity assetsEntity = new  AssetsEntity();

    @Test
    public void test_assetByLocation(){
        assetsEntity = dummyAssestEntity();
        String location = "pune";
        assetsEntity.setLocation(location);
        List<AssetsEntity> list = assetRepo.findByLocation(location);
        when(assetRepo.findByLocation(location)).thenReturn(list);
        List<AssetsEntity> response = assetService.assetByLocation(location);
        assertNotNull(response);
    }

    @Test
    public void test_assetByStatus(){
        assetsEntity = dummyAssestEntity();
        String status = "Assigned";
        assetsEntity.setStatus(status);
        List<AssetsEntity> list = assetRepo.findassets(status);
        when(assetRepo.findassets(status)).thenReturn(list);
        List<AssetsEntity> response = assetService.assetByStatus(status);
        assertNotNull(response);
    }

    @Test
    public void test_assetBydata(){
        assetsEntity = dummyAssestEntity();
        assetsEntity.setLocation("chennai");
        assetsEntity.setPurchaseDate("2022/01/09");
        assetsEntity.setStatus("Assigned");
        List<AssetsEntity> list = assetRepo.findassets(assetsEntity.getLocation(),assetsEntity.getPurchaseDate(),assetsEntity.getStatus());
        when(assetRepo.findassets(assetsEntity.getStatus())).thenReturn(list);
        List<AssetsEntity> response = assetService.assetBydata(assetsEntity.getLocation(),assetsEntity.getPurchaseDate(),assetsEntity.getStatus());
        assertNotNull(response);
    }


    AssetsEntity dummyAssestEntity() {
        assetsEntity.setAssetId(1);
        assetsEntity.setAssetName("Laptop");
        assetsEntity.setSerialNumber("123");
        assetsEntity.setEmpId("Voo298");
        assetsEntity.setStatus("Assigned");
        assetsEntity.setType("assest");
        assetsEntity.setPurchaseDate("22-09-2022");
        assetsEntity.setWarrantyDate("22-09-2023");
        assetsEntity.setLocation("pune");
        assetsEntity.setModelName("abc");
        assetsEntity.setOperatingSystem("windows");
        assetsEntity.setReturnDate(new Date(2023 / 12 / 12));
        assetsEntity.setAddedBy("gauri");
        assetsEntity.setAssignedDate(new Date(2022 / 12 / 12));
        assetsEntity.setAssignedBy("gauri");
        return assetsEntity;
    }
}
