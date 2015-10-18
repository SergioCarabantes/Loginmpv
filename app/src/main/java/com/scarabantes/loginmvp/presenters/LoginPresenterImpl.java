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

package com.scarabantes.loginmvp.presenters;

import com.scarabantes.loginmvp.callbacks.CallBackResponse;
import com.scarabantes.loginmvp.interactors.LoginInteractor;
import com.scarabantes.loginmvp.interactors.LoginInteractorImpl;
import com.scarabantes.loginmvp.ui.views.LoginView;

/**
 * Created by scarabantes on 18/10/15.
 */
public class LoginPresenterImpl implements LoginPresenter, CallBackResponse {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    @Override
    public void create() {
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void setView(LoginView loginView) {
        this.loginView = loginView;

    }

    @Override
    public void validateLogin(String userName, String password) {
        loginView.showProgress();
        loginInteractor.login(userName, password, this);
    }

    @Override
    public void onSuccess() {
        loginView.hideProgress();
        loginView.onSuccessLogin();
    }

    @Override
    public void onError() {
        loginView.hideProgress();
        loginView.onErrorLogin();
    }
}
