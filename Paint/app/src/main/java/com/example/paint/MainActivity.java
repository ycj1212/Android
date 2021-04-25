package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SingleTouchView singleTouchView;
    ImageView newPage, pen, eraser, save;
    ImageButton backgroundColor, paintColor, minusButton, plusButton;
    ImageButton currentPenColor;
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
        Uri backgroundImageUri = getIntent().getParcelableExtra("backgroundImageUri");
        if (backgroundImageUri != null) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(backgroundImageUri);
                Drawable background = new BitmapDrawable(getResources(), inputStream);
                inputStream.close();
                singleTouchView.setBackground(background);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        paint.addView(singleTouchView);

        newPage = findViewById(R.id.new_page);
        pen = findViewById(R.id.pen);
        eraser = findViewById(R.id.eraser);
        save = findViewById(R.id.save);

        backgroundColor = findViewById(R.id.background_color);
        paintColor = findViewById(R.id.paint_color);
        minusButton = findViewById(R.id.minus_button);
        plusButton = findViewById(R.id.plus_button);

        newPage.setOnClickListener(this);
        pen.setOnClickListener(this);
        eraser.setOnClickListener(this);
        save.setOnClickListener(this);

        backgroundColor.setOnClickListener(this);
        paintColor.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);

        penWidth = findViewById(R.id.seekbar_width);
        penWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                width = seekBar.getProgress();
                singleTouchView.setPathWidth(width);
                Toast.makeText(getApplicationContext(), "굵기: " + width, Toast.LENGTH_SHORT).show();
            }
        });

        LayoutInflater inflater = getLayoutInflater();
        View colorMenu = inflater.inflate(R.layout.dialog_color, null);

        currentPenColor = colorMenu.findViewById(R.id.color1);

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
                save(getApplicationContext(), singleTouchView.getBitmap());
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
            default:
                break;
        }
    }

    public void selectPenColor(View view) {
        currentPenColor = (ImageButton) view;
        color = ((ColorDrawable) currentPenColor.getBackground()).getColor();
        dialog.dismiss();
    }

    public void save(Context context, Bitmap bitmap) {
        String fileName = System.currentTimeMillis() + ".jpg";
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        System.out.println(dir.getPath());

        File file = new File(dir, fileName);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = "file://" + dir.getPath() + "/" + fileName;
        System.out.println(s);

        sendBroadcast(new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.parse("file://" + dir.getPath() + "/" + fileName)
        ));
    }
}