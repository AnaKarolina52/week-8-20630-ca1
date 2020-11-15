package com.example.a20630_ca1.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20630_ca1.models.Product;
import com.example.a20630_ca1.models.SelectedTea;
import com.example.a20630_ca1.repositories.CartRepo;
import com.example.a20630_ca1.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel{

    ShopRepo shopRepo = new ShopRepo();
    CartRepo cartRepo = new CartRepo();


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
    public LiveData<List<SelectedTea>> getCart() {
        return cartRepo.getCart();
    }

    public boolean addItemToCart(Product product) {
        return cartRepo.addItemToCart(product);
    }

    public void removeItemFromCart(SelectedTea selectedTea) {
        cartRepo.removeItemFromCart(selectedTea);
    }

    public void changeQuantity(SelectedTea selectedTea, int quantity) {
        cartRepo.changeQuantity(selectedTea, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }

}


