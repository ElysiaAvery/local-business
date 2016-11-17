package com.example.guest.localbusiness;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.aboutLink) TextView mAboutLink;
    @Bind(R.id.contactLink) TextView mContactLink;
    @Bind(R.id.productLink) TextView mProductLink;
    @Bind(R.id.signoutButton) Button mSignoutButton;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            // User is logged in
        }

        Typeface goudyFont = Typeface.createFromAsset(getAssets(), "fonts/goudy_bookletter_1911.otf");
        mAboutLink.setTypeface(goudyFont);
        mContactLink.setTypeface(goudyFont);
        mProductLink.setTypeface(goudyFont);

        mAboutLink.setOnClickListener(this);
        mContactLink.setOnClickListener(this);
        mProductLink.setOnClickListener(this);
        mSignoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mAboutLink) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else if (v == mContactLink) {
            Intent intent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(intent);
        } else if (v == mProductLink) {
            Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
            startActivity(intent);
        } else if(v == mSignoutButton) {
            auth.signOut();

// this listener will be called when there is change in firebase user session
            FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user == null) {
                        // user auth state is changed - user is null
                        // launch login activity
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    }
                }
            };
        }
    }
}
