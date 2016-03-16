package com.wribbe.android.caloriecounter;

import android.app.AlertDialog;
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
import android.widget.Toast;

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
        Intent intent = new Intent(this, AddIngredientActivity.class);
        startActivityForResult(intent, ADD_INGREDIENT);
    }

    public void writeFile(String filename, String data) {
        try {
            FileOutputStream fileStream = this.openFileOutput(filename, Context.MODE_PRIVATE);
            OutputStreamWriter outputStream = new OutputStreamWriter(fileStream);
            outputStream.write(data);
            outputStream.close();

        } catch (IOException e) {
            String error = String.format("Could not write to file: %s", filename);
            errorDialog(error);
        }
    }

    public String readFile(String filename) {

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
            String error = String.format("File not found: %s", filename);
            errorDialog(error);
        } catch (IOException e) {
            String error = String.format("Could not read file: %s", filename);
            errorDialog(error);
        }

        return ret;
    }

    private void errorDialog(String error_message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.error_title);
        builder.setMessage(error_message);
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("OK", null);
        builder.create().show();

        Log.e("Error activity", error_message);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String message_string = data.getStringExtra("message");
        String format_string = "request code: %d, resultCode: %d, data: %s";

        String toast = String.format(format_string, requestCode, resultCode, message_string);

        Utils.toast(this, toast);
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
