package com.example.tmnt.planbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int pro = 15;
    int height;
    int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PlanBar planBar = (PlanBar) findViewById(R.id.test);
        Button btn = (Button) findViewById(R.id.btn);

        ViewTreeObserver vto = planBar.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                height = planBar.getMeasuredHeight();
                width = planBar.getMeasuredWidth();
                return true;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //planBar.update(25, 500);
                if (pro <= width / 3 * 2) {
                    planBar.update(pro);
                    pro += 15;
                }
            }
        });
    }
}
