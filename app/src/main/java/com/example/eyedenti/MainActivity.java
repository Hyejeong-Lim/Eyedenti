package com.example.eyedenti;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    VideoView vrscreen;
    ImageButton closeBtn;
    ImageButton openBtn;
    ImageButton aneBtn;
    ImageButton handBtn;
    ImageButton sucBtn;
    ImageView imageView;
    ImageButton voiceBtn;
    EditText edit;
    Button sttBtn;
    String str;
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
        voiceBtn = (ImageButton)findViewById(R.id.voice);



        voiceBtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                VoiceTask voiceTask = new VoiceTask();
                voiceTask.execute();


//                final LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.dialog_activity, null);
//
//                new AlertDialog.Builder(MainActivity.this)
//                        .setView(linear)
//                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                TextView url = (TextView) linear.findViewById(R.id.txtInMsg);
//                                url.setText(str);
//                                String value = url.getText().toString();
////                                webView.loadUrl(value);
//                                dialog.dismiss();
//                            }
//                        })
//                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                dialog.dismiss();
//                            }
//                        })
//                        .show();


            }

        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("video").setValue("close");
               Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.close);

                /* VzideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기 */
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
                sucBtn.setImageResource(R.drawable.suction);
                handBtn.setImageResource(R.drawable.handpiece);
                openBtn.setImageResource(R.drawable.open);
                aneBtn.setImageResource(R.drawable.anesthesia);
            }

        });

        sucBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("video").setValue("suction");
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.suction);

                vrscreen.setVideoURI(videoUri);

                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        vrscreen.start();
                    }
                });
                closeBtn.setImageResource(R.drawable.close);
                sucBtn.setImageResource(R.drawable.suction_c);
                handBtn.setImageResource(R.drawable.handpiece);
                openBtn.setImageResource(R.drawable.open);
                aneBtn.setImageResource(R.drawable.anesthesia);

            }
        });

        aneBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                databaseReference.child("video").setValue("anethesia");
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.anesthesia);

                vrscreen.setVideoURI(videoUri);

                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                        vrscreen.start();
                    }
                });
                closeBtn.setImageResource(R.drawable.close);
                sucBtn.setImageResource(R.drawable.suction);
                handBtn.setImageResource(R.drawable.handpiece);
                openBtn.setImageResource(R.drawable.open);
                aneBtn.setImageResource(R.drawable.anesthesia_c);
            }
        });

        handBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("video").setValue("handpiece");
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.handpiece);

                vrscreen.setVideoURI(videoUri);

                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        vrscreen.start();
                    }
                });
                closeBtn.setImageResource(R.drawable.close);
                sucBtn.setImageResource(R.drawable.suction);
                handBtn.setImageResource(R.drawable.handpiece_c);
                openBtn.setImageResource(R.drawable.open);
                aneBtn.setImageResource(R.drawable.anesthesia);
            }
        });

        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("video").setValue("open");
                Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.open);

                vrscreen.setVideoURI(videoUri);

                vrscreen.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        vrscreen.start();
                    }
                });
                closeBtn.setImageResource(R.drawable.close);
                sucBtn.setImageResource(R.drawable.suction);
                handBtn.setImageResource(R.drawable.handpiece);
                openBtn.setImageResource(R.drawable.open_c);
                aneBtn.setImageResource(R.drawable.anesthesia);
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
    public class VoiceTask extends AsyncTask<String, Integer, String> {
        String str = null;

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            try {
                getVoice();
            } catch (Exception e) {
                // TODO: handle exception
            }
            return str;
        }

        @Override
        protected void onPostExecute(String result) {
            try {

            } catch (Exception e) {
                Log.d("onActivityResult", "getImageURL exception");
            }
        }
    }

    private void getVoice() {

        Intent intent = new Intent();
        intent.setAction(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        String language = "ko-KR";

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);
        startActivityForResult(intent, 2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            ArrayList<String> results = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            str = results.get(0);
            Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();

//            TextView tv = findViewById(R.id.txtInMsg);
//            tv.setText(str);
            databaseReference.child("message").setValue(str);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
