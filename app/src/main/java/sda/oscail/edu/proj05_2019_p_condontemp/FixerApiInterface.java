package sda.oscail.edu.proj05_2019_p_condontemp;
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * citation
 * Class contains code adapted from :
 * https://www.youtube.com/watch?v=u1zb4dHthss
 * https://www.androidauthority.com/retrofit-android-tutorial-906928/
 * https://github.com/square/retrofit
 * https://www.javatpoint.com/android-json-parsing-tutorial
 */

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * create a interface that contains the API endpoint. Retrofit supports GET:
 * @get processes a HTTP GET request to retrieve data from the server
 */
public interface FixerApiInterface {

    //key to the fixer.io site
    @GET("latest?access_key=c0b866cc59fa9266142b6e42a9d495be&format=1")
    Call<FixerRates> loadCurrencyExchange();
}
