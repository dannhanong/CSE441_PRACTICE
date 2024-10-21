package com.ktpm1.btth03;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewStudents;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        studentList = new ArrayList<>();

        String jsonString = "[{\"id\":\"1\",\"fullName\":{\"first\":\"Nguyễn\",\"midd\":\"Văn\",\"last\":\"A\"},\"gpa\":3.5,\"avatar\":\"\"}," +
                "{\"id\":\"2\",\"fullName\":{\"first\":\"Nguyễn\",\"midd\":\"Văn\",\"last\":\"B\"},\"gpa\":3.6,\"avatar\":\"\"}]";

//        String jsonString = JsonUtils.loadJSONFromAsset(this, "student.json");
        
        Gson gson = new Gson();
        Type studentListType = new TypeToken<ArrayList<Student>>(){}.getType();
        List<Student> students = gson.fromJson(jsonString, studentListType);

        students.stream().map(student -> {
            student.setYear(R.drawable.user);
            return student;
        }).forEach(studentList::add);
//        student.setYear(R.drawable.user);
//        studentList.add(student);

        recyclerViewStudents = findViewById(R.id.recyclerViewStudents);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter = new StudentAdapter(studentList);

        recyclerViewStudents.setAdapter(studentAdapter);
    }
}