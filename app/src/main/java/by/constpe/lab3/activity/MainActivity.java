package by.constpe.lab3.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.List;

import by.constpe.lab3.R;
import by.constpe.lab3.activity.adapter.CustomListAdapter;
import by.constpe.lab3.model.Bridge;
import by.constpe.lab3.util.JSONReader;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Bridge> bridges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bridges = JSONReader.read(getResources().openRawResource(R.raw.data));

        if (bridges != null) {
            CustomListAdapter customListAdapter = new CustomListAdapter(this, bridges);

            listView = findViewById(R.id.list);
            listView.setAdapter(customListAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intentBridgeInfo = new Intent(MainActivity.this, BridgeActivity.class);

                    intentBridgeInfo.putExtra("bridge", bridges.get(i));

                    startActivity(intentBridgeInfo);
                }
            });
        }
        else {
            final Context context = MainActivity.this;

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Internal error");
            alertDialog.setMessage("Unable to form list of bridges");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Close app",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                            System.exit(0);
                        }
                    });
            alertDialog.show();
        }
    }
}
