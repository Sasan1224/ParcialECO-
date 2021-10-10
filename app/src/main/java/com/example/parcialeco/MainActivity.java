package com.example.parcialeco;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialeco.politos.Politos;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText politos;
    private EditText xPos;
    private EditText yPos;
    boolean delete;
    boolean newPolo;
    Button redButton, greenButton, blueButton;
    Button newPoloButton, deleteButton;
    int r,g,b;



    private Socket socket;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        politos = findViewById(R.id.politos);
        xPos = findViewById(R.id.xPos);
        yPos = findViewById(R.id.yPos);

        redButton = findViewById(R.id.redButton);
        greenButton = findViewById(R.id.greenButton);
        blueButton = findViewById(R.id.blueButton);

        newPoloButton = findViewById(R.id.newPoloButton);
        deleteButton = findViewById(R.id.deleteButton);

       newPolo=false;
        delete=false;

        initClient();

        redButton.setOnClickListener(
                (view) ->
                {
                    r = 250;
                    g = 150;
                    b = 170;
                }
        );
        greenButton.setOnClickListener(
                (view) ->
                {
                    r = 180;
                    g = 250;
                    b = 200;
                }
        );
        blueButton.setOnClickListener(
                (view) ->
                {
                    r = 175;
                    g = 180;
                    b = 250;
                }
        );

        newPoloButton.setOnClickListener(
                (view)->
                {

                    Gson gson = new Gson();

                    String nombre = name.getText().toString();
                    int particulas = Integer.parseInt(politos.getText().toString());
                    int x = Integer.parseInt(xPos.getText().toString());
                    int y = Integer.parseInt(yPos.getText().toString());
                    delete= false;
                    newPolo=true;

                    Politos politos = new Politos(x, y, nombre, particulas, r, g, b, delete);

                    String json = gson.toJson(politos);

                    enviarMensaje(json);

                });


                deleteButton.setOnClickListener(
                        (view)->
                        {
                            Gson gson = new Gson();

                            String nombre = name.getText().toString();
                            int particulas = Integer.parseInt(politos.getText().toString());
                            int x = Integer.parseInt(xPos.getText().toString());
                            int y = Integer.parseInt(yPos.getText().toString());
                            delete= true;
                            newPolo=false;


                            Politos politos = new Politos(x, y, nombre, particulas, r, g, b, delete);

                            String json = gson.toJson(politos);

                            enviarMensaje(json);


                        });
    }


    public void initClient()
    {

    } public void enviarMensaje(String msg)
    {

    }
}
