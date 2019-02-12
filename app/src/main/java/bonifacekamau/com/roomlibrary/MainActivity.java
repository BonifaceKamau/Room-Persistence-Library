package bonifacekamau.com.roomlibrary;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputNames, inputAge;
    TextView txtRecords;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNames = findViewById(R.id.inputNames);
        inputAge = findViewById(R.id.inputAge);
        txtRecords = findViewById(R.id.txtRecords);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save info
                save();
            }
        });

        MyDatabase.getInstance(this).getUserDao().getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                txtRecords.setText(integer+"");
            }
        });
    }

    private void save() {
        String names = inputNames.getText().toString().trim();
        String age_String = inputAge.getText().toString().trim();

        if (names.isEmpty() || age_String.isEmpty()){
            Toast.makeText(this, "Fill All Values", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(age_String);

        User x = new User();
        x.setName(names);
        x.setAge(age);

        MyDatabase.getInstance(this).getUserDao().insertUser(x);

        //int count = MyDatabase.getInstance(this).getUserDao().getCount();

        //txtRecords.setText(count+"");

        inputNames.setText("");
        inputAge.setText("");
    }
}
