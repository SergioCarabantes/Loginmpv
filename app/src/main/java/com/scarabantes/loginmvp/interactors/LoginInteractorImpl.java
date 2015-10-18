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

package com.scarabantes.loginmvp.interactors;

import android.os.Handler;

import com.scarabantes.loginmvp.callbacks.CallBackResponse;

/**
 * Created by scarabantes on 18/10/15.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private long millis = 1000;
    private final String USER_NAME_VALID = "1234";
    private final String PASSWORD_VALID = "1234";

    @Override
    public void login(final String userName, final String password, final CallBackResponse callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if(userName.equalsIgnoreCase(USER_NAME_VALID)
                        && password.equalsIgnoreCase(PASSWORD_VALID)) {
                    callBack.onSuccess();

                } else  {
                    callBack.onError();
                }
            }
        }, millis);
    }
}
