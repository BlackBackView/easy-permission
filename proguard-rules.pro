-keep class com.bbv.easypermission.** { *; }
-keep interface com.bbv.easypermission.** { *; }

-keepattributes *Annotation*

-keep class androidx.databinding.** { *; }
-keep class * extends androidx.databinding.DataBinderMapper { *; }
-keep class * extends androidx.databinding.DataBindingComponent { *; }

-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

-keep class kotlinx.coroutines.** { *; }

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keepclassmembers class * extends android.view.View {
   void set*(***);
   *** get*();
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable *;
}