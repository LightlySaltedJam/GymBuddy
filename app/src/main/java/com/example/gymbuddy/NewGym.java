package com.example.gymbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class NewGym extends AppCompatActivity {

    ListView listView;
    NewGymListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    Toolbar myGymsToolbar;
    User myUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_gym);

        myGymsToolbar = findViewById(R.id.myGymsToolbar);
        setSupportActionBar(myGymsToolbar);

        title = new String[]{"World Class", "Royal Fitness Club", "Vikings Gym", "Stay Fit Gym", "Gema Fitness"};
        description = new String[]{"World Class Description", "Royal Fitness Club Description", "Vikings Gym Description", "Stay Fit Gym Description", "Gema Fitness Description"};
        icon = new int[]{R.drawable.world_class_logo, R.drawable.royal_fitness_clib_logo, R.drawable.vikings_gym_logo, R.drawable.stay_fit_logo, R.drawable.gema_fitness_logo};

        listView = findViewById(R.id.customListView);

        myUser = User.getInstance();
        Log.d("TAG", "The number of gyms is: "+String.valueOf(myUser.myGyms.size()));


        for (int i = 0; i < title.length; i++) {
            //Model model = new Model(myUser.myGyms.get(i).title, myUser.myGyms.get(i).description, myUser.myGyms.get(i).icon);
            Model model = new Model(title[i], description[i], icon[i]);
            // bind all strings in an array
            arrayList.add(model);
        }

        // pass results to listViewAdapter class
        adapter = new NewGymListViewAdapter(this, arrayList);
        listView.setAdapter(adapter);


//        adapter.registerDataSetObserver(new DataSetObserver() {
//            @Override
//            public void onChanged() {
////                Intent intent = new Intent(NewGym.this, secondFragment.class);
////                startActivity(intent);
//
//                Fragment fragment = new secondFragment();
//                FragmentManager fragmentManager = NewGym.this.getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.NewGymID, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });

        // bind the adapter to the listView
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                } else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//            // do your functionality here
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
}
