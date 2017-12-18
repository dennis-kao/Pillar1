package james.mosley.com.pillar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MedicationListAdapter extends RecyclerView.Adapter<MedicationListItemViewHolder> {
    private String[][] data = new String[][]{
            new String[]{"9:30 AM", "Adderall", "2 pills"},
            new String[]{"12:00 PM", "Tylenol", "50 mg"},
            new String[]{"2:00 PM", "Lisinopril", "1 tablet"},
            new String[]{"4:00 PM", "Inhaler", "1 puff"},
            new String[]{"10:00 PM", "Melatonin", "1 g"},
    };

    MedicationListAdapter() {
    }

    @Override
    public MedicationListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // creeates an instance of thee medication list item view holder
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.medication_list_item, parent, false);
        return new MedicationListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MedicationListItemViewHolder holder, int position) {
        // gets the data and sets textfields in the view holder it is provided with
        holder.time.setText(data[position][0]);
        holder.name.setText(data[position][1]);
        holder.amount.setText(data[position][2]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}

