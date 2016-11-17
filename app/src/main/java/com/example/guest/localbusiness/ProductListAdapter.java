package com.example.guest.localbusiness;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private ArrayList<Product> mProducts = new ArrayList<>();
    private Context mContext;

    public ProductListAdapter(Context context, ArrayList<Product> products) {
        mContext = context;
        mProducts = products;
    }

    @Override
    public ProductListAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductListAdapter.ProductViewHolder holder, int position) {
        holder.bindProduct(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.productNameTextView) TextView mNameTextView;
        @Bind(R.id.descriptionTextView) TextView mDescriptionTextView;
        private Context mContext;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindProduct(Product product) {
            mNameTextView.setText(product.getName());
            mDescriptionTextView.setText(product.getDescription());

        }
    }
}