package com.czs.textview4dev.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.widget.AppCompatTextView;
import android.text.format.DateUtils;
import android.view.Gravity;
import android.view.WindowManager;

import com.czs.textview4dev.Constants;


public class TextView4Dev extends AppCompatTextView
{

    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;

    public TextView4Dev(Activity activity)
    {
        super(activity);
        setTextSize(12);
        setTransformationMethod(null);//字母禁止转换大写
        setTextColor(Color.BLACK);
        setGravity(Gravity.RIGHT);
        setBackgroundColor(Color.TRANSPARENT);
        setText(getDevInfo(activity));
        // 判断是否有权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (!Settings.canDrawOverlays(activity))
            {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + activity.getPackageName()));
                activity.startActivityForResult(intent, 10);
                activity.finish();
            } else
            {
                showInfoText(activity);
            }
        } else
        {
            showInfoText(activity);
        }

    }

    /**
     * 隐藏视图
     * hide info text
     */
    public void hideInfoText()
    {
        windowManager.removeView(this);
    }

    /**
     * 显示app信息文字
     * show info text
     * @param context 上下文
     */
    private void showInfoText(Context context)
    {
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 布局设置
        layoutParams = new WindowManager.LayoutParams();
        // 设置window type
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//8.0
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }
        // 设置背景透明
        layoutParams.format = PixelFormat.RGBA_8888;
        // 设置显示的位置
        layoutParams.gravity = Gravity.RIGHT | Gravity.TOP;
        // 设置Window flag 不可触摸无焦点
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 设置视图大小
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        // 添加视图
        windowManager.addView(this, layoutParams);
    }


    /**
     * 获取app信息
     * get info
     * @param context
     * @return
     */
    public String getDevInfo(Context context)
    {
        StringBuilder info = new StringBuilder();
        PackageManager packageManager = context.getPackageManager();
        try
        {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            // app最后更新时间
            long lastUpdateTime = packageInfo.lastUpdateTime;
            CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(lastUpdateTime);
            info.append("LastUpdate：").append(relativeTimeSpanString).append("\n");
            // app版本
            String versionName = packageInfo.versionName;
            info.append("Version：").append(versionName).append("\n");
            // api的host
            info.append("Host：").append(Constants.HOST).append("\n");
            // 测试机android版本
            info.append("Android：").append(Build.VERSION.RELEASE).append("\n");
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return info.toString();
    }
}
