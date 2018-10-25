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
import android.widget.TextView;

import org.w3c.dom.Text;

public class CanvasFragment extends Fragment {

    String colorSelected;

    //Layout layout;

    public CanvasFragment() {
        //default empty constructor
    }

    public static CanvasFragment newInstance (String colorSelected) {
        CanvasFragment canvasFragment = new CanvasFragment();

        Bundle bundle = new Bundle();
        bundle.putString("color", colorSelected);

        canvasFragment.setArguments(bundle);

        return canvasFragment;
    }

    @Override //why is this necessary, purpose?
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            colorSelected = getArguments().getString("color");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_canvas, container, false);

        String text = colorSelected;
        layout.setBackgroundColor(Color.parseColor(text)); //what happens when layout is set to background color "" when it is first called

        //change(colorSelected); //how to use change to change fragments based on item selected


        return layout;
    }

//    public void changeColor(String planetName) {
//        change(planetName);
//    }
//
//    private void change (String colorSelected) {
//        switch (colorSelected) {
//
//        }
//    }

}
