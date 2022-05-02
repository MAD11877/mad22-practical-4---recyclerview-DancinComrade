package sg.edu.np.mad.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView avatarView = (ImageView) findViewById(R.id.avatarView);
        avatarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                    // Get random positive integer only
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Random random = new Random();
                        int randInt = random.nextInt(999999999);
                        Intent mainActivity = new Intent(ListActivity.this, MainActivity.class);
                        mainActivity.putExtra("randInt", randInt);
                        startActivity(mainActivity);
                    }
                });

                AlertDialog madnessAlert = builder.create();
                madnessAlert.show();
            }
        });
    }
}