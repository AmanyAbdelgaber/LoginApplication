package com.example.org.loginapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    Context context;
    ArrayList<User> users;
    User user;
    MediaPlayer mediaPlayer;

    public UserAdapter(Context context, ArrayList<User> users){
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mp.release();
            mediaPlayer = null;
        }
    };

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        user = users.get(position);
        mediaPlayer = new MediaPlayer();

        holder.usenameTxt.setText(user.getEmail());
        holder.note.setText(user.getNote());
        holder.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(holder.itemView.getContext(),  user.getRecordurl());
                if(mediaPlayer != null){
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });
        holder.stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
            }
        });
        holder.pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView usenameTxt, note;
        Button playBtn, stopBtn, pauseBtn;


        public MyViewHolder(View itemView) {
            super(itemView);

            usenameTxt = itemView.findViewById(R.id.usernameTxt);
            note = itemView.findViewById(R.id.note);
            playBtn = itemView.findViewById(R.id.playBtn);
            stopBtn = itemView.findViewById(R.id.stopBtn);
            pauseBtn = itemView.findViewById(R.id.pauseBtn);


        }
    }
}
