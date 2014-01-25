package com.mika.ane.refreshgallery.functions;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class RefreshFunction implements FREFunction {
	public static final String TAG = "RefreshFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args) {

		Context appContext = context.getActivity().getApplicationContext();
		
		String filePath = "";
		try {
			filePath = args[0].getAsString();
		} catch (Exception e) {
			
		}

		if ( filePath == "" ) return null;

		// Tell the media scanner about the new file so that it is
	    // immediately available to the user.
	    MediaScannerConnection.scanFile(appContext,
	            new String[] { filePath }, null,
	            new MediaScannerConnection.OnScanCompletedListener() {
	        public void onScanCompleted(String path, Uri uri) {
	            Log.i(TAG, "Scanned " + path + ":");
	            Log.i(TAG, "-> uri=" + uri);
	        }
	    });
	    
		return null;
	}
}
