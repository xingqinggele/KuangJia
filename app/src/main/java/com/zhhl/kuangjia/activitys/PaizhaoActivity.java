package com.zhhl.kuangjia.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.zhhl.kuangjia.R;
import com.zhhl.kuangjia.base.BaseActivity;
import com.zhhl.kuangjia.bean.Paizhaobean;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by qgl on 2019/9/26 14:40.
 */
public class PaizhaoActivity extends BaseActivity {
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.img)
    ImageView img;

    @Override
    protected int getLayoutId() {
        return R.layout.paizhaoactivity;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
        // 网络请求
//        RequestParams params = new RequestParams();
//        params.put("file", "asdasdas");
//        params.put("app_key", "3e5bf5e92c7d19c7e2948cbfbfb5572c920e4e03");
//        params.put("facepose", "40");
//        params.put("eyegaze", "40");
//        params.put("eyeskew", "35");
//        params.put("shoulderskew", "20");
//        params.put("darkillum", "50");
//        params.put("unbalanceillum", "50");
//        params.put("bfsimilarity", "60");
//        RequestCenter.request_SH(params, new DisposeDataListener() {
//            //成功
//            @Override
//            public void onSuccess(Object o) {
//
//                shouLog("PaizhaoActivity", o.toString());
//            }
//
//            //失败
//            @Override
//            public void onFailure(OkHttpException e) {
//                shouLog("PaizhaoActivity1", e.getEmsg() + "");
//
//            }
//        });
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public void inidata(String file) {
        OkHttpClient okHttpClient = new OkHttpClient();
        HashMap<String, String> map = new HashMap<>();
        map.put("app_key", "9802a935f6b0064192dfe29f48431598ae14fcc5");
        map.put("file", file);
        map.put("facepose", "40");
        map.put("eyegaze", "40");
        map.put("eyeskew", "35");
        map.put("shoulderskew", "20");
        map.put("darkillum", "50");
        map.put("unbalanceillum", "50");
        map.put("bfsimilarity", "60");
        Gson gson = new Gson();
        String data = gson.toJson(map);
        RequestBody formbody;
        formbody = RequestBody.create(JSON, data);
        Request request = new Request.Builder()
                .post(formbody)
                .url("http://apicall.id-photo-verify.com/api/env_pic")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                shouLog("PaizhaoActivity", result);

                new Thread() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    org.json.JSONObject jsonObject = new JSONObject(result);
                                    if (jsonObject.getInt("code") == 200) {

                                    } else {
                                        showToast(jsonObject.getString("msg"));
                                    }

                                } catch (JSONException e) {

                                }
                            }
                        });
                        super.run();
                    }
                }.start();


            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.btn)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    Bitmap bmp = (Bitmap) extras.get("data");
                    String aa = bitmapToBase64(bmp);
                    Log.e("啊啊啊", aa);
                    inidata(aa);
                    img.setImageBitmap(bmp);  //设置照片现实在界面上
                }
                break;
        }

    }

    private static String bitmapToBase64(Bitmap bitmap) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                baos.flush();
                baos.close();
                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
