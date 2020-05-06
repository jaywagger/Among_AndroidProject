package com.example.among.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.among.R;
import com.example.among.chatting.model.UserChat;

import java.util.ArrayList;

public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.FriendViewHolder> {
    public static final int UNSELECTION_MODE =1;
    public static final int SELECTION_MODE =2;
    private int selectionMode = UNSELECTION_MODE;
    private ArrayList<UserChat> friendList;
    public FriendsListAdapter(){
        friendList = new ArrayList<>();
    }
    public void addItem(UserChat friend){
        friendList.add(friend);
        notifyDataSetChanged(); // View 갱신
    }
    public void setSelectionMode(int selectionMode){
        this.selectionMode = selectionMode; //상태값 기억할 수 있도록 구현
        notifyDataSetChanged();
    }
   public int getSelectionMode(){
        return  this.selectionMode;

    }
    public int getSelectUserCount(){
        int selectionCount=0;
        for (UserChat userChat :friendList){
            if (userChat.isSelection()){
                selectionCount++;
            }
        }
        return selectionCount;
    }
    public String[] getSelectedUids(){
        String[] selectedUids = new String[getSelectUserCount()];
        int i =0;
        for (UserChat userChat :friendList){
            if (userChat.isSelection()){
                selectedUids[i++] = userChat.getUid();
            }
        }
        return selectedUids;
    }
    public UserChat getItem(int position){
        return this.friendList.get(position);
    }
    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fragment_friend_item,parent,false);
        FriendViewHolder friendViewHolder = new FriendViewHolder(view);
        return friendViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        //GetView...
        final UserChat friend = getItem(position);
        holder.emailView.setText(friend.getEmail());
        holder.nameView.setText(friend.getName());
       if(getSelectionMode()==UNSELECTION_MODE){
            holder.FriendSelectionView.setVisibility(View.GONE);
        }else{
            holder.FriendSelectionView.setVisibility(View.VISIBLE);
        }
        if (friend.getProfileUrl()!=null){
            Glide.with(holder.itemView)
                    .load(friend.getProfileUrl())
                    .into(holder.ProfileView);
        }



    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder{//리사이클러뷰 구현
        RoundedImageView ProfileView;
        CheckBox FriendSelectionView;
        TextView nameView;
        TextView emailView;
        private FriendViewHolder(View v){ // Item의 정보를 가지고 있는 View Holder
        super(v);
        ProfileView = v.findViewById(R.id.thumb);
        nameView = v.findViewById(R.id.name);
        emailView = v.findViewById(R.id.email);
        FriendSelectionView = v.findViewById(R.id.checkbox);

    }
    }
}
