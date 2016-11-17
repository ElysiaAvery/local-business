package com.example.guest.localbusiness;

import org.parceler.Parcel;

/**
 * Created by Guest on 11/17/16.
 */

@Parcel
public class Product {
    String mName;
    String mDescription;

    public Product() {}

    public Product(String name, String description) {
        this.mName = name;
        this.mDescription = description;
    }

    String getName() {
        return this.mName;
    }

    String getDescription() {
        return this.mDescription;
    }
}
