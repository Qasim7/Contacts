package com.example.qasim.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.qasim.contacts.adapter.ContactAdapter;
import com.example.qasim.contacts.model.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Person> items;
    private SQLDatabaseAdapter dbAdapter;
    private ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAdapter=new SQLDatabaseAdapter(this);
        items=dbAdapter.getAllPersons();
        contactAdapter=new ContactAdapter(items,this);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_contact,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addContact:
//                Intent intent=new Intent(MainActivity.this,NewContactActivity.class);
//                startActivityForResult(intent,0);    ////isleyir
                startActivity(new Intent(MainActivity.this,NewContactActivity.class)); ////isleyir
        }
        return super.onOptionsItemSelected(item);
    }
}
