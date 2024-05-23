package com.example.xfapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.cczhr.TTS;
import com.cczhr.TTSConstants;

/***
 * 1.这个作为示例
 * 2.使用xf_tts的包
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TTS tts = TTS.getInstance();
        tts.init(this, TTSConstants.TTS_JIAJIA);

        findViewById(R.id.btn1).setOnClickListener(v -> {
            tts.speakText("你好，今天天气不错呀", new TTS.IProgressListener() {
                @Override
                public void onStart() {
                    Log.i("zxd", "onStart: ");
                }

                @Override
                public void onError(int errorCode) {
                    Log.i("zxd", "onError: ");
                }

                @Override
                public void onDone() {
                    Log.i("zxd", "onDone: ");
                }
            });
        });
        findViewById(R.id.btn2).setOnClickListener(v -> {
            tts.stopAndSpeakText("是呀，天气真不错。和风细雨");
        });
        findViewById(R.id.btn3).setOnClickListener(v -> {
            tts.stop();
        });
    }
}