package com.app.bm.animation_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.app.bm.animation_demo.R;


public class AnimationOfObecjtActivity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_of_object);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}