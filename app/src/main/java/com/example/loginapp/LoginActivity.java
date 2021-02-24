package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements EventHandlers {

    ActivityLoginBinding binding;
    User viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Bindingのインスタンスを取得
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        // xmlのuserにLoginActivityのUserViewModelを紐付ける
        viewModel = new User();
        binding.setUser(viewModel);

        // xmlのhandlersにLoginActivityのonLoginClick()を紐付ける
        binding.setHandlers(this);
    }

    // buttonをクリックしたときのイベント処理
    @Override
    public void onLoginClick(View view) {
        if (viewModel.isValidInputValue()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("親からのデータ", viewModel.getEmail());
            startActivity(intent);
            finish();
        } else {
            binding.clickText.setText("6文字以上入力してください");
        }
    }
}
