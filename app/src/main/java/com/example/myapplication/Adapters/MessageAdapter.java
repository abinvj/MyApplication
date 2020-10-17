package com.example.myapplication.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.GroupChatActivity;
import com.example.myapplication.Models.AllMethods;
import com.example.myapplication.Models.Message;
import com.example.myapplication.R;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageAdapterViewHolder> {

    Context context;
    List<Message> messages;
    final DatabaseReference messageDb;

    public MessageAdapter(Context context, List<Message> messages, DatabaseReference messageDb)
    {
        this.context = context;
        this.messageDb = messageDb;
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message,parent,false);
        return new MessageAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapterViewHolder holder, int position) {

        Message message = messages.get(position);
        if(message.getName().equals(AllMethods.name))
        {
            holder.tvTitle.setText(message.getMessage());
            holder.tvTitle.setGravity(Gravity.END);
            holder.tvName.setVisibility(View.GONE);
            //holder.li.setBackgroundColor(Color.parseColor("#075E54"));
            holder.li2.setGravity(Gravity.END);
            holder.li.setBackgroundResource(R.drawable.rounded_corner2);

            if (holder.tvTitle.getText().toString().length()>23)
            {
                holder.tvTitle.setWidth(700);
               //holder.tvTitle.setText(Html.fromHtml(times));
            }
        }
        else
        {
            holder.tvName.setText(message.getName());
            holder.tvTitle.setText(message.getMessage());
            holder.ibDelete.setVisibility(View.GONE);
            holder.li.setBackgroundResource(R.drawable.rounded_corner1);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessageAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvName;
        ImageButton ibDelete;
        LinearLayout li;
        LinearLayout li2;

        public MessageAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            li = itemView.findViewById(R.id.l1Message);
            li2 = itemView.findViewById(R.id.l2Message);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvName = itemView.findViewById(R.id.tvName);
            ibDelete = itemView.findViewById(R.id.ibDelete);

            ibDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    messageDb.child(messages.get(getAdapterPosition()).getKey()).removeValue();
                }
            });
        }

        public void delete()
        {
            messageDb.child(messages.get(getAdapterPosition()).getKey()).removeValue();
        }
    }
}
