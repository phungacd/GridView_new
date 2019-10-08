package com.example.gridview_new;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridView_Custom extends BaseAdapter {

    private List<Hotgirl> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public GridView_Custom(Context aContext, List<Hotgirl> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.gridview_item, null);
            holder = new ViewHolder();
            holder.flagView = (ImageView) convertView.findViewById(R.id.hinhanh);
            holder.countryNameView = (TextView) convertView.findViewById(R.id.textview);
            //holder.populationView = (TextView) convertView.findViewById(R.id.textView_population);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Hotgirl hotgirl = this.listData.get(position);
        holder.countryNameView.setText(hotgirl.getTen());
        int imageId = this.getMipmapResIdByName(hotgirl.getHinhanh());

        holder.flagView.setImageResource(imageId);

        return convertView;
    }


    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();


        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        Log.i("CustomGridView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    static class ViewHolder {
        ImageView flagView;
        TextView countryNameView;
       // TextView populationView;
    }


}
