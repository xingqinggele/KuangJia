package com.zhhl.kuangjia.Uri;


import com.example.toollibrary.okhttp.CommonOkHttpClient;
import com.example.toollibrary.okhttp.listener.DisposeDataHandle;
import com.example.toollibrary.okhttp.listener.DisposeDataListener;
import com.example.toollibrary.okhttp.request.CommonRequest;
import com.example.toollibrary.okhttp.request.RequestParams;


import static com.zhhl.kuangjia.Uri.UrlService.QISHI1;


/**
 * 描述:     统一管理所有的请求
 */

public class RequestCenter {

    public static void request_Url(RequestParams params, DisposeDataListener listener) {
        CommonOkHttpClient.post((CommonRequest.createPostRequest(QISHI1, params)), new DisposeDataHandle(listener));
    }

}
