package in.mahesh.matrimony_project.Fragments;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

import in.mahesh.matrimony_project.R;

/**
 * Created by mahesh on 14/11/17.
 */

public class FragmentRegistration extends Fragment implements View.OnClickListener{

    private TextView mTxtRegistrationPage,mTxtInformation,mtxtGender,mTxtDOB;
    private EditText mEdtEmail,mEdtPhoneNo,mEdtDOB;
    private RadioButton mBtnMale,mBtnFemale;

    private Button mBtnNext;
    private int mYear,mMonth,mDay;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_registration,null,false);

        mBtnNext= (Button) view.findViewById(R.id.btnnxt);
        mEdtDOB= (EditText) view.findViewById(R.id.edtDOB);
        mEdtDOB.setOnClickListener(this);



        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                FragmentPersonalDetails fragmentPersonalDetails=new FragmentPersonalDetails();
                fragmentPersonalDetails.setEnterTransition(new Slide(Gravity.RIGHT));
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,fragmentPersonalDetails).addToBackStack("").commit();


            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                mEdtDOB.setText(dayOfMonth+"-"+(month + 1)+"-"+year);



            }
        },mYear,mMonth,mDay);
        datePickerDialog.show();
    }
}
