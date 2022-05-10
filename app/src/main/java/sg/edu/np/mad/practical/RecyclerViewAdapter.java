package sg.edu.np.mad.practical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    ArrayList<User> userModels;

    public RecyclerViewAdapter(ArrayList<User> userModels) {
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Assign individual values to the name and description
        // Get specific user object from list based on its position in RecyclerView
        holder.nameView.setText("Name: " + userModels.get(position).Name);
        holder.desView.setText("Description: " + userModels.get(position).Description);

        // Since position is here, put the onClickListener() here
        holder.picView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userModels.get(holder.getAdapterPosition()).Name;
                if (Integer.parseInt(String.valueOf(userName.charAt(userName.length()-1))) == 7) {
                    LinearLayout pictureLayout = new LinearLayout(view.getContext());
                    pictureLayout.layout(0, 0, 100, 0);
                    pictureLayout.setLayoutParams(new LinearLayout.LayoutParams(1000, 60));
                    pictureLayout.setOrientation(LinearLayout.HORIZONTAL);
                    ((ViewGroup) view).addView(pictureLayout);
                    ImageView myImage = new ImageView(view.getContext());
                    myImage.setImageResource(R.drawable.ic_android_black_24dp);
                    pictureLayout.addView(myImage);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                    builder.setTitle("Profile");
                    builder.setMessage("Name: " + userModels.get(holder.getAdapterPosition()).Name);
                    builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Bundle extras = new Bundle();
                            extras.putString("Name", userModels.get(holder.getAdapterPosition()).Name);
                            extras.putString("Des", userModels.get(holder.getAdapterPosition()).Description);

                            Intent mainActivity = new Intent(view.getContext(), MainActivity.class);
                            mainActivity.putExtras(extras);
                            view.getContext().startActivity(mainActivity);
                        }
                    });

                    AlertDialog madnessAlert = builder.create();
                    madnessAlert.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // to know the number of items to display (from the list size)
        return userModels.size();
    }
}
