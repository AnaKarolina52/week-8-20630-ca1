package com.example.a20630_ca1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a20630_ca1.databinding.ShopRowBinding;
import com.example.a20630_ca1.models.Product;



 public class ShopListAdapter extends ListAdapter<Product, ShopListAdapter.ShopViewHolder> {

     ShopInterface shopInterface;

     public ShopListAdapter(ShopInterface shopInterface) {

         super(Product.itemCallback);
         this.shopInterface = shopInterface;
     }

     @NonNull
     @Override
     public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
         ShopRowBinding showRowBinding = ShopRowBinding.inflate(layoutInflater, parent, false);
         showRowBinding.setShopInterface(shopInterface);
         return new ShopViewHolder(showRowBinding);
     }

     @Override
     public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
         Product product = getItem(position);
         holder.shopRowBinding.setProduct(product);

     }

     class ShopViewHolder extends RecyclerView.ViewHolder{

         ShopRowBinding shopRowBinding;

         public ShopViewHolder(ShopRowBinding binding){
             super(binding.getRoot());
             this.shopRowBinding = binding;


         }

     }

     public interface ShopInterface{
         void addItem(Product product);
         void onItemClick(Product product);
     }


}
