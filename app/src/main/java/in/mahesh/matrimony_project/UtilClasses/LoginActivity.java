package in.mahesh.matrimony_project.UtilClasses;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import in.mahesh.matrimony_project.R;

/**
 * Created by mahesh on 11/11/17.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG="LoginActivity";
    private static final int REQUEST_SIGNUP=0;
    private ImageView mImageBackground;
  //  private TextView mTxtLinkSignup;
    private EditText mEdtUserName,mEdtPassword;
    private AppCompatButton mBtnLogin;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mImageBackground= (ImageView) findViewById(R.id.bg_image);
       // mTxtLinkSignup= (TextView) findViewById(R.id.txt_link_signup);
        mEdtUserName= (EditText) findViewById(R.id.edt_Username);
        mEdtPassword= (EditText) findViewById(R.id.edt_Password);
        mBtnLogin= (AppCompatButton) findViewById(R.id.btn_login);


        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                login();
            }
        });

       /* mTxtLinkSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/


    }

   /* private void initViews() {



    }*/


    private void login(){

        Log.d("TAG","LOGIN");

        if (!validate()){

            onLoginFailed();
            return;


        }
        mBtnLogin.setEnabled(true);


        final ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this,R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onLoginSuccess();
                progressDialog.dismiss();

            }
        },3000);



    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }


    private void onLoginSuccess() {

        mBtnLogin.setEnabled(true);
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);


    }

    private void onLoginFailed() {


        Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
        mBtnLogin.setEnabled(true);

    }

    private boolean validate(){

        boolean valid=true;

        String username=mEdtUserName.getText().toString();
        String passsword=mEdtPassword.getText().toString();

        if (username.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(username).matches()){

            mEdtUserName.setError("Enter a valid Username");
        }else {

            mEdtUserName.setError(null);
        }


        if (passsword.isEmpty() || passsword.length()<8 || passsword.length()>10){

            mEdtPassword.setError("Password length should be between 8 to 10 ");
            valid=false;
        }else {

            mEdtPassword.setError(null);
        }
        return valid;
    }












































   @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount()>2){
            getSupportFragmentManager().popBackStack();


        }else{

            moveTaskToBack(true);
        }

      //LoginActivity.this.finish();
       // moveTaskToBack(true);//disable going back to splash Activity

    }
}
