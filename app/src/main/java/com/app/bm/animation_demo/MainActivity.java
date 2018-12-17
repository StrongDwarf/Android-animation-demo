package com.app.bm.animation_demo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.bm.animation_demo.activity.Animation1Activity;
import com.app.bm.animation_demo.activity.AnimationObjectActivity;
import com.app.bm.animation_demo.activity.AnimationOfObecjtActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(R.id.btn);
        button1 = (Button)findViewById(R.id.btn1);

        findViewById(R.id.animation_1).setOnClickListener(onClickListener);
        findViewById(R.id.animation_object).setOnClickListener(onClickListener);
        findViewById(R.id.animation1).setOnClickListener(onClickListener);
        /*
        ValueAnimator valueAnimator = ValueAnimator.ofInt(button.getLayoutParams().width,500);

        //设置动画播放的属性
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(200);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int currentValue = (Integer)animation.getAnimatedValue();
                //System.out.println(currentValue);

                button.getLayoutParams().width = currentValue;
                button.requestLayout();

            }
        });
        valueAnimator.start();
*/

        /**
         * 第二个动画,
         * 使用从xml文件中导入参数的方式实现动画
         *
         */
        //载入xml动画
        Animator animator1 = AnimatorInflater.loadAnimator(this, R.animator.animation2);
        //设置动画对象
        animator1.setTarget(button1);
        animator1.start();

    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.animation_1:
                    Intent intent = new Intent(MainActivity.this,AnimationOfObecjtActivity.class);
                    startActivity(intent);
                    break;
                case R.id.animation_object:
                    Intent intent1 = new Intent(MainActivity.this,AnimationObjectActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.animation1:
                    Intent intent2 = new Intent(MainActivity.this,Animation1Activity.class);
                    startActivity(intent2);
                    break;
            }
        }
    };
}
