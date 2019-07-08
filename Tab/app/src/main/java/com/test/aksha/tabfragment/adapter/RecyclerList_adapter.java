package com.test.aksha.tabfragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.aksha.tabfragment.Model.Category_model;
import com.test.aksha.tabfragment.R;

import java.util.List;

public class RecyclerList_adapter extends RecyclerView.Adapter<RecyclerList_adapter.ViewHolder> {

    List<Category_model.Category> category_models;
    Context context;

    public RecyclerList_adapter(List<Category_model.Category> category_models, Context context) {
        this.category_models = category_models;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recyclerlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(category_models.get(position).getCategory_name());
    }

    @Override
    public int getItemCount() {
        return category_models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);


        }

    }
}
