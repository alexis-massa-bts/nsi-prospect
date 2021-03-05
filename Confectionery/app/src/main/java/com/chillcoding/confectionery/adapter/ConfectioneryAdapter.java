package com.chillcoding.confectionery.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chillcoding.confectionery.R;
import com.chillcoding.confectionery.model.AndroidConfectionery;

import java.util.ArrayList;

/**
 * Created by macha on 24/09/16.
 */
public class ConfectioneryAdapter extends RecyclerView.Adapter<ConfectioneryAdapter.ViewHolder> {

    private ArrayList<AndroidConfectionery> mAndroidConfectioneryList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextName;
        public TextView mTextVersion;
        public ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.name_confectionery);
            mTextVersion = (TextView) itemView.findViewById(R.id.version_confectionery);
            mImage = (ImageView) itemView.findViewById(R.id.image_confectionery);
        }
    }

    public ConfectioneryAdapter(ArrayList<AndroidConfectionery> list) {
        mAndroidConfectioneryList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_confectionery, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AndroidConfectionery confectionery = mAndroidConfectioneryList.get(position);

        Resources res = holder.mTextVersion.getContext().getResources();

        holder.mTextName.setText(confectionery.getName());
        holder.mTextVersion.setText(String.format(res.getString(R.string.confectionery_version_text), confectionery.getVersionNumber()));
        holder.mImage.setImageResource(confectionery.getResourceIdImage());
    }

    @Override
    public int getItemCount() {
        return mAndroidConfectioneryList.size();
    }


}
