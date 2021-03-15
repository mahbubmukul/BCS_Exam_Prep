# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile



#Keep Rules
-keepattributes Signature

-keepclassmembers,allowobfuscation public class * extends androidx.lifecycle.AndroidViewModel {
   public <init>(...);
}

#Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.cloudinary.android.*Strategy

#Retrofit
-keepclassmembernames,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

-keepclassmembernames,allowobfuscation class com.priyo.people.viewmodel.point.BuyGoPointViewModel {
    public void bindCustomTab(...);
    public void unBindCustomTab(...);
    public void checkPointBuyPointStatus(...);
}


#Facebook

-keep class com.facebook.all.All
-keep public class com.android.vending.billing.IInAppBillingService {
    public static com.android.vending.billing.IInAppBillingService asInterface(android.os.IBinder);
    public android.os.Bundle getSkuDetails(int, java.lang.String, java.lang.String, android.os.Bundle);
}

-keepnames class com.facebook.FacebookActivity
-keepnames class com.facebook.CustomTabActivity

-keepclassmembers class * implements java.io.Serializable {
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#Don't Warn Rules

#Glide
-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder

#OkHttp
-dontwarn com.google.android.gms.internal.**
-dontwarn com.google.android.gms.dynamic.**
-dontwarn com.google.android.gms.common.util.**
-dontwarn com.google.android.gms.common.internal.**
-dontwarn com.google.android.gms.common.stats.**
-dontwarn com.google.android.gms.common.internal.safeparcel.**
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**

#Retrofit
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement


-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

-printmapping build/outputs/mapping/release/mapping.txt