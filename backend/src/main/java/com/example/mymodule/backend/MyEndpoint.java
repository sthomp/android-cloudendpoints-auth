package com.example.mymodule.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.users.User;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "backend.mymodule.example.com", ownerName = "backend.mymodule.example.com", packagePath=""),
        scopes = {Constants.EMAIL_SCOPE},
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "sayHi2")
    public MyBean sayHi2(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi2, " + name);

        return response;
    }

    @ApiMethod(name = "sayHi3")
    public MyBean sayHi3(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi3, " + name);

        return response;
    }

    @ApiMethod(name = "sayHi4")
    public MyBean sayHi4(User user) {
        MyBean response = new MyBean();
        if(user == null){
            response.setData("No user set");
        }
        else{
            response.setData("Got user: " + user.getEmail());
        }
        return response;
    }

}