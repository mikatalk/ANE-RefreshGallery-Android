ANE-RefreshGallery-Android
==========================

ANE to Refresh The Gallery on Android right after saving a file. Making sure it is available to the user right away


Usage:
<pre>
try{
	var fs:FileStream = new FileStream();
	fs.open(file, FileMode.WRITE);
	fs.writeBytes(stream);
	fs.close();
	RefreshGallery.instance.refresh(file.nativePath);
}
catch (error:Error)
{
	trace("Failed:", error.message);
}
</pre>