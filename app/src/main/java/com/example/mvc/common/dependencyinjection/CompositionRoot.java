/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.common.dependencyinjection;

import com.google.firebase.firestore.FirebaseFirestore;

public class CompositionRoot {
    public FirebaseFirestore getFirestoreInstance(){
        return FirebaseFirestore.getInstance();
    }
}
