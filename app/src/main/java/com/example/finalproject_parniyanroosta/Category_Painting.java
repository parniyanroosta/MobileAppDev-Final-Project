package com.example.finalproject_parniyanroosta;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class Category_Painting extends AppCompatActivity {
    // Member variables.
    private RecyclerView mRecyclerView;
    private ArrayList<Item> mItemsData;
    private ItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_painting);

        int gridColumnCount =
                getResources().getInteger(R.integer.grid_column_count);

        int swipeDirs;
        if (gridColumnCount > 1) {
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        // Initialize the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        // Initialize the ArrayList that will contain the data.
        mItemsData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new ItemAdapter(this, mItemsData);
        mRecyclerView.setAdapter(mAdapter);

        // Get the data.
        initializeData();

        // Helper class for creating swipe to dismiss and drag and drop functionality.
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                        ItemTouchHelper.DOWN | ItemTouchHelper.UP, swipeDirs) {


            //Defines the drag and drop functionality
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                // Get the from and to positions
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                // Swap the items and notify the adapter.
                Collections.swap(mItemsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // Remove the item from the dataset
                mItemsData.remove(viewHolder.getAdapterPosition());
                // Notify the adapter.
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        // Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecyclerView);

    }

    // Initialize items data from resources.
    private void initializeData() {
        // Get the resources from the XML file
        String[] itemsList = getResources()
                .getStringArray(R.array.items_titles);
        String[] itemsDescription = getResources()
                .getStringArray(R.array.items_description);
        TypedArray itemsImageResources = getResources()
                .obtainTypedArray(R.array.items_images);

        // Clear the existing data (to avoid duplication).
        mItemsData.clear();

        // Create the ArrayList of Items objects with the titles and
        // information about each item
        for (int i = 0; i < itemsList.length; i++) {
            mItemsData.add(new Item(itemsList[i], itemsDescription[i],
                    itemsImageResources.getResourceId(i, 0)));
        }

        // Recycle the typed array.
        itemsImageResources.recycle();

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }
}


            //onClick method for th FAB that///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          //  public void resetSports(View view) {
           //     initializeData();
          //  }

