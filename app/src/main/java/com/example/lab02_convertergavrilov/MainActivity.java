package com.example.lab02_convertergavrilov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

//393 Гаврилов Конвертер
public class MainActivity extends AppCompatActivity {

    Spinner spFrom, spTo;
    EditText etFrom;
    TextView tvTo;
    RadioButton rbTime, rbLenght, rbWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.spinner_from);
        spTo = findViewById(R.id.spinner_to);
        etFrom = findViewById(R.id.editText_Value);
        tvTo = findViewById(R.id.textView_Result);
        rbTime = findViewById(R.id.radioButton_Time);
        rbLenght = findViewById(R.id.radioButton_Lenght);
        rbWeight = findViewById(R.id.radioButton_Weight);

        //Предварительная загрузка адаптера
        ArrayAdapter <Object> adp = new <Object> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        Unit unit;
        unit = new Unit("day", 3600*24);
        adp.add(unit);
        unit = new Unit("hour", 3600);
        adp.add(unit);
        unit = new Unit("minute", 60);
        adp.add(unit);
        unit = new Unit("second", 1);
        adp.add(unit);
        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    //Конвертация из одной величины в другую
    public void onConverter_Click(View vi)
    {
        String sa = etFrom.getText().toString();

        double from = 0;

        if(sa.length() == 0)
        {
            tvTo.setText("text field From is empty");
        }

        try {
            from = Double.parseDouble(etFrom.getText().toString());
        }
        catch (Exception ex)
        {
            tvTo.setText("text field From is not a valid number");
            return;
        }

        Unit unit_From = (Unit) spFrom.getSelectedItem();
        Unit unit_To = (Unit) spTo.getSelectedItem();
        tvTo.setText(String.valueOf(from * unit_From.coef / unit_To.coef));
    }

    //Изменение адаптера путем переключения radioButton
    public  void onRadioButton_Click(View vi)
    {
        ArrayAdapter <Object> adp = new <Object> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        Unit unit;

        switch ((String)vi.getTag())
        {
            case "1":
                rbLenght.setChecked(false);
                rbWeight.setChecked(false);
                unit = new Unit("day", 3600*24);
                adp.add(unit);
                unit = new Unit("hour", 3600);
                adp.add(unit);
                unit = new Unit("minute", 60);
                adp.add(unit);
                unit = new Unit("second", 1);
                adp.add(unit);
                break;
            case "2":
                rbWeight.setChecked(false);
                rbTime.setChecked(false);
                unit = new Unit("mm", 0.001);
                adp.add(unit);
                unit = new Unit("cm", 0.01);
                adp.add(unit);
                unit = new Unit("m", 1);
                adp.add(unit);
                unit = new Unit("km", 1000);
                adp.add(unit);
                break;
            case "3":
                rbLenght.setChecked(false);
                rbTime.setChecked(false);
                unit = new Unit("mg", 0.000001);
                adp.add(unit);
                unit = new Unit("gr", 0.001);
                adp.add(unit);
                unit = new Unit("kg", 1);
                adp.add(unit);
                unit = new Unit("ton", 1000);
                adp.add(unit);
                break;
        }

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }
}