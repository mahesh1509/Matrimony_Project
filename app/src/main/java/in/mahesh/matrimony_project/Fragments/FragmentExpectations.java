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
 * Created by mahesh on 15/11/17.
 */

public class FragmentExpectations extends Fragment {

    private Button mbtnNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_expectations,null);

        mbtnNext= (Button) view.findViewById(R.id.btnnxt3);
        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentFamilyBackground fragmentFamilyBackground=new FragmentFamilyBackground();
                fragmentFamilyBackground.setEnterTransition(new Slide(Gravity.RIGHT));
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container,fragmentFamilyBackground).addToBackStack("").commit();

            }
        });


        return view;
    }
}
