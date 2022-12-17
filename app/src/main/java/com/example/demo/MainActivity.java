package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        try {

//            phoneNumber field
            String phoneNumberContainer = phoneNumber.getText().toString();

//            toast if phoneNumber missing
            if (phoneNumberContainer.isEmpty()) {
                Toast.makeText(MainActivity.this, R.string.toastPhoneNumberMissing, Toast.LENGTH_SHORT).show();
            }

//        warning for empty phoneNumber field
//            if (phoneNumberContainer.isEmpty()) {
//                phoneNumber.setError("Phone Number is required!");
//                phoneNumber.requestFocus();
//                return;
//            }

            int phoneNumberToInt = Integer.parseInt(phoneNumberContainer);

//            password field
            String passwordContainer = password.getText().toString();

//            toast if password is missing
            if (passwordContainer.isEmpty()) {
                Toast.makeText(MainActivity.this, R.string.toastPasswordMissing, Toast.LENGTH_SHORT).show();
            }

//        warning for empty password field
//            if (passwordContainer.isEmpty()) {
//                password.setError("PIN is required!");
//                password.requestFocus();
//                return;
//            }

            int passwordToInt = Integer.parseInt(passwordContainer);

            if (v.getId() == R.id.materialLoginButton) {

                Toast toast;

                if (phoneNumberToInt == 1538868973 && passwordToInt == 1234) {
                    toast = Toast.makeText(MainActivity.this, R.string.loginSuccessfulToast, Toast.LENGTH_SHORT);
                } else {
                    toast = Toast.makeText(MainActivity.this, R.string.loginUnsuccessfulToast, Toast.LENGTH_SHORT);
                }
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }

//        ***** to hide the keyboard after button click *****
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }


        } catch (Exception e) {
//            Toast.makeText(MainActivity.this, R.string.exceptionHandlingToast, Toast.LENGTH_SHORT);
        }
    }

//    ***** to hide the keyboard and to clear focus of editText on touch outside *****
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = getCurrentFocus();
//            if ( v instanceof EditText) {
//                Rect outRect = new Rect();
//                v.getGlobalVisibleRect(outRect);
//                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
//                    v.clearFocus();
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//                }
//            }
//        }
//        return super.dispatchTouchEvent( event );
//    }


//    ***** to hide the keyboard while clicking outside of editText box but focus remain same *****
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (getCurrentFocus() != null) {
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//        }
//        return super.dispatchTouchEvent(ev);
//    }
}