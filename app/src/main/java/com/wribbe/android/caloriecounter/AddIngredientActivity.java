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
            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Utils.toast(view_context, "Pressed save.");
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

    protected void returnOutput() {
        System.out.println("Start of return Output.");
        Intent output = new Intent();
        output.putExtra("message", "Hello caller.");
        setResult(Activity.RESULT_OK, output);
        System.out.println("End of return Output.");
//        finish();
    }

    private String getTextFromField(int id) {
        return ((EditText) findViewById(id)).getText().toString();
    }
}
