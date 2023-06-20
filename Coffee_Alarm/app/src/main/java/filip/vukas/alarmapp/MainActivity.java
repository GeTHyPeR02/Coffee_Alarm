package filip.vukas.alarmapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button onButton;
    private Button offButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        onButton = findViewById(R.id.on_button);
        offButton = findViewById(R.id.off_button);

        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpHelper rt = new HttpHelper("H");
                rt.start();
            }
        });

        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 HttpHelper rt = new HttpHelper("L");
                 rt.start();
            }
        });
    }
}