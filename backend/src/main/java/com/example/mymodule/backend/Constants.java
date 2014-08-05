package com.example.mymodule.backend;

/**
 * Created by thompsons on 8/4/14.
 */
public class Constants {
    // Get this from the developer console under 'Compute Engine and App Engine'
    public static final String WEB_CLIENT_ID = "";
    // Create a client id using SHA1.
    // Get SHA1 by checking:
    //  keytool -list -v -keystore ~/.android/debug.keystore
    public static final String ANDROID_CLIENT_ID = "";
    public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
    public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;
    public static final String API_EXPLORER_CLIENT_ID = com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID;


    public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
}
