package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loginapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements EventHandlers {

    ActivityLoginBinding binding;
    UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Bindingのインスタンスを取得
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        // xmlのuserにLoginActivityのUserViewModelを紐付ける
        viewModel = new UserViewModel();
        binding.setViewModel(viewModel);

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
