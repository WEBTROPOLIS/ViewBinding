package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityProfileBinding;

public class profile extends AppCompatActivity {
    private ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Obtenemos los datos pasados por profileIntent
        Intent intent = getIntent();
        int imgId = intent.getIntExtra("imgUser",0);
        String userNom = intent.getStringExtra("userNom");
        String userMail = intent.getStringExtra("userMail");
        String userPhone = intent.getStringExtra("userPhone");

        //Asignamos  los valos obtenidos en las variables
        binding.imgUsuario.setImageResource(imgId);
        binding.txtNom.setText(userNom);
        binding.txtMail.setText(userMail);
        binding.txtPhone.setText(userPhone);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}