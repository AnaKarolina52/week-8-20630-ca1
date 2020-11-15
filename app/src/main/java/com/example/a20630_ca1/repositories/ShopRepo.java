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
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Darjelling", 0,8.5));
        productList.add(new Product(UUID.randomUUID().toString(), "Assam", 0,7.50));
        productList.add(new Product(UUID.randomUUID().toString(), "Lapsang", 0,9.50));
        productList.add(new Product(UUID.randomUUID().toString(), "Earl Grey", 0,3.5 ));
        productList.add(new Product(UUID.randomUUID().toString(), "Irish Breakfast", 0,2.5));


        mutableProductList.setValue(productList);
    }

}





