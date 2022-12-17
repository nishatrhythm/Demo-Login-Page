package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText phoneNumber, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.phoneNumberID);
        password = findViewById(R.id.passwordID);

        loginButton = findViewById(R.id.materialLoginButton);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String phoneNumberContainer = phoneNumber.getText().toString();
        String passwordContainer = password.getText().toString();

//        warning for empty phoneNumber field
        if (phoneNumberContainer.isEmpty()) {
            phoneNumber.setError("Phone Number is required!");
            phoneNumber.requestFocus();
            return;
        }

//        warning for empty password field
        if (passwordContainer.isEmpty()) {
            password.setError("PIN is required!");
            password.requestFocus();
            return;
        }

        int phoneNumberToInt = Integer.parseInt(phoneNumberContainer);
        int passwordToInt = Integer.parseInt(passwordContainer);

        if(v.getId() == R.id.materialLoginButton) {

            Toast toast;

            if(phoneNumberToInt == 1538868973 && passwordToInt == 1234) {
                toast = Toast.makeText(MainActivity.this, R.string.loginSuccessfulToast, Toast.LENGTH_SHORT);
            }
            else {
                toast = Toast.makeText(MainActivity.this, R.string.loginUnsuccessfulToast, Toast.LENGTH_SHORT);
            }
            toast.setGravity(Gravity.BOTTOM, 0,0);
            toast.show();
        }

//        to hide keyboard after button click
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


//    hide keyboard while clicking outside of editText box
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (getCurrentFocus() != null) {
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//        }
//        return super.dispatchTouchEvent(ev);
//    }
}