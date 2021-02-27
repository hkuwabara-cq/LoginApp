package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.loginapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements LoginView {

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

        viewModel.setView(this);
    }

    @Override
    public void moveToMainView() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("親からのデータ", viewModel.getEmail());
        startActivity(intent);
        finish();
    }
}
