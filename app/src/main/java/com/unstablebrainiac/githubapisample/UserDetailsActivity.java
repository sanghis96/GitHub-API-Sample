package com.unstablebrainiac.githubapisample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        final String avatarUrl = intent.getStringExtra("AVATAR_URL");

        RetrofitInterface retrofitInterface = ServiceGenerator.createService(RetrofitInterface.class);
        retrofitInterface.getUserDetails(username).enqueue(new Callback<GsonModels.UserResponse>() {
            @Override
            public void onResponse(Call<GsonModels.UserResponse> call, Response<GsonModels.UserResponse> response) {
                if (response.isSuccessful()) {
                    GsonModels.UserResponse userResponse = response.body();

                    ImageView profilePictureImageView = (ImageView) findViewById(R.id.profile_picture);
                    TextView nameTextView = (TextView) findViewById(R.id.name_tv);
                    TextView locationTextView = (TextView) findViewById(R.id.location_tv);
                    TextView bioTextView = (TextView) findViewById(R.id.bio_tv);

                    nameTextView.setText(userResponse.getName());
                    locationTextView.setText(userResponse.getLocation());
                    bioTextView.setText(userResponse.getBio());
                    Picasso.with(UserDetailsActivity.this)
                            .load(avatarUrl)
                            .into(profilePictureImageView);
                }
            }

            @Override
            public void onFailure(Call<GsonModels.UserResponse> call, Throwable t) {

            }
        });
    }
}
