package com.example.daggerhomework;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class GlobalProc {
    public static void toast(Context context, int stringID){
        Toast.makeText(context, stringID, Toast.LENGTH_LONG).show();
    }

    public static boolean isConnected(ConnectivityManager manager){
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
