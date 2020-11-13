package com.example.a20630_ca1.viewmodels;

import android.widget.LinearLayout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20630_ca1.models.Product;
import com.example.a20630_ca1.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel{

    ShopRepo shopRepo = new ShopRepo();
    MutableLiveData<Product> mudableProduct = new MutableLiveData<>();

    public LiveData<List<Product>> getProducts(){

        return shopRepo.getProduts();
    }

    public void setProduct(Product product){
        mudableProduct.setValue(product);
    }

     public LiveData<Product> getProduct(){

        return mudableProduct;
     }
}


