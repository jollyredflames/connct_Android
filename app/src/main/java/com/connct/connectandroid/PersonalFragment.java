package com.connct.connectandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PersonalFragment extends Fragment {
    @Nullable

    private DatabaseReference mDatabase;
    private User meUser;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FirebaseUser fireuser = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("users").child(fireuser.getUid()).child("profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                copyUserDetails(user);
                Log.d("Goody", "Nothing to see here");
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("HELP", "Not Firebase");
            }
        });

        return inflater.inflate(R.layout.fragment_personal, container, false);
    }

    public void copyUserDetails(User user){
        meUser = user;
    }

    public User getMeUser(){
        return meUser;
    }

}
