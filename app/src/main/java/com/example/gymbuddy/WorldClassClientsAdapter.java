package com.example.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WorldClassClientsAdapter extends BaseAdapter {

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Client> clientList;
    ArrayList<Client> arrayList;
    User myUser;

    // constructors
    public WorldClassClientsAdapter(Context context, List<Client> clientList) {
        mContext = context;
        this.clientList = clientList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Client>();
        this.arrayList.addAll(clientList);
    }

    public class ViewHolder{
        TextView mClientFirstName, mClientLastName, mClientPhoneNumber;
    }

    @Override
    public int getCount() {
        return clientList.size();
    }

    @Override
    public Object getItem(int i) {
        return clientList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        myUser = User.getInstance();

        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.client_row, null);

            // locate the views in row.xml
            holder.mClientFirstName= view.findViewById(R.id.client_first_name);
            holder.mClientLastName= view.findViewById(R.id.client_last_name);
            holder.mClientPhoneNumber= view.findViewById(R.id.client_phone_number);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //set the results into textViews
        holder.mClientFirstName.setText(clientList.get(position).getClientFirstName());
        holder.mClientLastName.setText(clientList.get(position).getClientLastName());
        holder.mClientPhoneNumber.setText(clientList.get(position).getClientPhoneNumber());

        return view;
    }
}
