package com.mesutozturk.myaddressbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnNew;
    ListView lstContact;
    BaseAdapter adapter;
    LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNew = findViewById(R.id.btn_new);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddPersonActivity.class));
            }
        });

        layoutInflater = LayoutInflater.from(this);
        lstContact = findViewById(R.id.lst_contact);

        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                //collection size
                return Contact.PersonList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null)
                    convertView = layoutInflater.inflate(R.layout.mylist_item, null);

                final Person listPerson = Contact.PersonList.get(position);

                TextView txtname = convertView.findViewById(R.id.list_txtname);
                TextView txtsurname = convertView.findViewById(R.id.list_txtsurname);

                txtname.setText(listPerson.getName());
                txtsurname.setText(listPerson.getSurname());

                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (TextUtils.isEmpty(listPerson.getPhoneNumber())) {
                            Toast.makeText(MainActivity.this, listPerson.getName() + " haven't a phone number!", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + listPerson.getPhoneNumber()));

                            if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                Toast.makeText(MainActivity.this, "We havn't call perm.", Toast.LENGTH_SHORT).show();

                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 100);
                                return;
                            }
                            startActivity(intent);
                        }
                    }
                });

                return convertView;
            }
        };

        lstContact.setAdapter(adapter);
        };
    }
}
