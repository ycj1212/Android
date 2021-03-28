package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SingleTouchView singleTouchView;
    ImageView newPage, pen, eraser, save;
    ImageButton backgroundColor, paintColor, minusButton, plusButton;
    ImageButton color1, color2, color3, color4, color5, color6, color7;
    SeekBar penWidth;

    AlertDialog dialog;

    float width;
    int color;
    int mode = 1;   // 0: backgroundColor, 1: paintColor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout paint = findViewById(R.id.paint);
        singleTouchView = new SingleTouchView(this, null);
        paint.addView(singleTouchView);

        newPage = findViewById(R.id.new_page);
        pen = findViewById(R.id.pen);
        eraser = findViewById(R.id.eraser);
        save = findViewById(R.id.save);

        newPage.setOnClickListener(this);
        pen.setOnClickListener(this);
        eraser.setOnClickListener(this);
        save.setOnClickListener(this);

        backgroundColor = findViewById(R.id.background_color);
        paintColor = findViewById(R.id.paint_color);
        minusButton = findViewById(R.id.minus_button);
        plusButton = findViewById(R.id.plus_button);

        backgroundColor.setOnClickListener(this);
        paintColor.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);

        penWidth = findViewById(R.id.seekbar_width);
        penWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                width = seekBar.getProgress();
                singleTouchView.setPathWidth(width);
                Toast.makeText(getApplicationContext(), "굵기: " + width, Toast.LENGTH_SHORT).show();
            }
        });

        LayoutInflater inflater = getLayoutInflater();
        View colorMenu = inflater.inflate(R.layout.dialog_color, null);

        color1 = colorMenu.findViewById(R.id.color1);
        color2 = colorMenu.findViewById(R.id.color2);
        color3 = colorMenu.findViewById(R.id.color3);
        color4 = colorMenu.findViewById(R.id.color4);
        color5 = colorMenu.findViewById(R.id.color5);
        color6 = colorMenu.findViewById(R.id.color6);
        color7 = colorMenu.findViewById(R.id.color7);

        color1.setOnClickListener(this);
        color2.setOnClickListener(this);
        color3.setOnClickListener(this);
        color4.setOnClickListener(this);
        color5.setOnClickListener(this);
        color6.setOnClickListener(this);
        color7.setOnClickListener(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(colorMenu);

        dialog = builder.create();
        WindowManager.LayoutParams dialogParams = dialog.getWindow().getAttributes();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        LinearLayout bottomMenu = findViewById(R.id.bottom_menu);

        dialogParams.y = size.y - bottomMenu.getHeight();
        dialog.getWindow().setAttributes(dialogParams);
        dialog.setOnDismissListener(dialog -> {
            if (mode == 0) {
                backgroundColor.setBackgroundColor(color);
                singleTouchView.setBackColor(color);
            } else {
                paintColor.setBackgroundColor(color);
                singleTouchView.setPaintColor(color);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_page:
                Toast.makeText(this, "new_page", Toast.LENGTH_SHORT).show();
                singleTouchView.erase();
                break;
            case R.id.pen:
                Toast.makeText(this, "pen", Toast.LENGTH_SHORT).show();
                singleTouchView.setPenMode();
                break;
            case R.id.eraser:
                Toast.makeText(this, "eraser", Toast.LENGTH_SHORT).show();
                singleTouchView.setEraserMode();
                break;
            case R.id.save:
                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
                break;
            case R.id.minus_button:
                penWidth.setProgress(penWidth.getProgress() - 1);
                Toast.makeText(this, "" + penWidth.getProgress(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.plus_button:
                penWidth.setProgress(penWidth.getProgress() + 1);
                Toast.makeText(this, "" + penWidth.getProgress(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.background_color:
                Toast.makeText(this, "background color", Toast.LENGTH_SHORT).show();
                dialog.show();
                mode = 0;
                break;
            case R.id.paint_color:
                Toast.makeText(this, "paint color", Toast.LENGTH_SHORT).show();
                dialog.show();
                mode = 1;
                break;
            case R.id.color1:
                color = 0xFFFFFFFF;
                dialog.dismiss();
                break;
            case R.id.color2:
                color = 0xFFFF0000;
                dialog.dismiss();
                break;
            case R.id.color3:
                color = 0xFFFFAA00;
                dialog.dismiss();
                break;
            case R.id.color4:
                color = 0xFFFFFF00;
                dialog.dismiss();
                break;
            case R.id.color5:
                color = 0xFF00FF00;
                dialog.dismiss();
                break;
            case R.id.color6:
                color = 0xFF0000FF;
                dialog.dismiss();
                break;
            case R.id.color7:
                color = 0xFF000000;
                dialog.dismiss();
                break;
            default:
                break;
        }
    }
}