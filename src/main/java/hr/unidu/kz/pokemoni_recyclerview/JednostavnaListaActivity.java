package hr.unidu.kz.pokemoni_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class JednostavnaListaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JednostavnaListaAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context c = this;
        Intent intent = getIntent();
        // parametar je polje stringova
        final String[] values = intent.getStringArrayExtra("punjenje");

        setContentView(R.layout.activity_jednostavna_lista);
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
        mAdapter = new JednostavnaListaAdapter(values, this);


        recyclerView.setAdapter(mAdapter);

        setTitle(getTitle() + " - jednostavna");
    }

}
