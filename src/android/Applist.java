package com.brandnewengine.plugins;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ApplicationInfo;

@SuppressLint("HandlerLeak")
public class Applist extends CordovaPlugin {
    
    private Context ctx;

     public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        ctx = cordova.getActivity().getApplicationContext();
    }

    private JSONArray getList() {
        PackageManager packageMgr = ctx.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos = packageMgr.queryIntentActivities(mainIntent, 0);

        ArrayList<String> list  = new ArrayList<String>();
        for (ResolveInfo resolve : resolveInfos) {
            //String packageName = resolve.activityInfo.name;
            String packageName = resolve.applicationInfo.loadLabel(resolveInfos).toString();
            list.add(packageName);
        }
        List<String> ulist = new ArrayList<String>(new HashSet<String>(list));
        
        return new JSONArray(ulist);
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false otherwise.
     * @throws JSONException 
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        // list
        if (action.equals("getList")) {
            JSONArray json = getList();
            callbackContext.success(json.toString());
            
            return true;
        }

        return false;
    }
}
