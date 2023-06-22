//package firstlook.jihad.assignment_one;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class MainActivity extends AppCompatActivity {
//    Spinner spinner;
//    Button chosen_btn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.DarkOliveGreen)));
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        spinner = findViewById(R.id.spinner);
//        chosen_btn = findViewById(R.id.chosen_btn);
//        String[] courses = {"Choose A Course", "Math", "Science", "Chemistry", "English", "History"};
//        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(courses));
//        arrayList.remove(0); // Remove the first element of the list (i.e. "Choose A Course")
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_style, arrayList);
//        spinner.setAdapter(arrayAdapter);
//
//        chosen_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String course = spinner.getSelectedItem().toString();
//                if (course.equals("Math")) {
//                    Toast.makeText(getApplicationContext(), course, Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please select Math", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//    }
//}
package firstlook.jihad.assignment_one;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import firstlook.jihad.assignment_one.model.Item;
import firstlook.jihad.assignment_one.model.RecyclerAdapter;

public class MainActivity extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main_test);
                TextView t1;
                t1 = findViewById(R.id.textViewMainTest);
                SharedPreferences sp = getApplicationContext().getSharedPreferences("myUserPref", Context.MODE_PRIVATE);
                String name = sp.getString("name","");
                t1.setText(name);
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                List<Item> items = new ArrayList<Item>();
                items.add(new Item("Arabic", "Teacher: Ahmad",R.drawable.arabic));
                items.add(new Item("Math", "Teacher: Salah",R.drawable.math));
                items.add(new Item("Science", "Teacher: Dana",R.drawable.science));

                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(),items));
                recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                        @Override
                        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                                View child = rv.findChildViewUnder(e.getX(),e.getY());
                                if(child != null && e.getAction() == MotionEvent.ACTION_UP){
                                        int position = rv.getChildAdapterPosition(child);
                                        // Start the AnotherActivity when an item is clicked
                                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                        startActivity(intent);
                                }
                                return false;
                        }

                        @Override
                        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                        }

                        @Override
                        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                        }
                });
        }


        }