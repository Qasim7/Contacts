package com.example.qasim.contacts.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qasim.contacts.ScrollingActivity;
import com.example.qasim.contacts.model.Person;
import com.example.qasim.contacts.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private List<Person> items;
    private Context context;


    public ContactAdapter(List<Person> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View rootview=inflater.inflate(R.layout.item_person,viewGroup,false);

        return new ContactViewHolder(rootview);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactAdapter.ContactViewHolder contactViewHolder, int i) {
        final Person item=items.get(i);
        contactViewHolder.name.setText(item.getName());
        contactViewHolder.number.setText(item.getNumber()+"");
        contactViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ScrollingActivity.class);
                intent.putExtra("id",item.getID());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (items==null)
            return 0;
        return items.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name,number;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
            name=itemView.findViewById(R.id.item_name);
            number=itemView.findViewById(R.id.item_number);

        }
    }
}
