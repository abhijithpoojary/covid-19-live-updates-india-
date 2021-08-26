package com.example.volley;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;



























































































































































































































































































































































import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btndailyreport,btnupdates;



    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get data JSON
    private static String url = "https://api.covid19india.org/data.json";


    ArrayList<HashMap<String, String>> contactList;


    private ListView activity_main;
    private ArrayAdapter<String> listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);


            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("statewise");

                    // looping through All covid-19
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String state = c.getString("state");
                        String confirmed = c.getString("confirmed");
                        String active = c.getString("active");
                        String deaths = c.getString("deaths");
                        String recovered = c.getString("recovered");


                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("state", state);
                        contact.put("confirmed", "confirmed: " + confirmed);
                        contact.put("active", "active: " + active);
                        contact.put("deaths", "death: " + deaths);
                        contact.put("recovered", "recovered: " + recovered);


                        contactList.add(contact);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Check your internet connection",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, contactList,
                    R.layout.list_item, new String[]{"state", "confirmed", "active",
                    "deaths", "recovered"}, new int[]{R.id.state, R.id.confirmed,
                    R.id.active, R.id.deaths, R.id.recovered});
            lv.setAdapter(adapter);


            lv.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String cities = String.valueOf(parent.getItemAtPosition(position));
                            Toast.makeText(MainActivity.this, cities, Toast.LENGTH_LONG).show();

                            if (position == 1) {
                                //code specific to first list item
                                Intent myIntent = new Intent(view.getContext(), stateinfo.class);
                                startActivityForResult(myIntent, 0);
                            }

                            if (position == 2) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 3) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 4) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 5) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 6) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 7) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 8) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 9) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 10) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 11) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 12) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 13) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 14) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 15) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 16) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 17) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 18) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 19) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 20) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 21) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 22) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 23) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 24) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 25) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 26) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 27) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 28) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 29) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 2) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 30) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 31) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 32) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 33) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 34) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 35) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 36) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 37) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }
                            if (position == 38) {
                                //code specific to first list item
                                Intent myIntent2 = new Intent(view.getContext(), stateinfo2.class);
                                startActivityForResult(myIntent2, 0);

                            }



                        }


                    });
            Button btn = (Button)findViewById(R.id.btnupdates);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, updates.class));
                }
            });

        }
    }
}