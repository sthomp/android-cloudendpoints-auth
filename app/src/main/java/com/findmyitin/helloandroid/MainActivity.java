package com.findmyitin.helloandroid;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mymodule.backend.myApi.MyApi;
import com.example.mymodule.backend.myApi.model.MyBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


public class MainActivity extends Activity {

    GoogleAccountCredential credential;
    private static final int ACTIVITY_RESULT_FROM_ACCOUNT_SELECTION = 2222;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY_RESULT_FROM_ACCOUNT_SELECTION && resultCode == Activity.RESULT_OK) {
            // This path indicates the account selection activity resulted in the user selecting a
            // Google account and clicking OK.


            // Set the selected account.
            String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);

            this.credential.setSelectedAccountName(accountName);

            MainTask task = new MainTask();
            task.execute(credential);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get this from the developer console under 'Compute Engine and App Engine'
        String clientid = "";

        this.credential = GoogleAccountCredential.usingAudience(
                this, "server:client_id:" + clientid);

        startActivityForResult(this.credential.newChooseAccountIntent(),
                ACTIVITY_RESULT_FROM_ACCOUNT_SELECTION);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
