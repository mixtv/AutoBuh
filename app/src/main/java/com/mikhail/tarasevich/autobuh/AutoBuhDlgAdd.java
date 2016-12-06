package com.mikhail.tarasevich.autobuh;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class AutoBuhDlgAdd extends AppCompatActivity implements View.OnClickListener {

    TextView rec_date;
    Button btnCancel;
    Button btnAdd;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlg_add);

        Calendar c = Calendar.getInstance();
        Integer mYear = c.get(Calendar.YEAR);
        Integer mMonth = c.get(Calendar.MONTH) + 1;
        Integer mDay = c.get(Calendar.DAY_OF_MONTH);
        String dt = mDay.toString() + "." + mMonth.toString() + "." + mYear.toString();
        // установка текущей даты
        rec_date = (TextView) findViewById(R.id.rec_date);
        rec_date.setText(dt.toString());

        btnCancel = (Button) findViewById(R.id.dlg_add_bCancel);
        btnAdd = (Button) findViewById(R.id.dlg_add_bOk);
        btnCancel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        Log.d("MyLog", "AutoBuhDlgAdd onClick");
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.dlg_add_bOk:
                rec_date = (TextView) findViewById(R.id.rec_date);
                intent.putExtra("rec_date_new", rec_date.getText().toString());
                rec_date = (TextView) findViewById(R.id.rec_sum);
                intent.putExtra("rec_sum_new", rec_date.getText().toString());
                rec_date = (TextView) findViewById(R.id.rec_mileage);
                intent.putExtra("rec_mileage_new", rec_date.getText().toString());
                rec_date = (TextView) findViewById(R.id.rec_notes);
                intent.putExtra("rec_notes_new", rec_date.getText().toString());
                break;
            case R.id.dlg_add_bCancel:
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("AutoBuhDlgAdd Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
