package com.example.a20630_ca1.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a20630_ca1.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProduts(){
        if (mutableProductList ==null){
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }
    private void loadProducts(){
        List<Product> productList= new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Assam", 7,50));
        productList.add(new Product(UUID.randomUUID().toString(), "Darjelling", 8,50));
        productList.add(new Product(UUID.randomUUID().toString(), "Lapsang", 9,50));
        productList.add(new Product(UUID.randomUUID().toString(), "Earl Grey", 3,50 ));
        productList.add(new Product(UUID.randomUUID().toString(), "Irish Breakfast", 2,50));


        mutableProductList.setValue(productList);
    }

}





