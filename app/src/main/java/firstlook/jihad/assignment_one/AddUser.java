package firstlook.jihad.assignment_one;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class AddUser extends AppCompatActivity {

    EditText name, grade;
    Button button;
    Button button2;
    SharedPreferences sp;
    String nameStr;
    String gradeStr;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);
        name = findViewById(R.id.studentName);
        grade = findViewById(R.id.studentGrade);
        button = findViewById(R.id.buttonSubmit);
        button2 = findViewById(R.id.doneButton);
        sp = getSharedPreferences("myUserPref", Context.MODE_PRIVATE);


        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                nameStr = name.getText().toString();
                gradeStr = name.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name",nameStr);
                editor.putString("grade",gradeStr);
                editor.commit();
                Toast.makeText(AddUser.this,"InfoSaved",Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(AddUser.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
