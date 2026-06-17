# 保留公开 API，混淆内部实现细节
-keep,allowoptimization class com.bbv.easypermission.** {
    public protected *;
}

-keepattributes *Annotation*

# 保留自定义 View 构造方法（XML inflate 需要）
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.view.View {
   void set*(***);
   *** get*();
}

# Parcelable 序列化
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable *;
}
