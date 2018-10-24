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

public class PaletteActivity extends AppCompatActivity {

    CanvasFragment canvasFragment;
    Spinner customspinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        customspinner = findViewById(R.id.spinner);
        Resources res = this.getResources();
        final String[] spinnerlabels = res.getStringArray(R.array.colors);
        customspinner.setAdapter(new CustomAdapter(this, spinnerlabels));
        customspinner.setSelection(0,false);

        canvasFragment = new CanvasFragment();


        customspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



                    Bundle selectedcolor = new Bundle();
                    selectedcolor.putString("color", spinnerlabels[i]);

                    canvasFragment.setArguments(selectedcolor);
                    addFragment(canvasFragment, R.id.container_1);

                    //findViewById(R.id.fragment_layout).setBackgroundColor(Color.parseColor(spinnerlabels[i]));
                    //canvasFragment.getView().setBackgroundColor(Color.parseColor(spinnerlabels[i]));

                    //sendColor(spinnerlabels[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

    }

    private void addFragment(Fragment fragment, int containerID){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerID, fragment)
                .commit();
    }

//    public void sendColor(String color){
//        canvasFragment.setColor(color);
//        //canvasFragment.getView().setBackgroundColor(Color.parseColor(spinnerlabels[i]));
//    }
}
