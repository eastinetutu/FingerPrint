package com.tutu.fingerprint;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tutu.lib_fingerprint.BiometricPromptManager;

/**
 * @author ：wuchao on 2020/10/16 11：15
 * @describe ：描述一下
 * email: 519510228@qq.com
 */

public class MainActivity extends AppCompatActivity {

    private BiometricPromptManager mManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onFingerClick(View v) {
        gotoFingerPrint();
    }

    private void gotoFingerPrint() {
        mManager = BiometricPromptManager.from(this);
        if (mManager.isBiometricPromptEnable()) {
            mManager.authenticate(new BiometricPromptManager.OnBiometricIdentifyCallback() {
                @Override
                public void onUsePassword() {
                    Toast.makeText(MainActivity.this, "指纹验证失败次数过多，稍后重试！", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onSucceeded() {
                    Toast.makeText(MainActivity.this, "指纹登录已开启！", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailed() {

                }

                @Override
                public void onError(int code, String reason) {

                }

                @Override
                public void onCancel() {

                }
            });

//            {
//                override fun onUsePassword() {
//                    ToastUtils.show("指纹验证失败次数过多，稍后重试！")
//                    sbSetting.isChecked = false
//                }
//
//                override fun onSucceeded() {
//                    ToastUtils.show("指纹登录已开启")
//                    sbSetting.isChecked = true
//                    LoginSaveSpUtils.addOpenAgreementMobile(SpUtils.getString(ConstantUtils.MOBILE))
//                }
//
//                override fun onFailed() {
//                    sbSetting.isChecked = false
//                }
//
//                override fun onError(code: Int, reason: String) {
//                    sbSetting.isChecked = false
//                }
//
//                override fun onCancel() {
//                    sbSetting.isChecked = false
//                }
//            })
        }
    }


}
