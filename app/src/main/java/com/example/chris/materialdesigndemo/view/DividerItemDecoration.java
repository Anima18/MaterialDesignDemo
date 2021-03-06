package com.example.chris.materialdesigndemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.util.CommonUtil;


/**
 * Created by Chris on 2015/11/26.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration{

    private Context mContext;

    /*
    * RecyclerView的布局方向，默认先赋值
    * 为纵向布局
    * RecyclerView 布局可横向，也可纵向
    * 横向和纵向对应的分割想画法不一样
    * */
    private int mOrientation = LinearLayoutManager.VERTICAL ;

    public static int DIVIDER_TYPE_FULL = 1;
    public static int DIVIDER_TYPE_INSET = 2;

    /**
     * item之间分割线的size，默认为1
     */
    private int mItemSize = 1 ;

    /**
     * 绘制item分割线的画笔，和设置其属性
     * 来绘制个性分割线
     */
    private Paint mPaint ;

    private int dividerType = DIVIDER_TYPE_FULL;

    public DividerItemDecoration(Context context, int orientation) {
        this(context, DIVIDER_TYPE_FULL, orientation);
    }

    /**
     * 构造方法传入布局方向，不可不传
     * @param context
     * @param orientation
     */
    public DividerItemDecoration(Context context, int dividerType, int orientation) {
        this.mContext = context;
        this.dividerType = dividerType;
        this.mOrientation = orientation;
        if(orientation != LinearLayoutManager.VERTICAL && orientation != LinearLayoutManager.HORIZONTAL){
            throw new IllegalArgumentException("请传入正确的参数") ;
        }
        mItemSize = (int) TypedValue.applyDimension(mItemSize, TypedValue.COMPLEX_UNIT_DIP, context.getResources().getDisplayMetrics());
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG) ;
        mPaint.setAntiAlias(true);
        mPaint.setColor(context.getResources().getColor(R.color.dividing_line_color));
         /*设置填充*/
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation == LinearLayoutManager.VERTICAL){
            drawVertical(c,parent) ;
        }else {
            drawHorizontal(c,parent) ;
        }
    }

    /**
     * 绘制纵向 item 分割线
     * @param canvas
     * @param parent
     */
    private void drawVertical(Canvas canvas, RecyclerView parent){
        int insetSize = dividerType == DIVIDER_TYPE_FULL ? 0 : CommonUtil.dipToPixels(72);
        final int left = parent.getPaddingLeft() + insetSize;
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight() ;
        final int childSize = parent.getChildCount() ;
        for(int i = 0 ; i < childSize ; i ++){
            final View child = parent.getChildAt( i ) ;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + layoutParams.bottomMargin ;
            final int bottom = top + mItemSize ;
            canvas.drawLine(left,top,right,bottom,mPaint);
            //canvas.drawRect(left,top,right,bottom,mPaint);
        }
    }

    /**
     * 绘制横向 item 分割线
     * @param canvas
     * @param parent
     */
    private void drawHorizontal(Canvas canvas, RecyclerView parent){
        final int top = parent.getPaddingTop() ;
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom() ;
        final int childSize = parent.getChildCount() ;
        for(int i = 0 ; i < childSize ; i ++){
            final View child = parent.getChildAt( i ) ;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layoutParams.rightMargin;
            final int right = left + mItemSize ;
            canvas.drawLine(left,top,right,bottom,mPaint);
            //canvas.drawRect(left,top,right,bottom,mPaint);
        }
    }

}