package com.example.week2day2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText makeET, modelET, yearET, titleStatusET;
    private EditText colorET, engineET, transmissionET;

    public static final String CAR_INFO = "CAR_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setViews();
    }

    public void saveData(View view) {
        if (!isAnyViewEmpty()) {

            String make= makeET.getText().toString();
            String model = modelET.getText().toString();
            String year = yearET.getText().toString();
            String title = titleStatusET.getText().toString();
            String color= colorET.getText().toString();
            String engine = engineET.getText().toString();
            String transmission = transmissionET.getText().toString();

            Car car = new Car(make, model, year, title, color, engine, transmission);

            passInfoBackToActivity(car);
        } else {
            Toast.makeText(getApplicationContext(), "Fill all the fields", Toast.LENGTH_LONG).show();
        }
    }

    private void passInfoBackToActivity(Car car) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CAR_INFO, car);
        Intent intentBack = new Intent();
        intentBack.putExtras(bundle);
        setResult(Activity.RESULT_OK, intentBack);
        finish();
    }

    private boolean isAnyViewEmpty() {
        return makeET.getText().toString().isEmpty() ||
                modelET.getText().toString().isEmpty() ||
                yearET.getText().toString().isEmpty() ||
                titleStatusET.getText().toString().isEmpty() ||
                colorET.getText().toString().isEmpty() ||
                engineET.getText().toString().isEmpty() ||
                transmissionET.getText().toString().isEmpty();
    }

    private void setViews() {
        makeET = findViewById(R.id.make);
        modelET = findViewById(R.id.model);
        yearET = findViewById(R.id.year);
        titleStatusET = findViewById(R.id.titleStatus);
        colorET = findViewById(R.id.color);
        engineET = findViewById(R.id.engine);
        transmissionET = findViewById(R.id.transmission);
    }
}
