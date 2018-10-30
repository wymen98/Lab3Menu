package my.edu.taruc.lab3menu;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMessage;
    private float size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtain the size of TextView
        textViewMessage = findViewById(R.id.textViewMessage);
        size = textViewMessage.getTextSize() / getResources().getDisplayMetrics().density;
        //size = px2sp(textViewMessage.getContext(), size);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //public static int px2sp(Context context, float pxValue) {
    //    final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    //    return (int) (pxValue / fontScale + 0.5f);
    //}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.action_increase){
            //increase font size
            size += 2;
            textViewMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);

        } else if(id == R.id.action_decrease){
            //decrease font size
            size -= 2;
            textViewMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }

        return super.onOptionsItemSelected(item);
    }
}
