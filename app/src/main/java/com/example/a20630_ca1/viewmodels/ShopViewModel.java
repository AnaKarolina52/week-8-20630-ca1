package com.example.a20630_ca1.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20630_ca1.models.Product;
import com.example.a20630_ca1.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel{

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProducts(){

        return shopRepo.getProduts();
    }
}


