package com.example.bojannovakovic.retrofitexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bojan.novakovic on 7/24/2017.
 */

public class UserData {
    @SerializedName("my_jid")
    private String jid;

    @SerializedName("my_username")
    private String username;


    public String getJid() {
        return jid;
    }

    public String getUsername() {
        return username;
    }
}
