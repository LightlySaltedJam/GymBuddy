package com.example.gymbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link secondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class secondFragment extends ListFragment {

    User myUser;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public secondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment secondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static secondFragment newInstance(String param1, String param2) {
        secondFragment fragment = new secondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    LinearLayout ln;
    MyGymsListViewAdapter adapter;
    NewGymListViewAdapter adapter2;
    ListView listView;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    String[] title;
    String[] description;
    int[] icon;
//     ArrayList<String> listItems = new ArrayList<String>();
//     ArrayAdapter<String> listViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        adapter = new MyGymsListViewAdapter(getActivity(), arrayList);
        adapter2 = new NewGymListViewAdapter(getActivity(), arrayList);

        myUser = User.getInstance();
        listView = view.findViewById(R.id.myGymList);
        for (int i = 0; i < myUser.myGyms.size(); i++) {
            Model model = new Model(myUser.myGyms.get(i).title, myUser.myGyms.get(i).description, myUser.myGyms.get(i).icon);
            //Model model = new Model(title[i], description[i], icon[i]);
            // bind all strings in an array
            arrayList.add(model);
        }
        listView.setAdapter(adapter);

        ln = view.findViewById(R.id.linearLayout3);

        // REMOVE ITEM ON HOLD
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int which_item = position;

                new AlertDialog.Builder((AppCompatActivity) getActivity())
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this gym?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(which_item);
                                myUser.myGyms.remove(which_item);
                                adapter.notifyDataSetChanged();
                                adapter2.notifyDataSetChanged();
                                updateText(ln);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });



        // REMOVE ITEMS ON HOLD 1
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                for (int i = 0; i < myUser.myGyms.size(); i++) {
//                    Model model = new Model(myUser.myGyms.get(i).title, myUser.myGyms.get(i).description, myUser.myGyms.get(i).icon);
//                    //Model model = new Model(title[i], description[i], icon[i]);
//                    // bind all strings in an array
//                    arrayList.remove(model);
//
//                }
//                adapter2.notifyDataSetChanged();
//                adapter.notifyDataSetChanged();
//                return false;
//            }
//        });


//        // REMOVE ITEMS ON HOLD 2
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                SparseBooleanArray positionChecker = listView.getCheckedItemPositions();
//
//                int count = myUser.myGyms.size();
//                for (int item = count - 1; item <= 0; item++) {
//                    if(positionChecker.get(item)) {
//                        Model model = new Model(myUser.myGyms.get(item).title, myUser.myGyms.get(item).description, myUser.myGyms.get(item).icon);
//                        arrayList.remove(model);
//                    }
//                }
//                positionChecker.clear();
//                adapter.notifyDataSetChanged();
//
//                return false;
//            }
//        });


        return view;
    }

    Button signOut;
    Toolbar myGymsToolbar;
    Button addGymButton;
    TextView gymCounter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // TOOLBAR
        myGymsToolbar = getView().findViewById(R.id.myGymsToolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myGymsToolbar);

        signOut = getView().findViewById(R.id.signOutButton2);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = ((AppCompatActivity) getActivity()).getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                //((AppCompatActivity)getActivity()).finish();
                Intent goBackIntent = new Intent(((AppCompatActivity) getActivity()), LoginActivity.class);
                startActivity(goBackIntent);
            }
        });

        addGymButton = getView().findViewById(R.id.addBtn);
        addGymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addGymIntent = new Intent(((AppCompatActivity) getActivity()), NewGym.class);
                startActivity(addGymIntent);
            }
        });
        updateText(view);
    }

    public void updateText(View view) {
        gymCounter = view.findViewById(R.id.gym_counter);
        if (myUser.myGyms.size() == 0) {
            gymCounter.setText("You aren't attending any gyms yet");
        } else if (myUser.myGyms.size() == 1) {
            gymCounter.setText("You are attending " + myUser.myGyms.size() + " gym");
        } else {
            gymCounter.setText("You are attending " + myUser.myGyms.size() + " gyms");
        }
    }

}