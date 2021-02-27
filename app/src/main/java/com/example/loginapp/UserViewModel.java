package com.example.loginapp;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UserViewModel extends BaseObservable {
    private String email;
    private String password;
    private String clickText = "";

    @Bindable public String getEmail() {
        return email;
    }

    @Bindable public String getPassword() { return password; }

    // ボタンクリック時に表示するテキスト（TextView）の getter
    @Bindable public String getClickText() {
        return clickText;
    }

    public void setEmail(String email) {
        this.email = email;
        // この記述でgetEmail()が呼ばれる
        // notifyPropertyChanged(BR.email);
        // この記述でisButtonEnable()が呼ばれる
        notifyPropertyChanged(BR.buttonEnable);
    }

    public void setPassword(String password) {
        this.password = password;
        // この記述でisButtonEnable()が呼ばれる
        notifyPropertyChanged(BR.buttonEnable);
    }

    // フォーム（EditText）へのテキスト入力有無で、ボタン活性・非活性を制御するフラグの getter
    @Bindable public boolean isButtonEnable() {
        // 入力あり:true  入力なし：false
        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password);
    }

    public boolean isValidInputValue() {
        if (email.length() >= 6 && password.length() >= 6) {
            return true;
        }
        return false;
    }

}
