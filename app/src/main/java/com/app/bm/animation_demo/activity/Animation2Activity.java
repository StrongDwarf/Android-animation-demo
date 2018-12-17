package com.app.bm.animation_demo.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.app.bm.animation_demo.R;
import com.app.bm.animation_demo.entiy.ColorEvaluator;
import com.app.bm.animation_demo.entiy.MyView2;


public class Animation2Activity extends AppCompatActivity implements  View.OnClickListener {
    Button mButton;
    ViewWrapper wrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_2);

        mButton = (Button)findViewById(R.id.Button);
        //创建动画作用对象:此处一Button为例

        wrapper = new ViewWrapper(mButton);
        //创建包装类,并传入动画作用的对象

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    //提供ViewWrapper类,用于包装View对象
    //本例:包装Button对象
    private static class ViewWrapper{
        private View mTarget;

        //构造方法:传入需要包装的对象
        public ViewWrapper(View target){
            mTarget = target;
        }

        //为宽度设置get() & set()
        public int getWidth(){
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width){
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }
}