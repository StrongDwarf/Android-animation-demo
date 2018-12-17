package com.app.bm.animation_demo.entiy;

import android.animation.TypeEvaluator;

public class ColorEvaluator implements TypeEvaluator{
    //实现TypeEvaluator接口
    private int mCurrentRed;
    private int mCurrentGreen;
    private int mCurretnBlue;

    //复写evaluate()
    //在evaluate()里写入对象动画过渡的逻辑;此处是写颜色过渡的逻辑
    @Override
    public Object evaluate(float fraction,Object startValue,Object endValue){

        //获取到颜色的初始值和结束值
        String startColor= (String)startValue;
        String endColor = (String)endValue;

        //通过字符串截取的方式将初始化颜色分为RGB三个部分，并将RGB的值转换成十进制数字

        //那么每个颜色的取值范围是0-255
        int startRed  = Integer.parseInt(startColor.substring(1,3),16);
        int startGreen = Integer.parseInt(startColor.substring(3,5),16);
        int startBlue = Integer.parseInt(startColor.substring(5,7),16);

        int endRed = Integer.parseInt(endColor.substring(1,3),16);
        int endGreen = Integer.parseInt(endColor.substring(3,5),16);
        int endBlue = Integer.parseInt(endColor.substring(5,7),16);

        //将初始化颜色的值定义为当前需要操作的颜色值
        mCurrentRed = startRed;
        mCurrentGreen = startGreen;
        mCurretnBlue = startBlue;

        //计算初始颜色和结束颜色之间的差值
        //该差值决定颜色变化的快慢:初始颜色值和结束颜色值很相近，那么颜色变化就会比较缓慢；否则,变化则很快
        //具体如何根据差值来觉得颜色变化快慢的逻辑写在getCurrentColor()里。
        int redDiff = Math.abs(startRed - endRed);
        int greenDiff = Math.abs(startGreen - endGreen);
        int blueDiff = Math.abs(startBlue - endBlue);
        int colorDiff = redDiff + greenDiff + blueDiff;
        if(mCurrentRed != endRed){
            mCurrentRed = getCurrentColor(startRed,endRed,colorDiff,0,fraction);
            //getCurrentColor()决定如何根据差值来决定颜色变化的快慢
        }else if(mCurrentGreen != endGreen){
            mCurretnBlue = getCurrentColor(startBlue,endBlue,colorDiff,redDiff+greenDiff,fraction);
        }
        String currentColor = "#" + getHexString(mCurrentRed) + getHexString(mCurrentGreen) + getHexString(mCurretnBlue);

        //由于我们计算出的颜色是十进制数字，所以需要转换成十六进制字符串；调用getHexString()
        //最终将RGB颜色拼装起来，并作为最终的结果返回
        return currentColor;

    }

    //根据fraction值来计算当前的颜色
    private int getCurrentColor(int startColor,int endColor,int colorDiff,int offset,float fraction){
        int currentColor;
        if(startColor>endColor){
            currentColor = (int)(startColor - (fraction*colorDiff - offset));
            if(currentColor < endColor){
                currentColor = endColor;
            }
        }else{
            currentColor = (int)(startColor+(fraction*colorDiff - offset));
            if(currentColor > endColor){
                currentColor = endColor;
            }
        }
        return currentColor;
    }

    //将10进制颜色值转换成16进制
    private String getHexString(int value){
        String hexString = Integer.toHexString(value);
        if(hexString.length() == 1){
            hexString = "0" + hexString;
        }
        return hexString;
    }
}