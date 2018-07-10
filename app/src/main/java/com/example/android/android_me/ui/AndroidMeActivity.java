package com.example.android.android_me.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // Only create new fragments when there is no previously saved state
        if (savedInstanceState == null) {

            //Create a new head BodyPartFragment instance and display it using the FragmentManager
            BodyPartFragment headFragment = new BodyPartFragment();

            //Fragment transaction
            //Set the list of image id's for the head fragment and set the position to the second image in the list
            headFragment.setImageIds(AndroidImageAssets.getHeads());

            //Get the correct index to access in the array of head images from the intent
            //Set the default value to 0
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setListIndex(headIndex);

            //Use a FragmentManager and transaction to add the fragment to the screen
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            //Create and display the body and leg BodyPartFragments
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setListIndex(bodyIndex);

            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            BodyPartFragment legsFragment = new BodyPartFragment();
            legsFragment.setImageIds(AndroidImageAssets.getLegs());
            int legsIndex = getIntent().getIntExtra("legsIndex", 0);
            bodyFragment.setListIndex(legsIndex);

            fragmentManager.beginTransaction()
                    .add(R.id.legs_container, legsFragment)
                    .commit();
        }
    }
}