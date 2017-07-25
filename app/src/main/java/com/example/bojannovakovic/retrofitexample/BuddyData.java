package com.example.bojannovakovic.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class BuddyData {

    @SerializedName("buddy_jid")
    private String jid;

    @SerializedName("buddy_username")
    private String username;


    public String getJid() {
        return jid;
    }

    public String getUsername() {
        return username;
    }
}
