package sg.edu.np.mad.practical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    ImageView picView;
    TextView nameView, desView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        picView = itemView.findViewById(R.id.userPicView);
        nameView = itemView.findViewById(R.id.userNameView);
        desView = itemView.findViewById(R.id.userDesView);
    }
}
