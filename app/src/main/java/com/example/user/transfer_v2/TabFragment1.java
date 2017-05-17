package com.example.user.transfer_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 2017-04-28.
 */

public class TabFragment1 extends Fragment {

    EditText editText;
    Button button;
    TextView m_Currency = null;
    ImageView m_Country = null;

    Intent intent;

    private TextWatcher m_textWatcher   = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        editText = (EditText) view.findViewById(R.id.inputText); // 값을 입력할 EditText
        button = (Button) view.findViewById(R.id.compare); // 활성 비활성 버튼
        m_Currency = (TextView) view.findViewById(R.id.Currency);
        m_Country = (ImageView) view.findViewById(R.id.Country);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), ListCompare.class);
                startActivity(intent);
            }
        });

        m_textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                double x = 0;

                if(editText.getText().toString().length() > 0) {
                    x = Double.parseDouble(editText.getText().toString()); // Editable integer 변환
                }

                String min = getString(R.string.min_value); // get string.xml 가져오기
                String max = getString(R.string.max_value);

                double minDouble = Double.parseDouble(min); // getString ----> Int 변환
                double maxDouble = Double.parseDouble(max);

                if( x > minDouble ) {
                    button.setEnabled(true);
                } if ( x > maxDouble ) {
                    Toast.makeText(getActivity(), "최대 송금액은 1,000,000원입니다.", Toast.LENGTH_SHORT).show();
                    button.setEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
//                입력값
//                onSetTextWatcher(s.toString());
            }
        };

        editText.addTextChangedListener(m_textWatcher);

        return view;
    }

//    입력값 호출
//    private void onSetTextWatcher(String text) {
//        Log.e("aaa", "text=" + text);
//    }

    public void setCurrency(String currency) {
        m_Currency.setText(currency);//통화 변경
    }

    public void setCountry(int country) {
        m_Country.setImageResource(ListCountryImages.ImageId[country]);//국자 이미지
    }

}
