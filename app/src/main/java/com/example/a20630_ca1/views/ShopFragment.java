package com.example.a20630_ca1.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a20630_ca1.R;
import com.example.a20630_ca1.adapters.ShopListAdapter;
import com.example.a20630_ca1.databinding.FragmentShopBinding;
import com.example.a20630_ca1.models.Product;
import com.example.a20630_ca1.viewmodels.ShopViewModel;

import java.util.List;


public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface{

    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModel shopViewModel;

    public ShopFragment(){

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding = FragmentShopBinding.inflate(inflater, container,false);
        return fragmentShopBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState){
        super.onViewCreated(view, saveInstanceState);

    shopListAdapter = new ShopListAdapter();
    fragmentShopBinding.shopRecycleView.setAdapter(shopListAdapter);

    shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
    shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
        @Override
        public void onChanged(List<Product> products) {
            shopListAdapter.submitList(products);

        }
    });
 }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {

    }
}