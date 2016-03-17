package com.wribbe.android.caloriecounter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddIngredientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);
        //returnOutput();
        Button button_cancel = (Button) findViewById(R.id.ingredients_button_cancel);
        Button button_save = (Button) findViewById(R.id.ingredients_button_save);

        final Context view_context = this;

        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Utils.toast(view_context, "Pressed cancel.");
                return_cancel();
            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Utils.toast(view_context, "Pressed save.");
                parseInput();
            }
        });

    }

    @Override
    protected void onPause(){
        super.onPause();
        String ingredientName = getTextFromField(R.id.ingredient_name);

        if (ingredientName.equals("")) {
            System.out.println("No ingredient name.");
        } else {
            System.out.println(ingredientName);
        }
    }

    protected void parseInput() {
        String name =  getTextFromField(R.id.ingredient_name);
        String calories =  getTextFromField(R.id.ingredient_calories);

        returnOutput(name, calories);
    }

    protected void return_cancel() {
        Intent cancel_intent = new Intent();
        setResult(Activity.RESULT_CANCELED, cancel_intent);
        finish();
    }

    protected void returnOutput(String name, String calories) {
        Intent output = new Intent();

        output.putExtra(getString(R.string.ingredient_flag_name), name);
        output.putExtra(getString(R.string.ingredient_flag_calories), calories);
        setResult(Activity.RESULT_OK, output);
        finish();
    }

    private String getTextFromField(int id) {
        return ((EditText) findViewById(id)).getText().toString();
    }
}
