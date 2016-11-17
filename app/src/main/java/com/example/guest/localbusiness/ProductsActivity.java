package com.example.guest.localbusiness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
//    private String[] products = new String[] {"Wheat Bread", "Rye Bread", "Sourdough Bread",
//            "Dill Pickles", "Sweet Pickles"};

    private ArrayList<Product> products = new ArrayList<>();
    private ProductListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        products.add(new Product("Wheat Bread", "Awesome"));
        products.add(new Product("Rye Bread0", "It's okay"));
        products.add(new Product("Rye Bread1", "It's okay"));
        products.add(new Product("Rye Bread2", "It's okay"));
        products.add(new Product("Rye Bread3", "It's okay"));
        products.add(new Product("Rye Bread4", "It's okay"));
        products.add(new Product("Rye Bread5", "It's okay"));
        products.add(new Product("Rye Bread6", "It's okay"));
        products.add(new Product("Rye Bread7", "It's okay"));
        products.add(new Product("Rye Bread8", "It's okay"));
        products.add(new Product("Rye Bread9", "It's okay"));
        products.add(new Product("Rye Bread10", "It's okay"));
        products.add(new Product("Rye Bread11", "It's okay"));
        products.add(new Product("Rye Bread12", "It's okay"));
        products.add(new Product("Rye Bread13", "It's okay"));
        products.add(new Product("Rye Bread14", "It's okay"));
        products.add(new Product("Rye Bread15", "It's okay"));
        products.add(new Product("Rye Bread16", "It's okay"));

        mAdapter = new ProductListAdapter(getApplicationContext(), products);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProductsActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }
}
