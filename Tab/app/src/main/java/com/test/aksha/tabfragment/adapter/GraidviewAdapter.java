package com.test.aksha.tabfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.aksha.tabfragment.Model.Category_model;
import com.test.aksha.tabfragment.R;

import java.util.List;

public class GraidviewAdapter extends BaseAdapter {

    Context context;
    List<Category_model.Category> models;

    public GraidviewAdapter(Context context, List<Category_model.Category> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        VIEWHOLDER viewholder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_graidlayout,parent,false);
            viewholder = new VIEWHOLDER(convertView);
            convertView.setTag(viewholder);
        } else {
            viewholder = (VIEWHOLDER) convertView.getTag();
        }
        viewholder.name.setText(models.get(position).getCategory_name());
        return convertView;
    }


    static class VIEWHOLDER {

        TextView name;

        public VIEWHOLDER(View view) {

            name = view.findViewById(R.id.name);
        }

    }
}
