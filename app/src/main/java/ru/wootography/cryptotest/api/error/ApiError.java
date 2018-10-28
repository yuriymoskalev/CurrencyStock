package ru.wootography.cryptotest.api.error;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;



// TODO: 11.09.2018 Refactor that
public class ApiError extends Throwable {
    public ApiError(ResponseBody responseBody) {
        super(getMessage(responseBody));
    }


    private static String getMessage(ResponseBody responseBody) {
        try {
            return new JSONObject(responseBody.string()).optString("message");
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        return "Unknown exception";
    }
}
