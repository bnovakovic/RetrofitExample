package com.example.bojannovakovic.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button mBtnGetUsername;
    private Button mBtnGetBuddy;
    private TextView mUserInfo;
    private TextView mBuddyInfo;
    private ApiInterface mApiInterface;
    private UserData mCurrentUser;
    private BuddyData mBuddy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objectInit();
        mBtnGetUsername.setOnClickListener(this);
        mBtnGetBuddy.setOnClickListener(this);
    }

    private void objectInit() {
        mBtnGetUsername = (Button) findViewById(R.id.usernameGet);
        mBtnGetBuddy = (Button) findViewById(R.id.buddyGet);
        mUserInfo = (TextView) findViewById(R.id.txYourName);
        mBuddyInfo = (TextView) findViewById(R.id.txBuddyName);
        mApiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.usernameGet:
                getUsername();
                break;
            case R.id.buddyGet:
                getBuddy();
                break;
        }
    }

    private void getBuddy() {
        Log.e(TAG, "getBuddy: ");
        Call<BuddyData> call = mApiInterface.getBuddy();
        call.enqueue(new Callback<BuddyData>() {
            @Override
            public void onResponse(Call<BuddyData> call, Response<BuddyData> response) {
                if (response.isSuccessful()) {
                    mBuddy = response.body();
                    if (mBuddy != null && mBuddy.getUsername() != null) {
                        mBuddyInfo.setText("Buddy username: " + mBuddy.getUsername());
                        Log.e(TAG, "onResponse: " + mBuddy.getUsername());
                    }
                }
            }

            @Override
            public void onFailure(Call<BuddyData> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                mBuddyInfo.setText("Failed to get buddy data");
            }
        });
    }

    private void getUsername() {
        Log.e(TAG, "getUsername: ");
        Call<UserData> call = mApiInterface.getUser();

        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()) {
                    mCurrentUser = response.body();
                    if (mCurrentUser != null && mCurrentUser.getUsername() != null) {
                        mUserInfo.setText("Your username: " + mCurrentUser.getUsername());
                        Log.e(TAG, "onResponse: " + mCurrentUser.getUsername());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                mUserInfo.setText("Failed to get user data");
            }
        });
    }
}
