package com.example.olal.mycart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  private Firebase mRef;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRef = new Firebase ("https://mycart-ee4ba.firebaseio.com/");
  }
}
