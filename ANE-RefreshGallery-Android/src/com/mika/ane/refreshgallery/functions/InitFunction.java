package com.mika.ane.refreshgallery.functions;

import android.content.Context;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.mika.ane.refreshgallery.RefreshGallery;

public class InitFunction implements FREFunction {
	public static final String TAG = "InitFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		RefreshGallery.extensionContext = context;
		
		Context appContext = context.getActivity().getApplicationContext();
		RefreshGallery.appContext = appContext;
		
		Log.i(TAG, "in init");
		
		return null;
	}
}
