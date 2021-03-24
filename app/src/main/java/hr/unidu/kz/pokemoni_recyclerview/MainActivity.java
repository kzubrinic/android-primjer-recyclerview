package hr.unidu.kz.pokemoni_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void jednostavna(View v) {
        Intent intent = new Intent(this, JednostavnaListaActivity.class);
        startActivity(intent);
    }

    public void vlastitiAdapter(View v) {
        Intent intent = new Intent(this, MojAdapterListaActivity.class);
        startActivity(intent);
    }
}
