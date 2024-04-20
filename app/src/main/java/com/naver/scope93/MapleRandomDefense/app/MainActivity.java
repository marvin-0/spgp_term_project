package com.naver.scope93.MapleRandomDefense.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.naver.scope93.spgp_term_project.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void onBtnButton(View view){
        if(view.getId() == R.id.imageButton1){
            startActivity(new Intent(this, MapleRandomDefense.class));
        }
        else if(view.getId() == R.id.imageButton2){
            Log.d("Tag", "button2");
            new AlertDialog.Builder(this)
                    .setTitle("종료")
                    .setMessage("정말로 종료하시겠습니까?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .create()
                    .show();

        }
    }
}