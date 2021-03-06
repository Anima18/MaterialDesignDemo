package com.example.chris.materialdesigndemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.view.DisplayLeakConnectorView;

/**
 * Created by Admin on 2015/8/19.
 */
public class UIStepAdapter extends RecyclerView.Adapter<UIStepAdapter.ViewHolder> {

    private Context context;
    private int layoutId;
    private int itemSize;

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
    public UIStepAdapter(Context context, int layoutId, int itemSize) {
        this.context = context;
        this.layoutId = layoutId;
        this.itemSize = itemSize;
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
        boolean isRoot = position == 0;
        boolean isLeakingInstance = position == itemSize - 1;
        DisplayLeakConnectorView connector = holder.stepView;
        if (isRoot) {
            connector.setType(DisplayLeakConnectorView.Type.START);
        } else {
            if (isLeakingInstance) {
                connector.setType(DisplayLeakConnectorView.Type.END);
            } else {
                connector.setType(DisplayLeakConnectorView.Type.NODE);
            }
        }
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return itemSize;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {

        DisplayLeakConnectorView stepView;

        public ViewHolder(Context context, final View itemView) {
            super(itemView);

            stepView = (DisplayLeakConnectorView) itemView.findViewById(R.id.stepView);

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