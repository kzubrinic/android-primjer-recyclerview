package hr.unidu.kz.pokemoni_recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MojAdapterListaAdapter extends RecyclerView.Adapter<MojAdapterListaAdapter.MyViewHolder>{
    private final Pokemon[] mDataset;
    private Context con;

    public MojAdapterListaAdapter(Pokemon[] myDataset, Context con) {
        mDataset = myDataset;
        this.con = con;
    }
    // Referenca se popunjava referencom na callback metodu

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.moj_redak_liste_slozeni, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.label.setText(mDataset[position].getIme());
        holder.vrsta.setText(mDataset[position].getVrsta());
        String uri = "@drawable/" + mDataset[position].getSlika();
        int imageResource = con.getResources().getIdentifier(uri, null, con.getPackageName());
        Drawable res = con.getResources().getDrawable(imageResource);
        holder.slika.setImageDrawable(res);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView label;
        public TextView vrsta;
        public ImageView slika;
        public MyViewHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.label);
            vrsta = itemView.findViewById(R.id.vrsta);
            slika = itemView.findViewById(R.id.icon);
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
                String pok = mDataset[pos].getIme();
                // We can access the data within the views
                Toast.makeText(con, pok, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
