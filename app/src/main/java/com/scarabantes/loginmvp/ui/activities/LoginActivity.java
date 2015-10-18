/*
 *
 *  * Copyright (C) 2015 Sergio Carabantes
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.scarabantes.loginmvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.scarabantes.loginmvp.R;
import com.scarabantes.loginmvp.presenters.LoginPresenter;
import com.scarabantes.loginmvp.presenters.LoginPresenterImpl;
import com.scarabantes.loginmvp.ui.views.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{

    private EditText username;
    private EditText password;
    private Button button;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initPresenter();
        initViews();
        initListeners();

        setSupportActionBar(toolbar);
    }

    private void initListeners() {
        button.setOnClickListener(this);
    }

    private void initPresenter() {
        presenter = new LoginPresenterImpl();
        presenter.create();
        presenter.setView(this);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.login_button);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }


    @Override
    public void onClick(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        presenter.validateLogin(user, pass);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onSuccessLogin() {
        navigateToHome();
    }

    @Override
    public void onErrorLogin() {
        Toast.makeText(this, getString(R.string.toast_login_error), Toast.LENGTH_SHORT).show();
    }

    private void navigateToHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
