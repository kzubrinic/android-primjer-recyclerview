package hr.unidu.kz.pokemoni_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MojAdapterListaActivity extends AppCompatActivity {

    private List<Pokemon> pokemoniObj = new ArrayList<>(25);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context c = this;
        Intent intent = getIntent();
        // parametar je lista stringova
        List<String> values = Arrays.asList("Abra", "Absol", "Alakazam", "Arbok", "Arcanine", "Articuno", "Bagon", "Bayleef", "Beedrill", "Bellossom", "Bellsprout", "Blastoise", "Blaziken", "Breloom", "Bulbasaur", "Buneary", "Butterfree", "Cacnea", "Cacturne", "Camerupt", "Caterpie", "Celebi", "Charizard", "Charmander", "Charmeleon");
        napuniPolje(values);

        setContentView(R.layout.activity_moj_adapter_lista);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        MojAdapterListaAdapter mAdapter = new MojAdapterListaAdapter(pokemoniObj, c);
        recyclerView.setAdapter(mAdapter);

        setTitle(getTitle() + " - složena");
    }

    private void napuniPolje(List<String> punj){
        String[] vrste = {"Psihički", "Mračni", "Psihički", "Otrovni", "Arcanine", "Vatreni", "Zmaj", "Travnati", "Buba/otrovni", "Travnati", "Travnati/otrovni", "Vodeni", "Vatreni", "Travnati", "Travnati/otrovni", "Normalni", "Leteći", "Travnati", "Travnati/mračni", "Vatreni/zemljani", "Buba", "Travnati/psihički", "Vatreni/leteći", "Vatreni", "Vatreni"};
        for (int i = 0; i < 25; ++i){
            pokemoniObj.add(new Pokemon(punj.get(i), vrste[i]));
        }
    }
}
