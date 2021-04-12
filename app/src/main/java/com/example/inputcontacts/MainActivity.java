package com.example.inputcontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;

// Made with the help of https://youtu.be/jjL4R-aiwPE and https://developer.android.com/training/contacts-provider/modify-data#create-an-intent

// Automatically make 911 an emergency contact?

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText phone;
    private Button addContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        phone = findViewById(R.id.etPhone);
        addContact = findViewById(R.id.btnAdd);

        addContact.setOnClickListener(new View.OnClickListener()); {

            public void onClick(View v); {

                if (!name.getText().toString().isEmpty() || !phone.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent1 = intent.setType(ContactsContract.RawContact.CONTENT_TYPE);
                    intentName = intent.putExtra(ContactsContract.Intents.Insert.NAME, name.getText().toString());
                    intentPhone = intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone.getText().toString());

                    if(intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);

                    else
                        Toast.makeText(context: MainActivity.this, text: "There is no app that supports this action", Toast.LENGTH_SHORT);

                }

                else
                    Toast.makeText(context: MainActivity.this, text: "Please fill in all fields", Toast.LENGTH_SHORT);

            }

        }

    }

}