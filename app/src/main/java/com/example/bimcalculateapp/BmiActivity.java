
package com.example.bimcalculateapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import com.example.bimcalculateapp.databinding.ActivityBmiBinding;

public class BmiActivity extends AppCompatActivity {
    ActivityBmiBinding binding;
    String BMI;
    float intBMI;
    String height, weight;
    float intHeight, intWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bmi);


        height = getIntent().getStringExtra("height");
        weight = getIntent().getStringExtra("weight");
        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);
        intHeight = intHeight / 100;
        intBMI = intWeight / (intHeight * intHeight);
        BMI = Float.toString(intBMI);
        if (intBMI < 16) {
            binding.tvYourBmiCategoryIs.setText("Server Thinness");
            binding.constraintLayout3.setBackgroundColor(Color.RED);
            binding.ivOkOk1.setImageResource(R.drawable.crosss);

        } else if (intBMI < 19.9 && intBMI > 16) {
            binding.tvYourBmiCategoryIs.setText("Moderate Thinness");
            binding.constraintLayout3.setBackgroundColor(Color.RED);
            binding.ivOkOk1.setImageResource(R.drawable.warning);
        } else if (intBMI < 18.4 && intBMI > 17) {
            binding.tvYourBmiCategoryIs.setText("Mild Thinness");
            binding.constraintLayout3.setBackgroundColor(Color.RED);
            binding.ivOkOk1.setImageResource(R.drawable.warning);
        } else if (intBMI < 25 && intBMI > 18.4) {
            binding.tvYourBmiCategoryIs.setText("Normal");
            binding.constraintLayout3.setBackgroundColor(Color.YELLOW);
            binding.ivOkOk1.setImageResource(R.drawable.ok);
        } else if (intBMI < 29.4 && intBMI > 25) {
            binding.tvYourBmiCategoryIs.setText("Over Weight");
            binding.constraintLayout3.setBackgroundColor(Color.RED);
            binding.ivOkOk1.setImageResource(R.drawable.warning);
        } else {
            binding.tvYourBmiCategoryIs.setText("Obese Class I");
            binding.constraintLayout3.setBackgroundColor(Color.RED);
            binding.ivOkOk1.setImageResource(R.drawable.warning);
        }
        binding.tvGender.setText(getIntent().getStringExtra("gender"));
        binding.tv55BimActivity.setText(BMI);

        binding.btnReCalculateBim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}