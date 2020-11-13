package com.example.a20630_ca1.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a20630_ca1.R;
import com.example.a20630_ca1.databinding.FragmentProductBinding;
import com.example.a20630_ca1.viewmodels.ShopViewModel;

public class ProductFragment extends Fragment {

    FragmentProductBinding fragmentProductBinding;
    ShopViewModel shopViewModel;

    public  ProductFragment(){


}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentProductBinding = FragmentProductBinding.inflate(inflater, container, false);
        return fragmentProductBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        fragmentProductBinding.setShopViewModel(shopViewModel);
    }

}