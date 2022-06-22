package com.example.speechtotext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageButton imageButton;
    EditText editText;
    Button button;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        imageButton=findViewById(R.id.imageButton5);
        editText=findViewById(R.id.editTextNumber2);
        button=findViewById(R.id.button);

        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i==TextToSpeech.SUCCESS){
                    int lang=textToSpeech.setLanguage(Locale.ENGLISH);
                }

            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  int speech=textToSpeech.speak("2 multiplied by 2",TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=2;
                int b=2;
                int c=a*b;
                int in = Integer.valueOf(editText.getText().toString());

               if(in==c)
               {
                   int speech=textToSpeech.speak("Correct Answer",TextToSpeech.QUEUE_FLUSH,null);
               }
               else
               {
                   int speech=textToSpeech.speak("incorrect Answer",TextToSpeech.QUEUE_FLUSH,null);
               }
            }
        });

    }
}