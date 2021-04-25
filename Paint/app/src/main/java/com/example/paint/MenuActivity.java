package com.example.paint;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 1001;
    private static final int REQUEST_CODE = 101;
    private String[] permissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private Button startButton, loadButton, exitButton;
    private Uri backgroundImageUri = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ArrayList<String> permissionList = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission : permissions) {
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    permissionList.add(permission);
                } else if (!shouldShowRequestPermissionRationale(permission)) {
                    permissionList.add(permission);
                }
            }

            requestPermissions(permissionList.toArray(new String[permissionList.size()]), REQUEST_PERMISSION_CODE);
        }

        startButton = findViewById(R.id.start_button);
        loadButton = findViewById(R.id.load_button);
        exitButton = findViewById(R.id.exit_button);

        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            if (backgroundImageUri != null) {
                intent.putExtra("backgroundImageUri", backgroundImageUri);
            }
            startActivity(intent);
        });

        loadButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, REQUEST_CODE);
        });

        exitButton.setOnClickListener(v -> {
            moveTaskToBack(true);

            if (Build.VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                finish();
            }

            System.exit(0);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            try {
                backgroundImageUri = data.getData();
                startButton.performClick();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_CODE && grantResults.length > 0) {
            for (int i=0; i<grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(this, "권한 승인", Toast.LENGTH_LONG).show();
                } else {
                    //Toast.makeText(this, "권한 거절", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
