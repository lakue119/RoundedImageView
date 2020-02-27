# RoundedImageView
RoundedImageView is Round the corners of the image.
* The default is set to 7f.
* You can set the roundness as desired.

# Sample

<img width="40%" src="https://user-images.githubusercontent.com/31702431/75465250-b483ef80-59cb-11ea-8930-268394dc3383.jpeg">

# Install
Add Jitpack to your repositories in your build.gradle file
<pre>
<code>
  allprojects {
      repositories {
        // ...
        maven { url 'https://jitpack.io' }
      }
  }
</code>
</pre>

Add the below to your dependencies, again in your gradle.build file

<pre>
<code>

dependencies {
    //A library that allows you to use RoundImageView.
    implementation 'com.github.lakue119:RoundedImageView:1.0.0'
}
</code>
</pre>
# Code
add following code in xml

```
     <com.lakue.lakueroundedimageview.RoundedImageView
                android:src="@drawable/background2"
                app:rectRadius="10"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"/>
```

How to write in Java code

<pre>
<code>
   roundimageview.setRectRadius(20.f);
</code>
</pre>


# Note

https://lakue.tistory.com/22
