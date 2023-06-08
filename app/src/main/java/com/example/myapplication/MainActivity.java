package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
 private ActivityMainBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent profileIntent = new Intent(MainActivity.this, profile.class);

        binding.imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear la animación de escala
                Animation animation = new ScaleAnimation(
                        1f, 0.8f, // Escala de inicio y fin en el eje X
                        1f, 0.8f, // Escala de inicio y fin en el eje Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Punto de pivote de la escala en el eje X
                        Animation.RELATIVE_TO_SELF, 0.5f // Punto de pivote de la escala en el eje Y
                );
                animation.setDuration(200); // Duración de la animación en milisegundos
                animation.setInterpolator(new OvershootInterpolator()); // Interpolador de la animación

                // Aplicar la animación al ImageView
                binding.imgUser.startAnimation(animation);

                Toast.makeText(MainActivity.this,"Click en Imagen de Usuario",Toast.LENGTH_SHORT).show();
            }
        });

        binding.imgLogo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear la animación de escala
                Animation animation = new ScaleAnimation(
                        1f, 0.8f, // Escala de inicio y fin en el eje X
                        1f, 0.8f, // Escala de inicio y fin en el eje Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Punto de pivote de la escala en el eje X
                        Animation.RELATIVE_TO_SELF, 0.5f // Punto de pivote de la escala en el eje Y
                );
                animation.setDuration(200); // Duración de la animación en milisegundos
                animation.setInterpolator(new OvershootInterpolator()); // Interpolador de la animación

                // Aplicar la animación al ImageView
                binding.imgLogo3.startAnimation(animation);

                Toast.makeText(MainActivity.this,"Click en LOGO 3",Toast.LENGTH_SHORT).show();
            }
        });
        binding.imgLogo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear la animación de escala
                Animation animation = new ScaleAnimation(
                        1f, 0.8f, // Escala de inicio y fin en el eje X
                        1f, 0.8f, // Escala de inicio y fin en el eje Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Punto de pivote de la escala en el eje X
                        Animation.RELATIVE_TO_SELF, 0.5f // Punto de pivote de la escala en el eje Y
                );
                animation.setDuration(200); // Duración de la animación en milisegundos
                animation.setInterpolator(new OvershootInterpolator()); // Interpolador de la animación

                // Aplicar la animación al ImageView
                binding.imgLogo2.startAnimation(animation);

                Toast.makeText(MainActivity.this,"Click en LOGO 2",Toast.LENGTH_SHORT).show();
            }
        });


        binding.imgLogo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear la animación de escala
                Animation animation = new ScaleAnimation(
                        1f, 0.8f, // Escala de inicio y fin en el eje X
                        1f, 0.8f, // Escala de inicio y fin en el eje Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Punto de pivote de la escala en el eje X
                        Animation.RELATIVE_TO_SELF, 0.5f // Punto de pivote de la escala en el eje Y
                );
                animation.setDuration(200); // Duración de la animación en milisegundos
                animation.setInterpolator(new OvershootInterpolator()); // Interpolador de la animación

                // Aplicar la animación al ImageView
                binding.imgLogo1.startAnimation(animation);

                Toast.makeText(MainActivity.this,"Click en LOGO 1",Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flagValidaDatos=true;
                String email = binding.userMail.getText().toString().trim();
                String phoneNum = binding.userPhone.getText().toString().trim();
                if (binding.userNom.getText().toString().trim().isEmpty()){
                    binding.divNom.setError("Debe ingresar su nombre");
                    flagValidaDatos=false;
                }

                if (!isValidEmail(email)){
                    binding.divMail.setError("E-mail incorrecto (usuario@mail.com)");
                    flagValidaDatos=false;
                }

                if (!isValidPhone(phoneNum)){
                    binding.divPhone.setError("Número de telefono incorrecto (10 y 13 caracteres)");
                    flagValidaDatos=false;
                }

                if (flagValidaDatos){
                    profileIntent.putExtra("imgUser",R.drawable.user_picture);
                    profileIntent.putExtra("userNom",binding.userNom.getText().toString().trim().toUpperCase());
                    profileIntent.putExtra("userMail",binding.userMail.getText().toString().trim().toUpperCase());
                    profileIntent.putExtra("userPhone",binding.userPhone.getText().toString().trim().toUpperCase());
                    startActivity(profileIntent);

                }

            }
        });
        binding.divPhone.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //no lo implementamos
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //no lo implementamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input =s.toString().trim();
                if (!input.isEmpty()){
                    binding.divPhone.setError(null);
                    binding.divPhone.setBoxStrokeColor(ContextCompat.getColor(MainActivity.this,R.color.yellow));
                }
            }
        });

        binding.divMail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //no lo implementamos
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //no lo implementamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input =s.toString().trim();
                if (!input.isEmpty()){
                    binding.divMail.setError(null);
                    binding.divMail.setBoxStrokeColor(ContextCompat.getColor(MainActivity.this,R.color.yellow));
                }
            }
        });

        binding.divNom.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //no lo implementamos
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //no lo implementamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input =s.toString().trim();
                if (!input.isEmpty()){
                    binding.divNom.setError(null);
                    binding.divNom.setBoxStrokeColor(ContextCompat.getColor(MainActivity.this,R.color.yellow));
                }
            }
        });


    }
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    private boolean isValidPhone(String phoneNumber) {
        String phonePattern = "^[+]?[0-9]{10,13}$";
        return phoneNumber.matches(phonePattern);
    }
}