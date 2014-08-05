package com.findmyitin.helloandroid;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.mymodule.backend.myApi.MyApi;
import com.example.mymodule.backend.myApi.model.MyBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by thompsons on 8/4/14.
 */
public class MainTask extends AsyncTask<GoogleAccountCredential, Void, Void>{
    @Override
    protected Void doInBackground(GoogleAccountCredential... params) {
        GoogleAccountCredential credential = params[0];
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), credential)
//                .setRootUrl("http://192.168.1.100:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                                                       @Override
                                                       public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                                                               throws IOException {
                                                           abstractGoogleClientRequest.setDisableGZipContent(true);
                                                       }
                                                   }
                );
        MyApi api = builder.build();
        try {
            MyBean result = api.sayHi4().execute();
            String test = result.getData();
            Log.i("test", test);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void nil) {
    }
}
