package com.example.gaurav.hypemessanger.FireBase;


import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by gaurav on 7/30/2017.
 */

public class FireBaseInstanceIdService extends FirebaseInstanceIdService {
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference myRef;
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
//        String token = FirebaseInstanceId.getInstance().getToken();
//        firebaseDatabase = FirebaseDatabase.getInstance();

    }

}
