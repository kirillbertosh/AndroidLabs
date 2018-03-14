package by.constpe.lab3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import by.constpe.lab3.R;
import by.constpe.lab3.model.Bridge;
import by.constpe.lab3.util.BitmapUtil;

public class BridgeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bridge_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final Bridge bridge = (Bridge)intent.getSerializableExtra("bridge");

        TextView nameTextView = (TextView) findViewById(R.id.name);
        TextView heightTextView = (TextView) findViewById(R.id.height);
        TextView infoTextView = (TextView) findViewById(R.id.info);
        ImageView imageView = findViewById(R.id.image);

        this.setTitle(bridge.getName());

        nameTextView.setText(bridge.getName());
        heightTextView.setText(bridge.getHeight());
        infoTextView.setText(bridge.getDescription());
        imageView.setImageBitmap(BitmapUtil.decodeBitmapFromResources(this.getResources(),
                        this.getResources().getIdentifier(bridge.getDetailImage(),
                        "drawable", this.getPackageName()), 200, 200));

        Button webButton = findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webViewIntent = new Intent(BridgeActivity.this, WebActivity.class);
                webViewIntent.putExtra("url", bridge.getUrl());
                startActivity(webViewIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
