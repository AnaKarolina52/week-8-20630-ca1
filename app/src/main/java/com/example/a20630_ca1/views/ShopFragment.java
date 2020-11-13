package com.example.a20630_ca1.views;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
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

    private static final String TAG = "ShopFragment";

    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModel shopViewModel;
    private NavController navController;

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

    shopListAdapter = new ShopListAdapter(this);
    fragmentShopBinding.shopRecycleView.setAdapter(shopListAdapter);

    shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
    shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
        @Override
        public void onChanged(List<Product> products) {
            shopListAdapter.submitList(products);

        }
    });
    navController = Navigation.findNavController(view);
 }

    @Override
    public void addItem(Product product) {

        Log.d( TAG, "onIntemClick: " + product.toString());
        shopViewModel.setProduct(product);
        navController.navigate(R.id.action_shopFragment_to_productFragment);
    }

    @Override
    public void onItemClick(Product product) {

    }
}