package sg.edu.np.mad.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<User> userModels;
    User userObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent fromList = getIntent();
        // If the static list is null, get the generated list from intent (prevent overwrite)
        if (userModels == null) {
            userModels = fromList.getExtras().getParcelableArrayList("currentUsers");
        }

        // Get index of item in list
        int position = fromList.getIntExtra("position",0);
        userObject = userModels.get(position);

        TextView helloView = (TextView) findViewById(R.id.helloView);
        TextView placeholderView = (TextView) findViewById(R.id.placeholderView);
        helloView.setText("Name" + " " + userObject.Name);
        placeholderView.setText("Description" + " " + userObject.Description);

        Button btn = (Button)findViewById(R.id.fllwButton);

        if (userObject.Followed) {
            btn.setText("UNFOLLOW");
        } else {
            btn.setText("FOLLOW");
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userObject.Followed) {
                    userObject.Followed = false;
                    btn.setText("FOLLOW");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();

                }
                else {
                    userObject.Followed = true;
                    btn.setText("UNFOLLOW");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button msgButton = (Button) findViewById(R.id.msgButton);
        msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent msgGrpActivity = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(msgGrpActivity);
            }
        });
    }
}