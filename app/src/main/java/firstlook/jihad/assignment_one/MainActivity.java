package firstlook.jihad.assignment_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

        String[] courses = {"Chemistry","Math","Science","Test","Test","Test","English","Chemistry","Math","Science","Test","Test","Test","English","Arabic","History"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(courses));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.spinner_style,arrayList);
        spinner.setAdapter(arrayAdapter);
    }
}