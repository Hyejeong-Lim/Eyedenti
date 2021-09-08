package com.example.eyedenti;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vv;
    ImageButton closeBtn;
    ImageButton openBtn;
    ImageButton aneBtn;
    ImageButton handBtn;
    ImageButton sucBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        closeBtn = (ImageButton) findViewById(R.id.close);
        openBtn = (ImageButton)findViewById(R.id.open);
        aneBtn = (ImageButton)findViewById(R.id.anesthesia);
        handBtn = (ImageButton)findViewById(R.id.handpiece);
        sucBtn = (ImageButton)findViewById(R.id.suction);

        vv= findViewById(R.id.vrscreen);
        //Video Uri
        Uri videoUri= Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");

        closeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.close);
                //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
//        vv.setMediaController(new MediaController(this));

                //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
                vv.setVideoURI(videoUri);

                //동영상을 읽어오는데 시간이 걸리므로..
                //비디오 로딩 준비가 끝났을 때 실행하도록..
                //리스너 설정
                vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        //비디오 시작
                        vv.start();
                    }
                });
            }
        });

        sucBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.suction);
                //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
//        vv.setMediaController(new MediaController(this));

                //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
                vv.setVideoURI(videoUri);

                //동영상을 읽어오는데 시간이 걸리므로..
                //비디오 로딩 준비가 끝났을 때 실행하도록..
                //리스너 설정
                vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        //비디오 시작
                        vv.start();
                    }
                });
            }
        });

        aneBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.anesthesia);
                //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
//        vv.setMediaController(new MediaController(this));

                //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
                vv.setVideoURI(videoUri);

                //동영상을 읽어오는데 시간이 걸리므로..
                //비디오 로딩 준비가 끝났을 때 실행하도록..
                //리스너 설정
                vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        //비디오 시작
                        vv.start();
                    }
                });
            }
        });


        handBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.handpiece);
                //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
//        vv.setMediaController(new MediaController(this));

                //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
                vv.setVideoURI(videoUri);

                //동영상을 읽어오는데 시간이 걸리므로..
                //비디오 로딩 준비가 끝났을 때 실행하도록..
                //리스너 설정
                vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        //비디오 시작
                        vv.start();
                    }
                });
            }
        });

        openBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.open);
                //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
//        vv.setMediaController(new MediaController(this));

                //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
                vv.setVideoURI(videoUri);

                //동영상을 읽어오는데 시간이 걸리므로..
                //비디오 로딩 준비가 끝났을 때 실행하도록..
                //리스너 설정
                vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        //비디오 시작
                        vv.start();
                    }
                });
            }
        });

//        //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
////        vv.setMediaController(new MediaController(this));
//
//        //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
//        vv.setVideoURI(videoUri);
//
//        //동영상을 읽어오는데 시간이 걸리므로..
//        //비디오 로딩 준비가 끝났을 때 실행하도록..
//        //리스너 설정
//        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                //비디오 시작
//                vv.start();
//            }
//        });

    }//onCreate ..

    //화면에 안보일때...
    @Override
    protected void onPause() {
        super.onPause();

        //비디오 일시 정지
        if(vv!=null && vv.isPlaying()) vv.pause();
    }
    //액티비티가 메모리에서 사라질때..
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //
        if(vv!=null) vv.stopPlayback();

    }
}
