package com.cczhr.voicetts;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cczhr.TTS;


public class MainActivity extends AppCompatActivity {
    private TTS tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tts = TTS.getInstance();
        tts.init(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tts.release();
    }

    public void speek(View view) {
        //onJniProgressCB: pos=0 len=16
        //onJniProgressCB: pos=16 len=0
        //onJniProgressCB: pos=16 len=32
        //onJniProgressCB: pos=48 len=0
        //onJniProgressCB: pos=48 len=0
//        tts.speakText("这是一条测试语音12345678999hello");//8*2+22+5*2 数字与英文不分开，英文与汉字也是分开的
        tts.speakText("12345678999");
        //数字乘以2的
//        tts.speakText("这是一条测试语音今天他告诉我她很好哈哈哈哈哈哈我的天气我做主哗然吓死了"); //35*2=70
//        tts.speakText("这是一条测试语音今天他告诉我她很好哈哈哈哈哈哈我的天气我做主哗然吓死了123"); //38*2=76,70+6汉字与数字分开
        //onJniProgressCB: pos=0 len=70
        //onJniProgressCB: pos=70 len=0
        //onJniProgressCB: pos=70 len=10
        //onJniProgressCB: pos=80 len=0
        //onJniProgressCB: pos=80 len=0
//        tts.speakText("这是一条测试语音今天他告诉我她很好哈哈哈哈哈哈我的天气我做主哗然吓死了hello"); //40*2=80,70+10汉字与英文分开
    }

    public void stopAndSpeakText(View view) {
        tts.stopAndSpeakText("哈哈哈哈哈");
    }

    public void stop(View view) {
        tts.stop();
    }
}