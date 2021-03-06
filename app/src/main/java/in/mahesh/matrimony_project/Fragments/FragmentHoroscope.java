package in.mahesh.matrimony_project.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import in.mahesh.matrimony_project.R;
import in.mahesh.matrimony_project.UtilClasses.LoginActivity;

/**
 * Created by mahesh on 16/11/17.
 */

public class FragmentHoroscope extends Fragment {

    private Button mbtnDone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_horoscope,null);

        mbtnDone= (Button) view.findViewById(R.id.btnDone);
        mbtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
