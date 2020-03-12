package com.mesutozturk.myaddressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPersonActivity extends AppCompatActivity {
    EditText txtName, txtSurname, txtPhone;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        txtName = findViewById(R.id.txt_name);
        txtSurname = findViewById(R.id.txt_surname);
        txtPhone = findViewById(R.id.txt_phone);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person newPerson = new Person();
                newPerson.setName(txtName.getText().toString());
                newPerson.setSurname(txtSurname.getText().toString());
                newPerson.setPhoneNumber(txtPhone.getText().toString());

                Contact.PersonList.add(newPerson);
                Toast.makeText(AddPersonActivity.this, "Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
