package com.example.eyedenti;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vrscreen;
    ImageButton closeBtn;
    ImageButton openBtn;
    ImageButton aneBtn;
    ImageButton handBtn;
    ImageButton sucBtn;
    ImageView imageView;
    boolean i = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /* ActionBar 없애는 코드 */
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        closeBtn = (ImageButton) findViewById(R.id.close);
        openBtn = (ImageButton)findViewById(R.id.open);
        aneBtn = (ImageButton)findViewById(R.id.anesthesia);
        handBtn = (ImageButton)findViewById(R.id.handpiece);
        sucBtn = (ImageButton)findViewById(R.id.suction);
        vrscreen = (VideoView) findViewById(R.id.vrscreen);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.close);

                /* VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기 */
                vrscreen.setVideoURI(videoUri);

                /*비디오 로딩 준비가 끝났을 때 실행하도록 리스너 설정 */
                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        //비디오 시작
                        vrscreen.start();
                    }
                });
                closeBtn.setImageResource(R.drawable.close_c);
            }

        });

        sucBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.suction);

                vrscreen.setVideoURI(videoUri);

                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        vrscreen.start();
                    }
                });
                sucBtn.setImageResource(R.drawable.suction_c);
                new Handler().postDelayed(new Runnable()
                {
                    @Override

                    public void run()
                    {
                        sucBtn.setImageResource(R.drawable.suction);
                    }
                }, 1500);  // 딜레이 시간 설정 (1초 = 1000)

            }
        });

        aneBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.anesthesia);

                vrscreen.setVideoURI(videoUri);

                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                        vrscreen.start();
                    }
                });
            }
        });

        handBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.handpiece);

                vrscreen.setVideoURI(videoUri);

                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        vrscreen.start();
                    }
                });
            }
        });

        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.open);

                vrscreen.setVideoURI(videoUri);

                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        vrscreen.start();
                    }
                });
            }
        });

    }
    //화면에 안보일때
    @Override
    protected void onPause() {
        super.onPause();

        //비디오 일시 정지
        if(vrscreen!=null && vrscreen.isPlaying()) vrscreen.pause();
    }
    //액티비티가 메모리에서 사라질때
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //
        if(vrscreen!=null) vrscreen.stopPlayback();

    }
}
