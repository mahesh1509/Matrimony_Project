package in.mahesh.matrimony_project.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import in.mahesh.matrimony_project.R;

/**
 * Created by mahesh on 16/11/17.
 */

public class FragmentFamilyBackground extends Fragment {


    private Button mbtnNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_familybackground,null);
        mbtnNext= (Button) view.findViewById(R.id.btnnxt4);
        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSiblings fragmentSiblings=new FragmentSiblings();
                fragmentSiblings.setEnterTransition(new Slide(Gravity.RIGHT));
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container,fragmentSiblings).addToBackStack("").commit();
            }
        });
        return view;
    }
}
