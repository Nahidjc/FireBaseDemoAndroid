package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText idText,nameText,courseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idText = findViewById(R.id.editTextID);
        nameText=findViewById(R.id.editTextNameID);
        courseText=findViewById(R.id.editTextCourseID);
    }

    public void InsertProcess(View view) {
        String id = idText.getText().toString();
        String name = nameText.getText().toString();
        String course = courseText.getText().toString();
        DataStorageHelper mydata = new DataStorageHelper(name,course);
        FirebaseDatabase Fdb = FirebaseDatabase.getInstance();
        DatabaseReference node = Fdb.getReference("students");
        node.child(id).setValue(mydata);
        idText.setText("");
        nameText.setText("");
        courseText.setText("");
        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
    }
}