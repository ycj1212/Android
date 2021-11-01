package com.example.sttproject

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val STT_PERMISSION_REQUEST_CODE = 101

class MainActivity : AppCompatActivity() {
    private val sttResult by lazy { findViewById<TextView>(R.id.tv_stt_result) }
    private val sttButton by lazy { findViewById<Button>(R.id.btn_stt) }

    private lateinit var recognizer: SpeechRecognizer

    private val listener = object : RecognitionListener {
        override fun onReadyForSpeech(p0: Bundle?) {
            // 말하기 시작할 준비가 되면 호출
            Log.d("[RecognitionListener]", "onReadyForSpeech()")
        }

        override fun onBeginningOfSpeech() {
            // 말하기 시작했을 때 호출
            Log.d("[RecognitionListener]", "onReadyForSpeech()")
        }

        override fun onRmsChanged(p0: Float) {
            // 입력받는 소리의 크기를 알려줌
        }

        override fun onBufferReceived(p0: ByteArray?) {
            // 말을 시작하고 인식이 된 단어를 buffer에 담음
        }

        override fun onEndOfSpeech() {
            // 말하기를 중지하면 호출
        }

        override fun onError(p0: Int) {
            // 네트워크 또는 인식 오류가 발생했을 때 호출
        }

        override fun onResults(p0: Bundle?) {
            // 인식 결과가 준비되면 호출
            // 말을 하면 ArrayList에 단어를 넣고 textView에 단어 이어준다.
        }

        override fun onPartialResults(p0: Bundle?) {
            // 부분 인식 결과를 사용할 수 있을 때 호출
        }

        override fun onEvent(p0: Int, p1: Bundle?) {
            // 향후 이벤트를 추가히기 위해 예약
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, packageName)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR")
        }

        sttButton.setOnClickListener {
            recognizer = SpeechRecognizer.createSpeechRecognizer(this)
            recognizer.setRecognitionListener(listener)
            recognizer.startListening(intent)
        }
    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.RECORD_AUDIO
                ), STT_PERMISSION_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            STT_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "권한 승인 완료", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "권한 승인 거절", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}