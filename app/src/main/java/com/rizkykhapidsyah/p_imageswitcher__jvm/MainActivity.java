package com.rizkykhapidsyah.p_imageswitcher__jvm;

import androidx.appcompat.app.AppCompatActivity;

import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher IS_Demo_IDJAVA;
    Button B_Sebelumnya_IDJAVA, B_Selanjutnya_IDJAVA;
    TextView TV_Judul_IDJAVA;

    int[] ImageSwitchID = {
            R.drawable.gambar1,
            R.drawable.gambar2,
            R.drawable.gambar3,
            R.drawable.gambar4,
            R.drawable.gambar5,
            R.drawable.gambar6,
            R.drawable.gambar7
    };

    int JumlahGambar = ImageSwitchID.length;
    int CurrentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B_Sebelumnya_IDJAVA = findViewById(R.id.B_Sebelumnya_IDXML);
        B_Selanjutnya_IDJAVA = findViewById(R.id.B_Selanjutnya_IDXML);
        TV_Judul_IDJAVA = findViewById(R.id.TV_Judul_IDXML);
        TV_Judul_IDJAVA.setText(R.string.TV_Judul_IDXML);
        IS_Demo_IDJAVA = findViewById(R.id.IS_Demo_IDXML);

        IS_Demo_IDJAVA.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView IV = new ImageView(getApplicationContext());
                IV.setScaleType(ImageView.ScaleType.FIT_CENTER);
                IV.setLayoutParams(new ImageSwitcher.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                return IV;
            }
        });

        B_Selanjutnya_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CurrentIndex < JumlahGambar - 1) {
                    CurrentIndex = CurrentIndex + 1;
                    IS_Demo_IDJAVA.setImageResource(ImageSwitchID[CurrentIndex]);
                } else if (CurrentIndex == 6) {
                    TV_Judul_IDJAVA.setText(R.string.TV_Judul_IDXML2);
                }
            }
        });

        B_Sebelumnya_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CurrentIndex > 0) {
                    CurrentIndex = CurrentIndex - 1;
                    IS_Demo_IDJAVA.setImageResource(ImageSwitchID[CurrentIndex]);
                } else if (CurrentIndex == 0) {
                    TV_Judul_IDJAVA.setText(R.string.TV_Judul_IDXML);
                }
            }
        });
    }
}
