package com.example.week2day2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private ConstraintLayout layout;
    private TextView titleTV;
    private TextView makeTV, modelTV, yearTV, titleStatusTV;
    private TextView colorTV, engineTV, transmissionTV;

    private final static int REQUEST_CODE = 404;
    private final static String MAKE = "MAKE";
    private final static String MODEL = "MODEL";
    private final static String INFO_VISIBILITY = "INFO_VISIBILITY";
    private final static String TITLE_VISIBILITY = "TITLE_VISIBILITY";
    private static final String CAR_INFO = "CAR_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(CAR_INFO, MODE_PRIVATE);
        initViews();

    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                setTextViewsText(data.getExtras());
                editPreferences();
            }
        }
    }

    private void editPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MAKE, makeTV.getText().toString());
        editor.putString(MODEL, modelTV.getText().toString());
        editor.putInt(INFO_VISIBILITY, View.VISIBLE);
        editor.putInt(TITLE_VISIBILITY, View.GONE);
        editor.commit();
    }

    private void setTextViewsText(Bundle data) {
        Car car = data.getParcelable(SecondActivity.CAR_INFO);
        makeTV.setText(car.getMake());
        modelTV.setText(car.getModel());
        yearTV.setText(car.getYear());
        titleStatusTV.setText(car.getTitleStatus());
        colorTV.setText(car.getColor());
        engineTV.setText(car.getEngine());
        transmissionTV.setText(car.getTransmission());
        layout.setVisibility(View.VISIBLE);
        titleTV.setVisibility(View.GONE);
    }

    private void initViews() {
        // If there is no car info stored, the default text won't be displayed
        layout = findViewById(R.id.carInfo);
        layout.setVisibility(sharedPreferences.getInt(INFO_VISIBILITY, View.GONE));
        titleTV = findViewById(R.id.noCarSelected);
        titleTV.setVisibility(sharedPreferences.getInt(TITLE_VISIBILITY, View.VISIBLE));

        makeTV = findViewById(R.id.make);
        modelTV = findViewById(R.id.model);
        yearTV = findViewById(R.id.year);
        titleStatusTV = findViewById(R.id.titleStatus);
        colorTV = findViewById(R.id.color);
        engineTV = findViewById(R.id.engine);
        transmissionTV = findViewById(R.id.transmission);

        makeTV.setText(sharedPreferences.getString(MAKE, ""));
        modelTV.setText(sharedPreferences.getString(MODEL, ""));
    }
}
