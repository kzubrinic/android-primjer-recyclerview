package hr.unidu.kz.pokemoni_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JednostavnaListaAdapter extends RecyclerView.Adapter<JednostavnaListaAdapter.MyViewHolder>{
    private String[] mDataset;
    private Context con;
    // Prima se referenca na izvor podataka - u ovom slučaju polje stringova
    public JednostavnaListaAdapter(String[] myDataset, Context c) {
        mDataset = myDataset;
        con = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // stvara se novi view iz xml layouta retka - moj_redak_liste_jednostavni.xml
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.moj_redak_liste_jednostavni, parent, false);
        // Unutarnja klasa tipa ViewHolder čuva referencu na view
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Kada se korisnik pozicionira na određeni redak odrađuje se - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.label.setText(mDataset[position]);
     }

    @Override
    public int getItemCount() {
        return mDataset.length;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView label;
        public MyViewHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.label);
            // referenca na objekt tipa MyViewHolder se sprema kao tag elementa liste
            itemView.setTag(this);
            // registrira se listener
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            notifyDataSetChanged();

            // Dohvat podataka iz adaptera
            if (pos != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                String pok = mDataset[pos];
                // We can access the data within the views
                Toast.makeText(con, pok, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
