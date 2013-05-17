package com.blundell.tutorial;

import android.service.dreams.DreamService;
import android.view.View;
import android.widget.Toast;

/**
 * Not really an Activity but just pretend it is one
 * <p/>
 * Where onCreate is onDreamingStarted
 * Where onPause is onDreamingStopped
 */
public class DayDreamActivity extends DreamService implements View.OnClickListener {

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        // Removed the status bar
        setFullscreen(true);
        // We want to know about clicks
        setInteractive(true);
        // Dull the screen
        setScreenBright(false);

        // Acts just like an Activity
        setContentView(R.layout.dream_main);
        findViewById(R.id.dream_main_image).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startApp();
    }

    private void startApp() {
        Toast.makeText(this, "Start your activity or another app on click", Toast.LENGTH_SHORT).show();
        // This is where you would normally start an Intent
        // don't forget to add the new activity flag
//        Intent intent = new Intent(this, null);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }
}
