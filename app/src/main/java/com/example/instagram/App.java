package com.example.instagram;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("D6l5nv1HKwyRPxPiFWnrinsGo6SK7pF9H86rWz90")
                .clientKey("e4I4mRZKwBIvbOw1eQ6QT4obaIUpDVN981fcwEOj")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    }
}
