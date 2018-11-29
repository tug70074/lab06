package edu.temple.paletteactivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CanvasFragment extends Fragment {

    String colorSelected;

    FrameLayout canvaslayout;

    public CanvasFragment() {
        //default empty constructor
    }



//    @Override //why is this necessary, purpose?
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        colorSelected = getArguments().getString("color");
//
//
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_canvas, container, false);

        canvaslayout = layout.findViewById(R.id.fragment_layout);

   //     String text = colorSelected;
 //       layout.setBackgroundColor(Color.parseColor(text)); //what happens when layout is set to background color "" when it is first called

       //change(); //how to use change to change fragments based on item selected


        return layout;
    }



    public void change() {
        colorSelected = getArguments().getString("color");

//        String[] colorStringArray = getResources().getStringArray(R.array.colorTitles);
//        String[] colorValues = getResources().getStringArray(R.array.colors);
//
//        int indexvalue = colorStringArray.indexOf(colorSelected);

        if (colorSelected.contains("blue"))
        {canvaslayout.setBackgroundColor(Color.BLUE);}
        else if (colorSelected.contains("magenta"))
        {canvaslayout.setBackgroundColor(Color.MAGENTA);}
        else if (colorSelected.contains("red"))
        {canvaslayout.setBackgroundColor(Color.RED);}
        else if (colorSelected.contains("green"))
        {canvaslayout.setBackgroundColor(Color.GREEN);}

        else if (colorSelected.contains("yellow"))
        {canvaslayout.setBackgroundColor(Color.YELLOW);}





    }

}
