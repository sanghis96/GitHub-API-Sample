package com.unstablebrainiac.githubapisample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchUserActivity extends AppCompatActivity {

    RecyclerView userListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        Intent intent = getIntent();
        String searchQuery = intent.getStringExtra("SEARCH_QUERY");

        userListRecyclerView = (RecyclerView) findViewById(R.id.user_list);

        RetrofitInterface retrofitInterface =
                ServiceGenerator.createService(RetrofitInterface.class);
        retrofitInterface.searchUsers(searchQuery).enqueue(new Callback<GsonModels.SearchUserResponse>() {
            @Override
            public void onResponse(Call<GsonModels.SearchUserResponse> call, Response<GsonModels.SearchUserResponse> response) {
                if (response.isSuccessful()) {
                    final GsonModels.SearchUserResponse searchUserResponse = response.body();
                    UserListAdapter userListAdapter = new UserListAdapter(searchUserResponse.getItems(), new ItemClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            Intent intent1 = new Intent(SearchUserActivity.this, UserDetailsActivity.class);
                            intent1.putExtra("USERNAME", searchUserResponse.getItems().get(position).getLogin());
                            intent1.putExtra("AVATAR_URL", searchUserResponse.getItems().get(position).getAvatarUrl());
                            startActivity(intent1);
                        }
                    });
                    userListRecyclerView.setAdapter(userListAdapter);
                    userListRecyclerView.setLayoutManager(new LinearLayoutManager(SearchUserActivity.this));
                }
            }

            @Override
            public void onFailure(Call<GsonModels.SearchUserResponse> call, Throwable t) {

            }
        });
    }
}
