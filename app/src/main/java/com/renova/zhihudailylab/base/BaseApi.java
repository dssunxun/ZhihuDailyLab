package com.renova.zhihudailylab.base;

import com.orhanobut.logger.Logger;
import com.renova.zhihudailylab.utils.OkHttpUtils;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * api基类
 * Created by Renova on 2015/10/29.
 */
public class BaseApi {

    protected static String doGetMethodGetJsonResponse(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = OkHttpUtils.getInstance()
                .execute(request);

        if (response.isSuccessful()) {
            String responseUrl = response.body()
                    .string();
            Logger.json(responseUrl);
            return responseUrl;
        } else {
            Logger.e(new Exception(response.code() + ""), "Status error code :");
            return response.code()+"";
        }
    }

    public static String setServerResponseErrorMsg(int code) {

        String errorMsg = "";
        if (code < 500 && code >= 400) {
            errorMsg = "请求错误!";
        }
        if (code >= 500) {
            errorMsg = "服务器错误!";
        }
        return errorMsg;
    }

    public static boolean isResponseSuccessful(String reponse)
    {
        return reponse.contains("{");
    }
}
