package com.example.olal.mycart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private Firebase myRef;

  private StorageReference mStorageRef;

  private FirebaseAuth mAuth;

  private ArrayList<String> mProducts = new ArrayList<>();

  private ListView mListView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    //Previous versions of Firebase
    Firebase.setAndroidContext(this);

    ////Newer version of Firebase
    //if(!FirebaseApp.getApps(this).isEmpty()) {
    //  FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    //}


    myRef = new Firebase("https://mycart-ee4ba.firebaseio.com/0/products");

    mListView = (ListView) findViewById(R.id.news_card_recycler_view);

    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mProducts);

    mListView.setAdapter(arrayAdapter);

    myRef.addChildEventListener(new ChildEventListener() {
      @Override public void onChildAdded(DataSnapshot dataSnapshot, String s) {

        String value = dataSnapshot.getValue(String.class);

        mProducts.add(value);

        arrayAdapter.notifyDataSetChanged();

      }

      @Override public void onChildChanged(DataSnapshot dataSnapshot, String s) {

      }

      @Override public void onChildRemoved(DataSnapshot dataSnapshot) {

      }

      @Override public void onChildMoved(DataSnapshot dataSnapshot, String s) {

      }

      @Override public void onCancelled(FirebaseError firebaseError) {

      }
    });

    //myRef.addValueEventListener(new ValueEventListener() {
    //  @Override public void onDataChange(DataSnapshot dataSnapshot) {
    //
    //        String value = dataSnapshot.getValue(String.class);
    //
    //        mProducts.add(value);
    //
    //        arrayAdapter.notifyDataSetChanged();
    //  }
    //
    //  @Override public void onCancelled(FirebaseError firebaseError) {
    //
    //  }
    //});


  }
}
