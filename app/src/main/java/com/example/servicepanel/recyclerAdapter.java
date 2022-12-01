package com.example.servicepanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<User> usersList;
    private RecyclerViewClickListener listener;

    public recyclerAdapter(ArrayList<User> usersList, RecyclerViewClickListener listener){
        this.usersList = usersList;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView id_tv,name_tv,object_tv,status_tv;
        private recyclerAdapter  adapter;

        public  MyViewHolder(final View view){
            super(view);
            id_tv = view.findViewById(R.id.id_tv);
            name_tv = view.findViewById(R.id.name_tv);
            object_tv = view.findViewById(R.id.object_tv);
            status_tv = view.findViewById(R.id.status_tv);


            /*view.findViewById(R.id.delete).setOnClickListener(itemView -> {
                adapter.usersList.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });*/

            view.setOnClickListener(this);
        }

        public MyViewHolder linkAdapter(recyclerAdapter  adapter){
            this.adapter = adapter;
            return this;
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        //return new MyViewHolder(itemView);
        return new MyViewHolder(itemView).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        //String name = usersList.get(position).getUserName();
        //holder.nameTxt.setText(name);
        String id = usersList.get(position).getId();
        holder.id_tv.setText(id);
        String name = usersList.get(position).getName();
        holder.name_tv.setText(name);
        String object = usersList.get(position).getObject();
        holder.object_tv.setText(object);
        String status = usersList.get(position).getStatus();
        holder.status_tv.setText(status);

    }

    @Override
    public int getItemCount() {return usersList.size();}

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
