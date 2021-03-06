package com.example.chris.materialdesigndemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.view.CardImageView;

import java.io.InputStream;

/**
 * Created by Admin on 2015/8/19.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private Context context;
    private int layoutId;
    private int itemSize;
    private int windowWidth;
    private int windowHeitht;
    private int imageId;

    private static OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Pass in the context and users array into the constructor
    public CardViewAdapter(Context context, int layoutId, int itemSize) {
        this.context = context;
        this.layoutId = layoutId;
        this.itemSize = itemSize;
        this.imageId = R.drawable.bitch;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;// 屏幕宽度（像素）
        int height= dm.heightPixels; // 屏幕高度（像素）
        float density = dm.density;//屏幕密度（0.75 / 1.0 / 1.5）
       // int densityDpi = dm.densityDpi;//屏幕密度dpi（120 / 160 / 240）
        //屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        windowWidth = (int) (width/density);//屏幕宽度(dp)
        windowHeitht = (int)(height/density);//屏幕高度(dp)
        Log.e("CardViewAdapter", windowWidth + "======" + windowHeitht);
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the custom layout
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        // Return a new holder instance
        return new ViewHolder(context, itemView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        InputStream is = context.getResources().openRawResource(this.imageId);
        BitmapFactory.Options opts =  new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;

        BitmapFactory.decodeStream(is, null, opts);
        //BitmapFactory.decodeResource(context.getResources(), imageIds.get(position), opts);

        int imgWidth = opts.outWidth;
        int imgHeight = opts.outHeight;
        Log.i("ImageAdapter", "imgWidth:"+imgWidth+", imgHeight:"+imgHeight);

        Log.i("ImageAdapter", "imgWidthddd:"+windowWidth+", imgHeightddd:"+windowHeitht);
        int scaleX = imgWidth/windowWidth;  //水平方向的缩放比

        int scaleY = imgHeight/windowHeitht; //垂直方向的缩放比
        Log.i("ImageAdapter", "scaleX:"+scaleX+", scaleY:"+scaleY);

        int scale = 1; //缩放比

        if(scaleX >= scaleY && scaleY >= 1){

            scale = scaleX;

        }else if(scaleY >= scaleX && scaleX >= 1){

            scale = scaleY;

        }

        //接下来解析图片
        Log.i("ImageAdapter", "scale:"+scale);
        opts.inJustDecodeBounds = false;
        //采样率

        opts.inSampleSize = scale;

        //Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imageIds.get(position), opts);
        Bitmap bitmap = BitmapFactory.decodeStream(is, null, opts);
        holder.imageView.setImageBitmap(bitmap);
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return itemSize;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardImageView imageView;
        public ViewHolder(Context context, final View itemView) {
            super(itemView);
            imageView = (CardImageView) itemView.findViewById(R.id.cardList_imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null)
                        listener.onItemClick(itemView, getLayoutPosition());
                }
            });
        }
    }

}