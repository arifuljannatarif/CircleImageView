/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/28/20 9:55 AM
 */

package com.example.hautomation;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.hautomation.common.BaseActivity;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


public class Profile extends BaseActivity {
    ImageView profileImagebg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileImagebg=findViewById(R.id.profile_image_bg);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tahsan Ahmed");
        Glide.with(this)
                .load(R.drawable.peaple)
                .apply(bitmapTransform(new BlurTransformation(5, 5)))
                .into(profileImagebg);
    }
}
