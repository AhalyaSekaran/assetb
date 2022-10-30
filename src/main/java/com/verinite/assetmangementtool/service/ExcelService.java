package com.verinite.assetmangementtool.service;

import com.verinite.assetmangementtool.entity.AssetsEntity;
import com.verinite.assetmangementtool.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
@Service
public class ExcelService {
    @Autowired
    AssetsRepository repository;

    public ByteArrayInputStream load1(String location) {
        List<AssetsEntity> tutorials = repository.findByLocation(location);

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }

    public ByteArrayInputStream load2(String status) {
        List<AssetsEntity> tutorials = repository.findassets(status);

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }

    public ByteArrayInputStream load4(String purchasedate) {
        List<AssetsEntity> tutorials = repository.findassets(purchasedate);

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }
    public ByteArrayInputStream load3(String location,String purchasedate,String status) {
        List<AssetsEntity> tutorials = repository.findassets(location,purchasedate,status);

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }

    public ByteArrayInputStream load() {
        List<AssetsEntity> tutorials = repository.findAll();

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }


}


