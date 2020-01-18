package com.powsikan.kuppi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public  List<PersonInfo> mDataset;boolean mchecked;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewName;
        public TextView textViewStatus;

        public MyViewHolder(View v) {
            super(v);
            textViewName = v.findViewById(R.id.textviewName);
            textViewStatus = v.findViewById(R.id.textviewStatus);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<PersonInfo> myDataset) {
        mDataset = myDataset;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PersonInfo personInfo = mDataset.get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textViewName.setText(personInfo.getName());
        if(personInfo.isStatus()){
            holder.textViewStatus.setText("Online");
        }else{
            holder.textViewStatus.setText("Offline");

        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addData(PersonInfo personInfo){
        mDataset.add(personInfo);
        notifyDataSetChanged();

    }
}
