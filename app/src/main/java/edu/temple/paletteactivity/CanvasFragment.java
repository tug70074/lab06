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

//    private static final String argcolor = "argtext";
//
//

//    public static CanvasFragment newInstance(String color){
//        CanvasFragment fragment = new CanvasFragment();
//        Bundle selectedcolor = new Bundle();
//        selectedcolor.putString(argcolor, color);
//        fragment.setArguments(selectedcolor);
//        return fragment;
//
//    }

    Layout layout;

    public CanvasFragment() {
        //default empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_canvas, container, false);

        String text = getArguments().getString("color");
        layout.setBackgroundColor(Color.parseColor(text));




        return layout;
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

//    public void setColor(String color) {
//        layout = (TextView) layout.findViewById(R.id.container);
//        layout.setBackgroundColor(Color.parseColor(color));
//
//    }
}
