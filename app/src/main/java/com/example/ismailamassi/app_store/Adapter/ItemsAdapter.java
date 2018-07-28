package com.example.ismailamassi.app_store.Adapter;

import com.example.ismailamassi.app_store.R;
import com.example.ismailamassi.app_store.items.MarketItems;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    public ArrayList<MarketItems> items;
    private Context context;

    public  ItemsAdapter(Context context , ArrayList<MarketItems> items){
        this.items = items;
        this.context = context;
    }
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position) {
        holder.app_icon.setImageResource(items.get(position).app_icon);
        holder.app_name.setText(items.get(position).app_title);
        holder.app_rating.setRating(items.get(position).app_rating);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView app_icon;
        TextView app_name;
        RatingBar app_rating;
        CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            app_icon = itemView.findViewById(R.id.app_icon);
            app_name = itemView.findViewById(R.id.app_name);
            app_rating = itemView.findViewById(R.id.app_rating);
            card = itemView.findViewById(R.id.item_card);

        }
    }
}