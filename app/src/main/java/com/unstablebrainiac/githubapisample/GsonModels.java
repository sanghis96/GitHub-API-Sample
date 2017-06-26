package com.unstablebrainiac.githubapisample;

import java.util.ArrayList;

/**
 * Created by unstablebrainiac on 23/6/17.
 */

public class GsonModels {
    public class Item {
        String login;
        String avatar_url;

        public Item(String login, String avatar_url) {
            this.login = login;
            this.avatar_url = avatar_url;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getAvatarUrl() {
            return avatar_url;
        }

        public void setAvatarUrl(String avatar_url) {
            this.avatar_url = avatar_url;
        }
    }

    public class SearchUserResponse {
        int total_count;
        boolean incomplete_results;
        ArrayList<Item> items;

        public SearchUserResponse(int total_count, boolean incomplete_results, ArrayList<Item> items) {
            this.total_count = total_count;
            this.incomplete_results = incomplete_results;
            this.items = items;
        }

        public int getTotalCount() {
            return total_count;
        }

        public void setTotalCount(int total_count) {
            this.total_count = total_count;
        }

        public boolean isIncompleteResults() {
            return incomplete_results;
        }

        public void setIncompleteResults(boolean incomplete_results) {
            this.incomplete_results = incomplete_results;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void setItems(ArrayList<Item> items) {
            this.items = items;
        }
    }

    public class UserResponse {
        String name;
        String location;
        String bio;

        public UserResponse(String name, String location, String bio) {
            this.name = name;
            this.location = location;
            this.bio = bio;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }
    }
}
