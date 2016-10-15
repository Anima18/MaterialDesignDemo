package com.example.chris.materialdesigndemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Admin on 2016/7/23.
 */
public class GridImageView extends ImageView {
    public GridImageView(Context context) {
        super(context);
    }

    public GridImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GridImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            //get imageview width
            int width =  MeasureSpec.getSize(widthMeasureSpec);


            int diw = drawable.getIntrinsicWidth();
            int dih = drawable.getIntrinsicHeight();
            float ratio = (float)4/3; //get image aspect ratio

            int height = (int)(width * ratio);

            //don't let height exceed width
           /* if (height > width){
                height = width;
            }*/


            setMeasuredDimension(width, height);
        }
        else
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
