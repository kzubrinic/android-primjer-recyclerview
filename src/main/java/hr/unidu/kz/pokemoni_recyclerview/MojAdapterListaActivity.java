package hr.unidu.kz.pokemoni_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MojAdapterListaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MojAdapterListaAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Pokemon[] pokemoniObj = new Pokemon[25];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context c = this;
        Intent intent = getIntent();
        // parametar je polje stringova
        final String[] values = intent.getStringArrayExtra("punjenje");
        napuniPolje(values);

        setContentView(R.layout.activity_moj_adapter_lista);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);



        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MojAdapterListaAdapter(pokemoniObj, c);

        recyclerView.setAdapter(mAdapter);

        setTitle(getTitle() + " - složena");

    }

    private void napuniPolje(String[] punj){
        String[] vrste = {"Psihički", "Mračni", "Psihički", "Otrovni", "Arcanine", "Vatreni", "Zmaj", "Travnati", "Buba/otrovni", "Travnati", "Travnati/otrovni", "Vodeni", "Vatreni", "Travnati", "Travnati/otrovni", "Normalni", "Leteći", "Travnati", "Travnati/mračni", "Vatreni/zemljani", "Buba", "Travnati/psihički", "Vatreni/leteći", "Vatreni", "Vatreni"};
        for (int i = 0; i< 25; ++i){
            pokemoniObj[i] = new Pokemon(punj[i], vrste[i]);
        }
    }
}
