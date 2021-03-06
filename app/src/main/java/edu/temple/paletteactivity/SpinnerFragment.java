package edu.temple.paletteactivity;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpinnerFragment extends Fragment {
    Spinner customspinner;
    Context parent;

    public SpinnerFragment() {
        // Required empty public constructor
    }

    @Override //must use onAttach when communicating fragment to activity. needs because
    public void onAttach(Context context) {
        super.onAttach(context);
        this.parent = context; //only works within this function
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_spinner, container, false);

        customspinner = v.findViewById(R.id.spinner);
        Resources res = this.getResources();
        final String[] spinnerlabels = res.getStringArray(R.array.colorTitles);
        customspinner.setAdapter(new CustomAdapter(parent, spinnerlabels)); //when you use views inside fragment.  fragment cant be context needs parrent, needs on attach for parent context
        customspinner.setSelection(0,false);

        customspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedColor = spinnerlabels[i];

                ((GetColorInterface) parent).colorSelected(selectedColor); //calls main activity to start canvas fragment with selectedcolor value
                //callback of button... fragment as a button, click the fragment and calls the main activity to do something.
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        return v;
    }

    interface GetColorInterface{ //called from itemselected of spinner fragment.  will call colorSelected method in main activity.
        void colorSelected(String color);
    }

}
