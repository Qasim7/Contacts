package com.example.qasim.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.qasim.contacts.model.Person;

public class ScrollingActivity extends AppCompatActivity {
    TextView nameC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        nameC=findViewById(R.id.name_c);
        Intent intent=getIntent();
        int id = intent.getIntExtra("id",-1);
        SQLDatabaseAdapter db = new SQLDatabaseAdapter(this);
        Person person=db.getPersonWithId(id);
        nameC.setText(person.getName()+" \n"+person.getNumber()+" \n"+person.getEmail()+" \n"+person.getZipcode());
    }
}
