package com.example.gitexam;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by massivcode@gmail.com on 2017. 2. 13. 16:08
 *
 * 프래그먼트는 디폴트 생성자만 사용할 수 있습니다.
 */
public class TestFragment extends Fragment {

    public interface CallbackListener {
        void onButtonClicked(String value);
    }

    private CallbackListener mListener;

    // 이 프래그먼트가 액티비티에 붙었을 때 리스너를 연결한다.
    // 해당 액티비티는 이 리스너를 implement 해야한다.
    // 이 경우는 프래그먼트가 뷰페이져 안에서 동작하고 있을 때, 프래그먼트가 액티비티로 값을 전달하고 싶을 때 사용한다.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (CallbackListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText editText = (EditText) view.findViewById(R.id.test_et);

        view.findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editText.getText().toString();

                if (mListener != null) {
                    mListener.onButtonClicked(value);
                }
            }
        });
    }
}
