package com.finepointmobile.famouspeople.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.finepointmobile.famouspeople.R;
import com.finepointmobile.famouspeople.activities.UpdateActivity;
import com.finepointmobile.famouspeople.model.User;

import java.util.List;

/**
 * Created by danielmalone on 10/28/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> users;
    Context context;


    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.firstName.setText(users.get(position).getFirstName());
        holder.lastName.setText(users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());


        final int myid;
        final String fname, lname, email;

        myid = users.get(position).getId();
        fname = users.get(position).getFirstName();
        lname = users.get(position).getLastName();
        email = users.get(position).getEmail();
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", myid);
                intent.putExtra("fName", fname);
                intent.putExtra("lName", lname);
                intent.putExtra("email", email);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName;
        public TextView lastName;
        public TextView email;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            email = itemView.findViewById(R.id.email);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
