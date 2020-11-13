package com.example.a20630_ca1.viewmodels;

import android.widget.LinearLayout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20630_ca1.models.CartItem;
import com.example.a20630_ca1.models.Product;
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
    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }

    public boolean addItemToCart(Product product) {
        return cartRepo.addItemToCart(product);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }

}


