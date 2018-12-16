package com.app.bm.animation_demo.entiy;

import android.animation.TypeEvaluator;

//实现TypeEvaluator接口
public class PointEvaluator implements TypeEvaluator{

    @Override
    public Object evaluate(float fraction,Object startValue,Object endValue){
        Point startPoint = (Point)startValue;
        Point endPoint = (Point)endValue;

        //根据fraction来计算当前动画的x和y值
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());

        //将计算后的坐标封装到一个新的Point对象中并返回
        Point point = new Point(x,y);
        return point;
    }
}