package com.example.servicepanel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicepanel.db.AppDatabase;
import com.example.servicepanel.db.DataEvent;

import java.util.List;
import java.util.Random;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<DataEvent> userList;

    public UserListAdapter(Context context){
       this.context = context;
    }

    public void setUserList(List<DataEvent> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {
        holder.tvEventName.setText(this.userList.get(position).eventName);
        holder.tvStatusEvent.setText(this.userList.get(position).statusEvent);
        holder.tvIcon.setText(String.valueOf(this.userList.get(position).uid));

        Random mRandom = new Random();
        final int color = Color.argb(255,mRandom.nextInt(256),mRandom.nextInt(256),mRandom.nextInt(256));
        ((GradientDrawable) holder.tvIcon.getBackground()).setColor(color);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ListAction.class);
                intent.putExtra("value",userList.get(holder.getLayoutPosition()).statusEvent);
                intent.putExtra("event_name",userList.get(holder.getLayoutPosition()).eventName);
                intent.putExtra("object",userList.get(holder.getLayoutPosition()).object);
                intent.putExtra("object_address",userList.get(holder.getLayoutPosition()).objectAddress);
                intent.putExtra("date_start",userList.get(holder.getLayoutPosition()).dateStart);
                intent.putExtra("date_stop", userList.get(holder.getLayoutPosition()).dateStop);
                context.startActivity(intent);
            }
        });

        holder.ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getDbInstance(holder.tvIcon.getContext());
                db.userDao().deleteById(userList.get(holder.getLayoutPosition()).uid);

                userList.remove(position);

                notifyDataSetChanged();
            }
        });

        holder.ivUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(context,EditList.class);
                intent2.putExtra("id",String.valueOf(userList.get(holder.getLayoutPosition()).uid));
                intent2.putExtra("data_start",String.valueOf(userList.get(holder.getLayoutPosition()).dateStart));
                context.startActivity(intent2);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvEventName;
        TextView tvStatusEvent;
        TextView tvIcon;
        ImageView ivFavorite;
        ImageView ivUpdate;

        LinearLayout linearLayout;

        public MyViewHolder(View view){
            super(view);
            tvEventName = view.findViewById(R.id.tvEventName);
            tvStatusEvent = view.findViewById(R.id.tvStatusEvent);
            tvIcon = view.findViewById(R.id.tvIcon);
            ivFavorite = view.findViewById(R.id.ivFavorite);
            linearLayout = view.findViewById(R.id.linear_layout);
            ivUpdate = view.findViewById(R.id.ivUpdate);
        }
    }
}
