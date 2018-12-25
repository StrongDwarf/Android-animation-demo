package com.app.bm.animation_demo.activity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.app.bm.animation_demo.R;
import com.app.bm.animation_demo.entiy.ColorEvaluator;
import com.app.bm.animation_demo.entiy.MyView2;


public class AnimationSetActivity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_animatorset);

        /**
         * 组合动画
         * 实现组合动画的功能:AnimatorSet类
         *
         * Animator.play(Animator anim):播放当前动画
         * AnimatorSet.after(long delay):将当前动画延迟X秒后执行
         * AnimatorSet.with(Animator anim):将现有动画和传入的动画同时执行
         * AnimatorSet.after(Animator anim):将现有动画插入到传入的动画之后执行
         * AnimatorSet.before(Animator anim):将现有动画插入到传入的动画之前执行
         */
        Button mButton = (Button)findViewById(R.id.Button);
        float curTranslationX = mButton.getTranslationX();
        //步骤1:设置需要组合的动画效果
        //平移动画
        ObjectAnimator translation = ObjectAnimator.ofFloat(mButton,"translationX",curTranslationX,300,curTranslationX);
        //旋转动画
        ObjectAnimator rotate = ObjectAnimator.ofFloat(mButton,"rotation",0f,360f,0f);
        //透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mButton,"alpha",1f,0f,1f);

        //步骤2:创建组合动画的对象
        AnimatorSet animSet = new AnimatorSet();

        //步骤3:根据需求组合动画
        animSet.play(translation).with(rotate).with(alpha);
        animSet.setDuration(5000);


        //步骤4:启动动画
        animSet.start();


        /**
         * 通过xml设置动画,然后通过java启动的动画
         */
        Button mButton1 = (Button)findViewById(R.id.Button2);
        AnimatorSet animatorSet2 = (AnimatorSet)AnimatorInflater.loadAnimator(this,R.animator.set_animation);
        animatorSet2.setTarget(mButton1);
        animatorSet2.start();

        /**
         * 使用ViewPropertyAnimator创建动画
         */
        //使用解析
        //View.animate().xxx().xxx();
        //ViewPropertyAnimator的功能建立在animate()上
        //调用animate()方法返回值是一个ViewPropertyAnimator对象,之后的调用的所有方法都是通过该实例实现
        //ViewPropertyAnimator所有接口方法都使用连缀语法来设计,每个方法的返回值都是它自身的实例
        //因此调用完一个方法后可直接连缀调用另一方法。

        Button mButton3 = (Button)findViewById(R.id.Button3);

        //单个动画设置，将按钮变为透明状态
        //mButton3.animate().alpha(0f);
        for(int i = 0;i<10;i++){
            mButton3.animate().alpha(0f).setDuration(5000).setInterpolator(new BounceInterpolator());
            mButton3.animate().alpha(0f).x(500).y(500);
            
        }


        //组合动画:将按钮变为透明状态再移动到(500,500)处


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}