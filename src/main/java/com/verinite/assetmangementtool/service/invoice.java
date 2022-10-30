package com.verinite.assetmangementtool.service;

import com.verinite.assetmangementtool.entity.AssetsEntity;

public class invoice {

    AssetsEntity assetsEntity= new AssetsEntity();


    public String invoiceNumber(int assetName){
        String invoic = "INV0000"+ assetName;
        return  invoic;
    }


}
