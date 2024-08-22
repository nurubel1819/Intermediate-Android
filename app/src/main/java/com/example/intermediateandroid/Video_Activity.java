package com.example.intermediateandroid;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Video_Activity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        videoView = findViewById(R.id.video);
        String video_path = "android.resource://"+Video_Activity.this.getPackageName()+"/raw/kusu_kusu";
        Uri uri_video_path = Uri.parse(video_path);
        videoView.setVideoURI(uri_video_path);
        videoView.start();

        MediaController mediaController = new MediaController(Video_Activity.this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }
}