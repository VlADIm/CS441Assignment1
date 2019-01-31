package com.example.cs441assignment1;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        changeText();
    }

    private void changeText(){
        final TextView changetext = (TextView) findViewById(R.id.text_to_change);

        final Button changeTextButton = (Button) findViewById(R.id.change_text_button);

        final CoordinatorLayout MainActivity = (CoordinatorLayout) findViewById(R.id.coordinator);

        ColorDrawable[] color = {new ColorDrawable(getResources().getColor(R.color.bgColorStart)), new ColorDrawable(getResources().getColor(R.color.bgColorChange))};

        final TransitionDrawable trans = new TransitionDrawable(color);

        MainActivity.setBackground(trans);


        final Animation bounce_anim = AnimationUtils.loadAnimation(this, R.anim.bounce);

//        trans.setCrossFadeEnabled(true);

        changeTextButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    changetext.setText(getResources().getString(R.string.text_change));
//                    MainActivity.setBackgroundColor(getResources().getColor(R.color.bgColorChange));
                    trans.reverseTransition(1500);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    changetext.setText(getResources().getString(R.string.text_default));
//                    MainActivity.setBackgroundColor(getResources().getColor(R.color.bgColorStart));
                    changeTextButton.startAnimation(bounce_anim);

                    trans.reverseTransition(1500);
                }
                return true;
            }
        });
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
