package com.example.asus_wh.docs_app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ForgotPswActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_psw);
        /*getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);*/
    }
  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            default:
                Log.d("da","da");
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

}
