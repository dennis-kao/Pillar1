package james.mosley.com.pillar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class MedicationListItemViewHolder extends RecyclerView.ViewHolder {
    TextView time;
    TextView name;
    TextView amount;

    MedicationListItemViewHolder(View v) {
        super(v);
        //grabs the textviews out of the XML and puts them on class properities
        time = v.findViewById(R.id.time);
        name = v.findViewById(R.id.name);
        amount = v.findViewById(R.id.amount);
    }
}
