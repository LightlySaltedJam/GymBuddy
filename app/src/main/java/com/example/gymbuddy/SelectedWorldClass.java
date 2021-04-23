package com.example.gymbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectedWorldClass extends AppCompatActivity {

    ListView listView;
    WorldClassClientsAdapter adapter;
    ArrayList<Client> gymClients = new ArrayList<Client>();
    EditText editFirstName, editLastName, editTel;
    User myUser;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_world_class);

        myUser = User.getInstance();

        editFirstName = findViewById(R.id.edit_wc_client_first_name);
        editLastName = findViewById(R.id.edit_wc_client_last_name);
        editTel = findViewById(R.id.edit_wc_client_tel);
        submit = findViewById(R.id.wc_client_submit);
        listView = findViewById(R.id.wc_client_list);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client client = new Client(editFirstName.getText().toString(), editLastName.getText().toString(), editTel.getText().toString(), getWorldClassGym());
                gymClients.add(client);
                adapter.notifyDataSetChanged();
            }
        });
        // pass results to listViewAdapter class
        adapter = new WorldClassClientsAdapter(this, gymClients);
        listView.setAdapter(adapter);
    }

    private Gym getWorldClassGym() {
        Gym gym = null;
        for (int i = 0; i < myUser.myGyms.size(); i++) {
            gym = myUser.myGyms.get(i);
            if (gym.getTitle().equals("World Class")) {
                break;
            }
        }
        return gym;
    }
}