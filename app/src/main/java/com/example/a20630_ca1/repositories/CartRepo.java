package com.example.a20630_ca1.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a20630_ca1.models.Product;
import com.example.a20630_ca1.models.SelectedTea;

import java.util.ArrayList;
import java.util.List;

public class CartRepo {

    private MutableLiveData<List<SelectedTea>> mutableCart = new MutableLiveData<>();
    private MutableLiveData<Double> mutableTotalPrice = new MutableLiveData<>();

    public LiveData<List<SelectedTea>> getCart() {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        return mutableCart;
    }

    public void initCart() {
        mutableCart.setValue(new ArrayList<SelectedTea>());
        calculateCartTotal();
    }

    public boolean addItemToCart(Product product) {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        List<SelectedTea> selectedTeaList = new ArrayList<>(mutableCart.getValue());
        for (SelectedTea selectedTea : selectedTeaList) {
            if (selectedTea.getProduct().getId().equals(product.getId())) {
                if (selectedTea.getQuantity() == 10) {
                    return false;
                }

                int index = selectedTeaList.indexOf(selectedTea);
                selectedTea.setQuantity(selectedTea.getQuantity() + 1);
                selectedTeaList.set(index, selectedTea);

                mutableCart.setValue(selectedTeaList);
                calculateCartTotal();
                return true;
            }
        }
        SelectedTea selectedTea = new SelectedTea(product, 1);
        selectedTeaList.add(selectedTea);
        mutableCart.setValue(selectedTeaList);
        calculateCartTotal();
        return true;
    }

    public void removeItemFromCart(SelectedTea selectedTea) {
        if (mutableCart.getValue() == null) {
            return;
        }
        List<SelectedTea> selectedTeaList = new ArrayList<>(mutableCart.getValue());
        selectedTeaList.remove(selectedTea);
        mutableCart.setValue(selectedTeaList);
        calculateCartTotal();
    }

    public  void changeQuantity(SelectedTea selectedTea, int quantity) {
        if (mutableCart.getValue() == null) return;

        List<SelectedTea> selectedTeaList = new ArrayList<>(mutableCart.getValue());

        SelectedTea updatedItem = new SelectedTea(selectedTea.getProduct(), quantity);
        selectedTeaList.set(selectedTeaList.indexOf(selectedTea), updatedItem);

        mutableCart.setValue(selectedTeaList);
        calculateCartTotal();
    }

    private void calculateCartTotal() {
        if (mutableCart.getValue() == null) return;
        double total = 0.0;
        double totalincd = 0.00;
        double delivery = 5.00;
        int quantityItems = 0;
        List<SelectedTea> selectedTeaList = mutableCart.getValue();
        for (SelectedTea selectedTea : selectedTeaList) {
            total += selectedTea.getProduct().getPrice() * selectedTea.getQuantity();
        }
        quantityItems = selectedTeaList.size();
        System.out.println(quantityItems);
        if (quantityItems > 5)
            totalincd = total + delivery;
        else
            totalincd = total + 0;
        mutableTotalPrice.setValue(totalincd);
    }

    public LiveData<Double> getTotalPrice() {
        if (mutableTotalPrice.getValue() == null) {
            mutableTotalPrice.setValue(0.0);
        }
        return mutableTotalPrice;
    }

}