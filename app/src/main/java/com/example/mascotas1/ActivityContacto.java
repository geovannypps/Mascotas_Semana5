package com.example.mascotas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityContacto extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNombre;
    private EditText txtCorreo;
    private EditText txtMEnsaje;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBAr=(Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBAr);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtCorreo=(EditText)findViewById(R.id.txtCorreo);
        txtMEnsaje=(EditText)findViewById(R.id.txtMensaje);
        btnEnviar=(Button)findViewById(R.id.btnEnviarContacto);
        btnEnviar.setOnClickListener(this);

    }

    private void sendEmail(){
        String nombre=txtNombre.getText().toString().trim();
        String correo=txtCorreo.getText().toString().trim();

        String mensaje=txtMEnsaje.getText().toString().trim();

        SendMail sm = new SendMail(this,nombre,correo,mensaje);
        sm.execute();

    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}