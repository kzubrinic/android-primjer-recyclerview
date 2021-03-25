package hr.unidu.kz.pokemoni_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JednostavnaListaAdapter extends RecyclerView.Adapter<JednostavnaListaAdapter.MyViewHolder>{
    private List<String> mDataset;
    private Context con;
    // Prima se referenca na izvor podataka - u ovom slučaju polje stringova
    public JednostavnaListaAdapter(List<String> myDataset, Context c) {
        mDataset = myDataset;
        con = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // stvara se novi view iz standardnog jednostavnog layouta retka
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        // Unutarnja klasa tipa ViewHolder čuva referencu na view
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Kada se korisnik pozicionira na određeni redak sadržaj retka viewa se ažurira
        // podatkom iz dataseta koji se nalazi na istoj poziciji.
        holder.label.setText(mDataset.get(position));
     }

    @Override
    public int getItemCount() {
        return mDataset.size();

    }

    // Unutarnja klasa tipa ViewHolder čuva referencu na view
    // U njoj se obrađuje događaj pritiska/klika na stavku
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView label;
        public MyViewHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(android.R.id.text1);
            // referenca na objekt tipa MyViewHolder se sprema kao tag elementa liste
            itemView.setTag(this);
            // registrira se listener
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // vrati poziciju na koju je korisnik kliknuo
            int pos = getAdapterPosition();
            notifyDataSetChanged();

            // Dohvat podataka iz adaptera
            // Check if an item was deleted, but the user clicked it before the UI removed it
            if (pos != RecyclerView.NO_POSITION) {
                // Dohvaća se podatak iz dataseta koji se nalazi na poziciji kliknutog retka liste
                String pok = mDataset.get(pos);
                Toast.makeText(con, pok, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
