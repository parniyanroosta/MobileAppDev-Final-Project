package com.example.finalproject_parniyanroosta;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


 // The adapter class for the RecyclerView, contains the items data
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>  {

    // Member variables.
    private ArrayList<Item> mItemsData;
    private Context mContext;

    // Constructor that passes in the items data and the context.
    ItemAdapter(Context context, ArrayList<Item> itemsData) {
        this.mItemsData = itemsData;
        this.mContext = context;
    }


    /*
    //I've followed the google codeLabs (MaterialMe) for this section:
    */


     // creating the viewHolder objects
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    // method that binds the data to the viewHolder
    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        // Get current item
        Item currentItem = mItemsData.get(position);
        // Populate the textViews with data.
        holder.bindTo(currentItem);
    }

    // method for determining the size of the data set
    @Override
    public int getItemCount() {
        return mItemsData.size();
    }

    // ViewHolder class that represents each row of data in the RecyclerView.
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mDescriptionText;
        private ImageView mItemImage;
        private TextView mItemPrice;

        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views
            mTitleText = itemView.findViewById(R.id.title);
            mDescriptionText = itemView.findViewById(R.id.descriptionDetail);
            mItemImage = itemView.findViewById(R.id.artImageDetail);
            mItemPrice = itemView.findViewById(R.id.txtViewPrice);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(Item currentItem){
            // Populate the textViews with data.
            mTitleText.setText(currentItem.getTitle());
           // mDescriptionText.setText(currentItem.getInfo());
           // mItemPrice.setText(currentItem.getPrice());

            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(currentItem.getImageResource()).into(mItemImage);
        }

        // Handle click to show DetailActivity
        @Override
        public void onClick(View view) {
            Item currentItem = mItemsData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentItem.getTitle());
            detailIntent.putExtra("image_resource", currentItem.getImageResource());
            detailIntent.putExtra("description", currentItem.getInfo());
            detailIntent.putExtra("price", currentItem.getPrice());
            mContext.startActivity(detailIntent);
        }
    }
}