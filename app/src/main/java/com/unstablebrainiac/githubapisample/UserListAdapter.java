package com.unstablebrainiac.githubapisample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by unstablebrainiac on 23/6/17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    List<GsonModels.Item> items;
    Context context;
    ItemClickListener itemClickListener;

    public UserListAdapter(List<GsonModels.Item> items, ItemClickListener itemClickListener) {
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.list_item_user,viewGroup,false);

        final UserViewHolder userViewHolder = new UserViewHolder(userView);
        userView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(v,userViewHolder.getAdapterPosition());
            }
        });
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserListAdapter.UserViewHolder userListHolder, int i) {
        GsonModels.Item currentItem = items.get(i);
        userListHolder.loginTextView.setText(currentItem.getLogin());
        Picasso.with(context)
                .load(currentItem.getAvatarUrl())
                .into(userListHolder.profilePicture);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView loginTextView;
        ImageView profilePicture;
        public UserViewHolder(View itemView) {
            super(itemView);

            loginTextView = (TextView) itemView.findViewById(R.id.login_tv);
            profilePicture = (ImageView) itemView.findViewById(R.id.profile_pic);
        }
    }
}
