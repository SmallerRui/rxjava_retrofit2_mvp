package com.zzr.demo.common;

import android.content.Context;
import android.content.pm.PackageManager;

import com.zzr.demo.utils.MyFileUtils;
import com.zzr.demo.utils.SystemTool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private Context mContext;
    private static CrashHandler sInstance = null;

    private CrashHandler(Context cxt) {
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.mContext = cxt.getApplicationContext();
    }

    public static synchronized CrashHandler create(Context cxt) {
        if (sInstance == null) {
            sInstance = new CrashHandler(cxt);
        }
        return sInstance;
    }


    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {

            saveToSDCard(ex);
            System.exit(0);
        } catch (Exception localException) {

        }
    }


    private void saveToSDCard(Throwable ex) throws Exception {
        File file = MyFileUtils.getSaveFile(this.mContext.getPackageName() + File.separator + "log", SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss") + ".log");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        pw.println(SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss"));

        dumpPhoneInfo(pw);

        pw.println();

        ex.printStackTrace(pw);
        pw.flush();
        pw.close();
    }

    private void dumpPhoneInfo(PrintWriter pw) throws PackageManager.NameNotFoundException {
    }

}