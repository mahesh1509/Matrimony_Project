package in.mahesh.matrimony_project.UtilClasses;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import in.mahesh.matrimony_project.Fragments.FragmentRegistration;
import in.mahesh.matrimony_project.R;

/**
 * Created by mahesh on 15/11/17.
 */

public class WelcomeActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mbtnLogin,mbtnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mImageView= (ImageView) findViewById(R.id.imgViewWelcome);
        mbtnLogin= (Button) findViewById(R.id.btnLogin);
        mbtnRegister= (Button) findViewById(R.id.btnRegister);

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        mbtnRegister.setOnClickListener(new View.OnClickListener() {


            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                FragmentRegistration fragmentRegistration=new FragmentRegistration();
                fragmentRegistration.setEnterTransition(new Slide(Gravity.RIGHT));
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container,fragmentRegistration).addToBackStack("").commit();

            }
        });

    }
}
