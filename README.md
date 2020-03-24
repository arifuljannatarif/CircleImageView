to add this circle imageview to your project you just need to edit the following in your build.gradle file

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
  
  dependencies {
	       implementation 'com.github.arifuljannatarif:CircleImageView:circleImageViewlibrary-SNAPSHOT'
	}
