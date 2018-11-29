package edu.temple.paletteactivity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.parseColor;

public class CustomAdapter extends BaseAdapter {

    Context context; // which means the listview, spinner view which we are working and adapting on. so the custom adapter knows what we are working on
    int count;
    String[] colors;

    //Resources res = this.context.getResources();
    //String[] spinnerlabels = res.getStringArray(R.array.colors);

    //String[] Colorstrings = {"red", "blue", "magenta", "green", "yellow"};

    //create constructor;




    public CustomAdapter(Context context, String[] string) {
        this.context = context;
        this.colors = string;
    }


    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return colors[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView textColor = new TextView(context);

        textColor.setText(colors[i]);

        if (colors[i].contains("blue"))
        {textColor.setBackgroundColor(Color.BLUE);}
        else if (colors[i].contains("magenta"))
        {textColor.setBackgroundColor(Color.MAGENTA);}
        else if (colors[i].contains("red"))
        {textColor.setBackgroundColor(Color.RED);}
        else if (colors[i].contains("green"))
        {textColor.setBackgroundColor(Color.GREEN);}

        else if (colors[i].contains("yellow"))
        {textColor.setBackgroundColor(Color.YELLOW);}



        return textColor;
    }
}
