package com.example.detectlanguagedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private final static String TAG = MainActivity.class.getSimpleName();

    private Button mChangeLanguageInSettingsButton = null;
    private TextView mNationWordTextView = null;
    private ImageView mNationPicImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChangeLanguageInSettingsButton = findViewById(R.id.mChangeLanguageInSettingsButton);
        mChangeLanguageInSettingsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            }
        });
        mNationWordTextView = findViewById(R.id.mNationWordTextView);
        mNationPicImageView = findViewById(R.id.mNationPicImageView);

        // get current language
        String currentLanguage = getResources().getConfiguration().locale.getLanguage();

        // get current country
        String currentCountry = getResources().getConfiguration().locale.getCountry();

        if (currentLanguage.equals("zh"))
        {
            mNationPicImageView.setImageDrawable(getResources().getDrawable(R.drawable.flag_of_the_republic_of_china));
        }
        else if (currentLanguage.equals("en"))
        {
            mNationPicImageView.setImageDrawable(getResources().getDrawable(R.drawable.flag_of_the_united_states));
        }

        mNationWordTextView.setText(getResources().getString(R.string.nation_word));

        Toast.makeText(this, currentLanguage, Toast.LENGTH_SHORT).show();
        Log.e(TAG, "currentLanguage: " + currentLanguage);
        Log.e(TAG, "currentCountry: " + currentCountry);
    }
}
