package com.example.lab02_convertergavrilov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spFrom, spTo;
    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.spinner_from);
        spTo = findViewById(R.id.spinner_to);
        etFrom = findViewById(R.id.editTextTextPersonName2);
        tvTo = findViewById(R.id.textView7);

        ArrayAdapter <Object> adp = new <Object> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        Unit unit = new Unit("mm", 0.001);
        adp.add(unit);
        unit = new Unit("m", 1);
        adp.add(unit);

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void on_converter(View vi)
    {
        double from = Double.parseDouble(etFrom.getText().toString());

        Unit unit_From = (Unit) spFrom.getSelectedItem();
        Unit unit_To = (Unit) spTo.getSelectedItem();
        tvTo.setText(String.valueOf(from/unit_To.coef*unit_From.coef));
    }
}