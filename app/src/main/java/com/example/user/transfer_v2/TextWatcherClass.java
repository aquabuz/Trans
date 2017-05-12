package com.example.user.transfer_v2;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

/**
 * Created by User on 2017-05-12.
 */

public class TextWatcherClass implements TextWatcher {

//    인터페이스 호출
//    private TextWatcherInterface    m_Interface     = null;
//
//    public TextWatcherClass(TextWatcherInterface callback) {
//        Log.e("aaa", "TextWatcherClass");
//
//        m_Interface = callback;
//
//    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // 입력받은 값에 100을 곱한다
//        int changeValue = Integer.parseInt(editText.getText().toString()) * 100;
//        textView.setText(changeValue+""); // 위에서 얻은 변경된값을 textView에 표시한다
        Log.e("aaa", "aaaaaaaa");
    }

    @Override
    public void afterTextChanged(Editable s) {

//        s.toString();
//        Log.e("=debug=")


//        인터페이스 호출
//        m_Interface.onInterface(s.toString());


    }
}
