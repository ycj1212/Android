package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
    ImageButton selectPen, selectLine, selectCircle, selectRect;
    ImageButton currentPenColor;
    SeekBar penWidth;

    AlertDialog selectPenDialog, selectColorDialog;

    float width;        // pen stroke width
    int color;          // current color(background, paint)
    int mode = 1;       // 0: backgroundColor, 1: paintColor
    int penMode = 0;    // 0: pen, 1: line, 2: circle, 3: rect

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout paint = findViewById(R.id.paint);
        singleTouchView = new SingleTouchView(this, null);

        // 이미지를 불러왔을 때 인텐트를 통해 이미지의 Uri를 전달받음
        Uri backgroundImageUri = getIntent().getParcelableExtra("backgroundImageUri");
        if (backgroundImageUri != null) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(backgroundImageUri);
                Drawable background = new BitmapDrawable(getResources(), inputStream);
                inputStream.close();
                singleTouchView.setBackground(background);  // 불러온 이미지 배경 설정
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 그림판 뷰인 singleTouchView를 FrameLayout에 추가
        paint.addView(singleTouchView);

        newPage = findViewById(R.id.new_page);
        pen = findViewById(R.id.pen);
        eraser = findViewById(R.id.eraser);
        save = findViewById(R.id.save);

        backgroundColor = findViewById(R.id.background_color);
        paintColor = findViewById(R.id.paint_color);
        minusButton = findViewById(R.id.minus_button);
        plusButton = findViewById(R.id.plus_button);

        selectPen = findViewById(R.id.select_pen);
        selectLine = findViewById(R.id.select_line);
        selectCircle = findViewById(R.id.select_circle);
        selectRect = findViewById(R.id.select_rect);

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

        setSelectPenDialog();   // 펜 버튼 클릭 시 나타나는 다이얼로그 설정
        setSelectColorDialog(); // 색상 버튼 클릭 시 나타나는 다이얼로그 설정
    }

    // 펜 선택 다이얼로그 설정
    public void setSelectPenDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View colorMenu = inflater.inflate(R.layout.dialog_pen, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(colorMenu);

        selectPenDialog = builder.create();
        WindowManager.LayoutParams dialogParams = selectPenDialog.getWindow().getAttributes();

        LinearLayout topMenu = findViewById(R.id.top_menu);

        dialogParams.y = topMenu.getHeight();
        System.out.println(topMenu.getHeight());
        selectPenDialog.getWindow().setAttributes(dialogParams);
    }

    // 색상 선택 다이얼로그 설정
    public void setSelectColorDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View colorMenu = inflater.inflate(R.layout.dialog_color, null);

        currentPenColor = colorMenu.findViewById(R.id.color1);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(colorMenu);

        selectColorDialog = builder.create();
        WindowManager.LayoutParams dialogParams = selectColorDialog.getWindow().getAttributes();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        LinearLayout bottomMenu = findViewById(R.id.bottom_menu);

        dialogParams.y = size.y - bottomMenu.getHeight();
        selectColorDialog.getWindow().setAttributes(dialogParams);
        selectColorDialog.setOnDismissListener(dialog -> {
            if (mode == 0) {
                backgroundColor.setBackgroundColor(color);
                singleTouchView.setBackColor(color);
            } else {
                paintColor.setBackgroundColor(color);
                singleTouchView.setPaintColor(color);
            }
        });
    }

    // 그림판에 보이는 옵션 메뉴들의 onClick 메소드
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_page:
                Toast.makeText(this, "new_page", Toast.LENGTH_SHORT).show();
                singleTouchView.erase();
                break;
            case R.id.pen:
                Toast.makeText(this, "pen", Toast.LENGTH_SHORT).show();
                selectPenDialog.show();
                singleTouchView.setPenMode(penMode);
                break;
            case R.id.eraser:
                Toast.makeText(this, "eraser", Toast.LENGTH_SHORT).show();
                singleTouchView.setEraserMode();
                break;
            case R.id.save:
                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
                save(singleTouchView.getBitmap());
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
                color = ((ColorDrawable) backgroundColor.getBackground()).getColor();
                selectColorDialog.show();
                mode = 0;
                break;
            case R.id.paint_color:
                Toast.makeText(this, "paint color", Toast.LENGTH_SHORT).show();
                color = ((ColorDrawable) paintColor.getBackground()).getColor();
                selectColorDialog.show();
                mode = 1;
                break;
            default:
                break;
        }
    }

    // 펜 선택 다이얼로그에 보이는 옵션 메뉴들의 onClick 메소드
    public void selectPen(View view) {
        switch (view.getId()) {
            case R.id.select_pen:
                penMode = 0;
                pen.setImageResource(R.drawable.pen);
                selectPenDialog.dismiss();
                break;
            case R.id.select_line:
                penMode = 2;
                pen.setImageResource(R.drawable.line);
                selectPenDialog.dismiss();
                break;
            case R.id.select_circle:
                penMode = 3;
                pen.setImageResource(R.drawable.circle);
                selectPenDialog.dismiss();
                break;
            case R.id.select_rect:
                penMode = 4;
                pen.setImageResource(R.drawable.rectangle);
                selectPenDialog.dismiss();
                break;
        }

        singleTouchView.setPenMode(penMode);
    }

    // 색상 선택 다이얼로그에 보이는 옵션 메뉴들의 onClick 메소드
    public void selectPenColor(View view) {
        if (view != currentPenColor) {
            currentPenColor = (ImageButton) view;
            color = ((ColorDrawable) currentPenColor.getBackground()).getColor();
            selectColorDialog.dismiss();
        }
    }

    // 그림 저장
    public void save(Bitmap bitmap) {
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