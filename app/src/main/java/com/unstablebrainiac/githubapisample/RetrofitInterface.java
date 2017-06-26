package com.unstablebrainiac.githubapisample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by unstablebrainiac on 23/6/17.
 */

public interface RetrofitInterface {
    @GET("/search/users")
    Call<GsonModels.SearchUserResponse> searchUsers(@Query("q") String query);

    @GET("/users/{username}")
    Call<GsonModels.UserResponse> getUserDetails(@Path("username") String username);
}
