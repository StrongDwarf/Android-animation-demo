package com.app.bm.animation_demo.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.app.bm.animation_demo.R;
import com.app.bm.animation_demo.entiy.ColorEvaluator;
import com.app.bm.animation_demo.entiy.MyView2;


public class Animation1Activity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_1);

        MyView2 myview2 = (MyView2)findViewById(R.id.MyView2);
        ObjectAnimator anim = ObjectAnimator.ofObject(myview2,"color",new ColorEvaluator(),"#0000ff","#ff0000");

        //设置自定义View对象，背景颜色属性值&颜色估值器
        //本质逻辑
        //步骤1:根据颜色估值器不管改变值
        //步骤2：调用set()设置背景颜色的属性值(实际上是通过画笔进行颜色设置)
        //步骤3:调用invalidate()刷新视图，即调用onDraw()重新绘制，从而实现动画效果
        anim.setDuration(8000);
        anim.start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}