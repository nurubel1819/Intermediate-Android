package com.example.intermediateandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DB_Activity extends AppCompatActivity {

    Button insert_data,update,delete,delete_all;
    EditText add_number,update_id,delete_id;
    ListView listView_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_db);


        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        // get id
        insert_data = findViewById(R.id.insert_data);
        listView_contact = findViewById(R.id.red_data);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        update_id = findViewById(R.id.update_id);
        delete_id = findViewById(R.id.delete_id);
        add_number = findViewById(R.id.insert_text);
        delete_all = findViewById(R.id.delete_all);


        Database_class object = new Database_class(DB_Activity.this);
        ArrayList<contact_model> all_number = object.get_contact_number();
        ArrayList<String> phone_number = new ArrayList<>();

        for(int i=0;i<all_number.size();i++)
        {
            phone_number.add(Integer.toString(all_number.get(i).id)+" "+all_number.get(i).name+" "+all_number.get(i).number);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(DB_Activity.this,android.R.layout.simple_list_item_1,phone_number);
        listView_contact.setAdapter(adapter);

        insert_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_number = add_number.getText().toString();
                String name="",number="";
                boolean flag = true;
                for(int i=0;i<name_number.length();i++)
                {
                    if(name_number.charAt(i)==',') flag = false;
                    else  if(name_number.charAt(i)!=',' && flag) name+=name_number.charAt(i);
                    else number+=name_number.charAt(i);
                }

                Database_class ob = new Database_class(DB_Activity.this);
                ob.add_contact(name,number);

                Toast toast = Toast.makeText(DB_Activity.this,"Insert successful",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact_model model = new contact_model();
                String id_number = update_id.getText().toString();
                String id="",number="";
                boolean flag = true;

                for(int i=0;i<id_number.length();i++)
                {
                    if(id_number.charAt(i)==',') flag=false;
                    else if(id_number.charAt(i)!=',' && flag) id+=id_number.charAt(i);
                    else number+=id_number.charAt(i);
                }
                model.id = Integer.parseInt(id);
                model.number = number;

                Database_class ob = new Database_class(DB_Activity.this);
                ob.update_data(model);

                Toast toast = Toast.makeText(DB_Activity.this,"Update successful",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database_class ob = new Database_class(DB_Activity.this);
                ob.delete_data(Integer.parseInt(delete_id.getText().toString()));

                Toast toast = Toast.makeText(DB_Activity.this,"delete successful",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        delete_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql = "delete from contact_number";
                Database_class ob = new Database_class(DB_Activity.this);
                ob.manual_sql(sql);
            }
        });

    }
}