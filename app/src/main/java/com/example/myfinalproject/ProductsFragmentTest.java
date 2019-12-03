package com.example.myfinalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RVFragment - Fragment with a simple RecyclerView that
 * only takes Strings
 *
 * Usage:
 * RVFragment rvf = new RVFragment();
 *
 * @author Sheharyar Naseer
 */

public class ProductsFragmentTest extends Fragment {
    String[] strings = {"item1", "item2", "item3", "item4", "item5", "item6", "item7"};

    public ProductsFragmentTest() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new SimpleRVAdapter(strings));
        return rv;
    }

    /**
     * A Simple Adapter for the RecyclerView
     */
    public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
        private String[] dataSource;
        public SimpleRVAdapter(String[] dataArgs){
            dataSource = dataArgs;
        }

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = new TextView(parent.getContext());
            SimpleViewHolder viewHolder = new SimpleViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.textView.setText(dataSource[position]);
        }

        @Override
        public int getItemCount() {
            return dataSource.length;
        }
    }

    /**
     * A Simple ViewHolder for the RecyclerView
     */
    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}