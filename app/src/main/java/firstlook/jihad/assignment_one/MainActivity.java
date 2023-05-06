package firstlook.jihad.assignment_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button chosen_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.DarkOliveGreen)));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        chosen_btn = findViewById(R.id.chosen_btn);
        String[] courses = {"Choose A Course", "Math", "Science", "Chemistry", "English", "History"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(courses));
        arrayList.remove(0); // Remove the first element of the list (i.e. "Choose A Course")
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_style, arrayList);
        spinner.setAdapter(arrayAdapter);

        chosen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course = spinner.getSelectedItem().toString();
                if (course.equals("Math")) {
                    Toast.makeText(getApplicationContext(), course, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please select Math", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
