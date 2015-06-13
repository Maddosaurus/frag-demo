package de.fhdo.fragmentation_demo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t1 = (TextView)findViewById(R.id.tv01);
        TextView t2 = (TextView)findViewById(R.id.tv02);
        TextView t3 = (TextView)findViewById(R.id.tv03);
        TextView t4 = (TextView)findViewById(R.id.tv04);

        t1.setText("Release Version: " + Build.VERSION.RELEASE);
        t2.setText("Codename: " + Build.VERSION.CODENAME);

        Integer sdk = Build.VERSION.SDK_INT;
        t3.setText("SDK Version: " + sdk.toString());

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point(-1,-1);

        if(sdk >= 13) //API-Weiche ohne Support-Library
        {
            display.getSize(size);
            t4.setText("Screen size (SDK >= 13): " + size.x + "x" + size.y + " Pixels");
        }

        else {
            size.set(display.getWidth(), display.getHeight());
            t4.setText("Screen size (SDK < 13): " + size.x + "x" + size.y + " Pixels");
        }


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

        if (id == R.id.action_search)
        {
            TextView t5 = (TextView)findViewById(R.id.tv05);
            t5.setText("Bei den Buchen musst du suchen");
        }

        return super.onOptionsItemSelected(item);
    }

   public void portraitButtonClick(View view)
   {
       Toast.makeText(getApplicationContext(), "Portrait!", Toast.LENGTH_SHORT).show();
       Intent intent = new Intent(this, portrait.class);
       startActivity(intent);

   }

    public void landscapeButtonClick(View view)
    {
        Toast.makeText(getApplicationContext(), "Landscape!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, landscape.class);
        startActivity(intent);
    }
}
