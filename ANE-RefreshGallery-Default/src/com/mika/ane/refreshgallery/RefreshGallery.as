package com.mika.ane.refreshgallery
{
	
	import flash.events.EventDispatcher;
	
	/**
	 * Utility to trigger Photo Gallery refresh on Android devices
	 * so that the user can see his new image rigth away in the camera roll
	 *  
	 * @author Mika I.
	 */	
	public class RefreshGallery extends EventDispatcher
	{
		
		private static var _instance:RefreshGallery;
		
		public static function get instance():RefreshGallery {
			if ( !_instance ) {
				_instance = new RefreshGallery( new SingletonEnforcer() );
				_instance.init();
			}
			
			return _instance;
		}
		
		public function refresh(filePath:String):void 
		{
		}
		
		public function dispose():void { 
		}
		
		private function init():void {
		}
		
		public function RefreshGallery( enforcer:SingletonEnforcer ) {
			super();
			
		}
	}
}

class SingletonEnforcer {}