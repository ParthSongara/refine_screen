package com.example.refinescreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        TextView titleTextView = findViewById(R.id.titleTextView);
        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        SeekBar priceSeekBar = findViewById(R.id.priceSeekBar);
        Button applyButton = findViewById(R.id.applyButton);

        // Set up the spinner with categories
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"Electronics", "Clothing", "Home Decor", "Books"});
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(spinnerAdapter);

        // Set up the seekbar for price range
        priceSeekBar.setMax(100);
        priceSeekBar.setProgress(50);

        // Apply button click listener
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve selected category and price range
                String selectedCategory = categorySpinner.getSelectedItem().toString();
                int selectedPrice = priceSeekBar.getProgress();

                // Perform actions or apply filters based on the selected category and price range
                // For simplicity, let's just display a toast message with the selected filters
                String message = "Selected Category: " + selectedCategory +
                        "\nPrice Range: $" + selectedPrice;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
