/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/19/20 12:17 PM
 */

package com.example.hautomation.common.dependencyinjection;

import com.google.firebase.firestore.FirebaseFirestore;

public class CompositionRoot {
    public FirebaseFirestore getFirestoreInstance(){
        return FirebaseFirestore.getInstance();
    }
}
