package com.mika.ane.refreshgallery
{
	
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * Utility to trigger Photo Gallery refresh on Android devices
	 * so that the user can see his new image rigth away in the camera roll
	 *  
	 * @author Mika I.
	 */	
	public class RefreshGallery extends EventDispatcher
	{
		
		private static var _instance:RefreshGallery;
		private var extContext:ExtensionContext;
		
		public static function get instance():RefreshGallery {
			if ( !_instance ) {
				_instance = new RefreshGallery( new SingletonEnforcer() );
				_instance.init();
			}
			
			return _instance;
		}
		
		public function refresh(filePath:String):void 
		{
			extContext.call( "refresh", filePath );
		}
		
		public function dispose():void { 
			extContext.dispose(); 
		}
		
		private function init():void {
			extContext.call( "init" );
		}
		
		private function onStatus( event:StatusEvent ):void 
		{
			// nothing to do here... :)
		}
		
		public function RefreshGallery( enforcer:SingletonEnforcer ) {
			super();
			
			extContext = ExtensionContext.createExtensionContext( "com.mika.ane.refreshgallery", "" );
			
			if ( !extContext ) {
				throw new Error( "Refresh Gallery native extension is not supported on this platform." );
			}
			
			extContext.addEventListener( StatusEvent.STATUS, onStatus );
		}
	}
}

class SingletonEnforcer {}