package com.example.a20630_ca1.models;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

public class SelectedTea {

    private Product product;
    private int quantity;

    public SelectedTea(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedTea selectedTea = (SelectedTea) o;
        return getQuantity() == selectedTea.getQuantity() &&
                getProduct().equals(selectedTea.getProduct());
    }

    @BindingAdapter("android:setVal")
    public static void getSelectedSpinnerValue(Spinner spinner, int quantity) {
        spinner.setSelection(quantity - 1, true);
    }

    public static DiffUtil.ItemCallback<SelectedTea> itemCallback = new DiffUtil.ItemCallback<SelectedTea>() {
        @Override
        public boolean areItemsTheSame(@NonNull SelectedTea oldItem, @NonNull SelectedTea newItem) {
            return oldItem.getQuantity() == newItem.getQuantity();
        }

        @Override
        public boolean areContentsTheSame(@NonNull SelectedTea oldItem, @NonNull SelectedTea newItem) {
            return oldItem.equals(newItem);
        }
    };

}