package edu.temple.paletteactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity implements SpinnerFragment.GetColorInterface {
    CanvasFragment canvasFragment;

    boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette); //asdf

        singlePane = findViewById(R.id.container_2) == null;
        canvasFragment = new CanvasFragment();
        SpinnerFragment spinnerFragment = new SpinnerFragment();
        addFragment(spinnerFragment, R.id.container_1);


        if (!singlePane) {
            addFragment(canvasFragment, R.id.container_2);
        }

    }

    private void addFragment(Fragment fragment, int containerID){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerID, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void colorSelected(String colorSelected) { //calls a new CanvasFragment to be created based on colorselected on previous fragment.
        if (singlePane) {

            Bundle bundle = new Bundle();
            bundle.putString("color", colorSelected);

            canvasFragment.setArguments(bundle);//creates canvas fragment with a colorSelected argument will use string in a bundle and set arguments in that string

            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.container_1, canvasFragment) //replaces container1 with new fragment if single pane. covers spinner fragment if you will
                    .addToBackStack(null)
                    .commit();

            fm.executePendingTransactions();//enforce all the pending transactions before lines after.
            canvasFragment.change(); //asynchronize, not sychronized. parallel


        }

        else {
             //creates canvas fragment with a colorSelected argument will use string in a bundle and set arguments in that string
            Bundle bundle = new Bundle();
            bundle.putString("color", colorSelected);

            canvasFragment.setArguments(bundle);

            canvasFragment.change();

//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container_2, canvasFragment) //replaces container1 with new fragment if single pane. covers spinner fragment if you will
//                    .addToBackStack(null)
//                    .commit();

        }

    }

}
