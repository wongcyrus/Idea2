package vtc.edu.hk.idea2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import vtc.edu.hk.idea2.api.RailGirlService;
import vtc.edu.hk.idea2.data.IdeaItem;


public class MainActivity extends Activity {

    private static final String API = "http://10.0.2.2:3000/";

    public void onClick(View view) {

        //Retrofit section start from here...
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();                                        //create an adapter for retrofit with base url

        RailGirlService railGirlService = restAdapter.create(RailGirlService.class);

        IdeaItem ideaItem = new IdeaItem();
        EditText input = (EditText) findViewById(R.id.name);
        String name = input.getText().toString();
        ideaItem.setName(name);

        input = (EditText) findViewById(R.id.descriptions);
        String descriptions = input.getText().toString();
        ideaItem.setDescription(descriptions);

        input = (EditText) findViewById(R.id.picture);
        String picture = input.getText().toString();
        ideaItem.setPicture(picture);

        final Context applicationContext = getApplicationContext();
        railGirlService.createIdea(ideaItem, new Callback<IdeaItem>() {

            @Override
            public void success(IdeaItem ideaItem, Response response) {
                Log.i(this.getClass().getName(), "Save Success!");
                Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_LONG);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i(this.getClass().getName(), "Save Unsuccess!" + error);
                Toast.makeText(applicationContext, "Save Unsuccess!", Toast.LENGTH_LONG);
            }
        });

        Toast.makeText(this, "Sent Save Request!",
                Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
