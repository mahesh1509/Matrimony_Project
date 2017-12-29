package in.mahesh.matrimony_project.Fragments;

import android.app.TimePickerDialog;
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
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import in.mahesh.matrimony_project.R;

/**
 * Created by mahesh on 15/11/17.
 */
public class FragmentPersonalDetails extends Fragment implements View.OnClickListener{

    private Button mbtnNext;
    private EditText medtBirthTime;
    private int mHour,mMinute;
    String status;
   // int hour_of_12_hour_format;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_personaldetails,null);

        mbtnNext= (Button) view.findViewById(R.id.btnnxt1);
        medtBirthTime= (EditText) view.findViewById(R.id.edtBirthTime);

        medtBirthTime.setOnClickListener(FragmentPersonalDetails.this);
        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentQualifications fragmentQualifications=new FragmentQualifications();
                fragmentQualifications.setEnterTransition(new Slide(Gravity.RIGHT));
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,fragmentQualifications).addToBackStack("").commit();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

        final Calendar calendar=Calendar.getInstance();
        mHour=calendar.get(Calendar.HOUR_OF_DAY);
        mMinute=calendar.get(Calendar.MINUTE);






        TimePickerDialog timePickerDialog=new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


                if (hourOfDay==0){

                    hourOfDay+=12;
                    status="AM";

                }else if (hourOfDay==12){

                    status="PM";
                }else if (hourOfDay>12){

                    hourOfDay -=12;
                    status="PM";

                }else {

                    status="AM";
                }

                /*String status="AM";
                if(hourOfDay>11){

                    status="PM";

                }



                if (hourOfDay>11){

                    hour_of_12_hour_format=hourOfDay - 12;

                }else {

                    hour_of_12_hour_format=hourOfDay;

                }*/

                medtBirthTime.setText(hourOfDay + ":" + minute + ":" + status);
            }
        },mHour,mMinute,false);
        timePickerDialog.show();

    }
}
