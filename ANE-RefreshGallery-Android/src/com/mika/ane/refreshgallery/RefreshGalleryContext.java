package com.mika.ane.refreshgallery;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.mika.ane.refreshgallery.functions.InitFunction;
import com.mika.ane.refreshgallery.functions.RefreshFunction;

public class RefreshGalleryContext extends FREContext {
	public static final String TAG = "RefreshGalleryContext";
	
	@Override
	public void dispose() {
		Log.d(TAG,"Context disposed.");
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		
		functions.put("init", new InitFunction());
		functions.put("refresh", new RefreshFunction());
		
		return functions;
	}
}
