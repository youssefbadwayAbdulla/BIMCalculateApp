package com.example.bimcalculateapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.bimcalculateapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int weight = 55;
    int age = 22;
    int currentProgress;
    String mintProgress = "170";
    String typeOfUser = "0";
    String weight2="55";
    String age2="22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.constraintMale.setOnClickListener(view -> {
            binding.constraintMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malfemalfous));
            binding.constraintfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malfemalfous));
            typeOfUser="male";
        });
        binding.constraintfemale.setOnClickListener(view -> {
            binding.constraintfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malfemalfous));
            binding.constraintMale  .setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malfemalfous));
            typeOfUser="female";
        });
        binding.seekBar.setMax(300);
        binding.seekBar.setProgress(170);
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                currentProgress=progress;
                mintProgress=String.valueOf(currentProgress);
                binding.tv170.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.ivAddAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age=age+1;
                age2=String.valueOf(age);
                binding.tvAgeNumber22.setText(age2);

            }
        });
        binding.ivRemoveage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(age==0){return;}
                age=age-1;
                age2=String.valueOf(age);
                binding.tvAgeNumber22.setText(age2);

            }
        });
        binding.ivAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight=weight+1;
                weight2=String.valueOf(weight);
                binding.tv55.setText(weight2);

            }
        });
        binding.ivRemoveWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(weight==0){return;}
                weight=weight-1;
                weight2=String.valueOf(weight);
                binding.tv55.setText(weight2);

            }
        });
        binding.btnCalculateBim.setOnClickListener(view -> {
            if (typeOfUser.equals("0")){
                Toast.makeText(getApplicationContext(), "Select your gender", Toast.LENGTH_SHORT).show();
                return;
            }else if(mintProgress.equals("0")){
                Toast.makeText(getApplicationContext(), "Select your Height", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(age==0||age<0){
                Toast.makeText(getApplicationContext(), "Enter your age", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(weight==0||weight<0){
                Toast.makeText(getApplicationContext(), "Select your Weight", Toast.LENGTH_SHORT).show();
                return;
            }else {


                Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                intent.putExtra("gender",typeOfUser);
                intent.putExtra("height",mintProgress);
                intent.putExtra("weight",weight2);
                intent.putExtra("age",age2);

                startActivity(intent);
                finish();
            }

        });
    }
}