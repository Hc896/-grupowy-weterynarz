package pl.fourtp.groupvet;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View V = getCurrentFocus();
        ListView listView = findViewById(R.id.listviu);

        ArrayList<String> gatunki = new ArrayList<String>();
        gatunki.add("Pies");
        gatunki.add("Kot");
        gatunki.add("Świnka Morska");

        ArrayAdapter<String> arradapt = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,gatunki);
        listView.setAdapter(arradapt);
        listView.setSelector(R.color.mil);

        SeekBar suwak = findViewById(R.id.suwak);
        TextView suwakinfo = findViewById(R.id.suwakinfo);

        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                suwakinfo.setText("Ile ma lat? " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}