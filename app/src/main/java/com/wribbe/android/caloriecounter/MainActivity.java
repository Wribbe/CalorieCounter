package com.wribbe.android.caloriecounter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    protected final int ADD_INGREDIENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton add_ingredient = (FloatingActionButton) findViewById(R.id.add_ingredient);
        add_ingredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIngredient(view);
            }
        });
    }

    public void addIngredient(View view) {
        System.out.println("addIngredient start.");
        Intent intent = new Intent(this, AddIngredientActivity.class);
        startActivityForResult(intent, ADD_INGREDIENT);
        System.out.println("addIngredient stop.");

        String filename = "test.txt";
        //String data = "This is some test data..";
        String data = "This is some test data..\nWhit a second line?\n";

        writeFile(filename, data);
        String resultFromFile = readFile(filename);

        String format = "Data written to file %s: %s";
        System.out.println(String.format(format, filename, data));

        format = "Result from reading file %s: %s";
        System.out.println(String.format(format, filename, resultFromFile));
    }

    public void writeFile(String filename, String data) {
        try {
            FileOutputStream fileStream = this.openFileOutput(filename, Context.MODE_PRIVATE);
            OutputStreamWriter outputStream = new OutputStreamWriter(fileStream);
            outputStream.write(data);
            outputStream.close();

        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public String readFile(String filename) {
        //String ret = "";
        String ret = "";
        try {

            InputStream inputStream = openFileInput(filename);

            if (inputStream != null) {

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();

                String currentLine = "";

                while ((currentLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(currentLine);
                    stringBuilder.append("\n");
                }

                inputStream.close();

                ret = stringBuilder.toString().trim();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e .toString());
        }

        return ret;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        System.out.println("Does this fire?");
        System.out.println(data.getStringExtra("message"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
