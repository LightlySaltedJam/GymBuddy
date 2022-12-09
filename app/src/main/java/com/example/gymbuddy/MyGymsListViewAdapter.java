package com.example.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyGymsListViewAdapter extends BaseAdapter {

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;
    User myUser;

    // constructors
    public MyGymsListViewAdapter(Context context, List<Model> modelList) {
        mContext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
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
            view = inflater.inflate(R.layout.row, null);

            // locate the views in row.xml
            holder.mTitleTv= view.findViewById(R.id.mainTitle);
            holder.mDescTv= view.findViewById(R.id.mainDesc);
            holder.mIconIv= view.findViewById(R.id.mainIcon);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //set the results into textViews
        holder.mTitleTv.setText(modelList.get(position).getTile());
        holder.mDescTv.setText(modelList.get(position).getDesc());
        // set the result in imageview
        holder.mIconIv.setImageResource(modelList.get(position).getIcon());

        // listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code here - to handle item clicks
                if (modelList.get(position).getTile().equals("World Class")) {
                    Intent wcPageIntent = new Intent(mContext, SelectedWorldClass.class);
                    mContext.startActivity(wcPageIntent);
                }
                if (modelList.get(position).getTile().equals("Stay Fit Gym")) {
                    Intent rfcPageIntent = new Intent(mContext, SelectedRoyalFitnessClub.class);
                    mContext.startActivity(rfcPageIntent);
                }
                if (modelList.get(position).getTile().equals("Gema Fitness")) {
//                    Gym gemaGym = new Gym("Gema Fitness", R.drawable.gema_fitness_logo);
//                    myUser.myGyms.add(gemaGym);
                }
                if (modelList.get(position).getTile().equals("Vikings Gym")) {
//                    Gym vikingsGym = new Gym("Vikings Gym", R.drawable.vikings_gym_logo);
//                    myUser.myGyms.add(vikingsGym);
                }
                if (modelList.get(position).getTile().equals("Royal Fitness Club")) {
//                    Gym rfGym = new Gym("Royal Fitness Club", R.drawable.royal_fitness_clib_logo);
//                    myUser.myGyms.add(rfGym);
                }
            }
        });

        return view;
    }
}
