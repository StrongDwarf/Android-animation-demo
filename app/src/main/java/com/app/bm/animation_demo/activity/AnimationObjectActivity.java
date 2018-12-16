package com.app.bm.animation_demo.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewAnimator;

import com.app.bm.animation_demo.R;


public class AnimationObjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

        /**
         * 设置透明度动画
         */
        Button mButton = (Button)findViewById(R.id.btn_alpha);
        ObjectAnimator animator = ObjectAnimator.ofFloat(mButton,"alpha",1f,0f);

        animator.setDuration(5000);
        animator.setRepeatCount(2000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

        /**
         * 设置旋转动画
         */
        Button button_rotate = (Button)findViewById(R.id.btn_rotation);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(button_rotate,"rotation",0f,360f);
        animator1.setDuration(5000);
        animator1.setRepeatCount(2000);
        animator1.setRepeatMode(ValueAnimator.REVERSE);
        animator1.start();

        /**
         * 设置平移
         */
        Button button_translationX = (Button)findViewById(R.id.btn_translationX);
        //获取按钮当前位置
        float curTranslationX = mButton.getTranslationX();
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(button_translationX,"translationX",curTranslationX,300);
        animator2.setDuration(5000);
        animator2.setRepeatCount(2000);
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.start();

        /**
         * 设置缩放
         */
        Button button_scaleX = (Button)findViewById(R.id.btn_scaleX);
        //获取按钮当前位置
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(button_scaleX,"scaleX",1f,3f);
        animator3.setDuration(5000);
        animator3.setRepeatCount(2000);
        animator3.setRepeatMode(ValueAnimator.REVERSE);
        animator3.start();
    }

}