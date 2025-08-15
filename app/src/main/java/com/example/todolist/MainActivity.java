package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    ArrayList<String> arrdata= new ArrayList<>();
    EditText editText;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        RecyclerView.Adapter adapter=new RecyclerclassAdapter(this,arrdata);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=editText.getText().toString();
                if (data.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter data", Toast.LENGTH_SHORT).show();
                }
                else {
                    arrdata.add(data);
                    RecyclerView.Adapter adapter=new RecyclerclassAdapter(MainActivity.this,arrdata);
                    recyclerView.setAdapter(adapter);
                    editText.setText("");
                }

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void init()
    {
        button=findViewById(R.id.btn);
        recyclerView=findViewById(R.id.recyclerview);
        editText=findViewById(R.id.edittext);

    }

}