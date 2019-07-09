package com.example.chapter_2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Data> mDataList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tname;
        TextView tindex;
        TextView tnum;
        ImageView timageid;

        public ViewHolder(View v){
            super(v);
            tname = v.findViewById(R.id.name);
            tindex = v.findViewById(R.id.index);
            tnum = v.findViewById(R.id.num);
            timageid = v.findViewById(R.id.rexin);
        }

    }
    public DataAdapter(List<Data> dataList){
        mDataList = dataList;
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_text_list,parent,false);
        RecyclerView.ViewHolder holder = new ViewHolder(view);
        return (ViewHolder) holder;
    }
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position){
        Data data = mDataList.get(position);
        holder.tindex.setText(data.getindex());
        if(position<=2)
            holder.tindex.setTextColor(0xe6face15);
        else
            holder.tindex.setTextColor(0x99ffffff);
        holder.tname.setText(data.getname());
        holder.tname.setTextColor(0xe6ffffff);
        holder.tnum.setText(data.getnum());
        holder.tnum.setTextColor(0x7fffffff);
        holder.timageid.setImageResource(data.getImageid());

    }
    @Override
    public int getItemCount(){
        return mDataList.size();
    }
}
