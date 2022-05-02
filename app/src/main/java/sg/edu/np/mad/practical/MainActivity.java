package sg.edu.np.mad.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.fllwButton);
        User userObj = new User();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userObj.Followed) {
                    userObj.Followed = false;
                    btn.setText("FOLLOW");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();

                }
                else {
                    userObj.Followed = true;
                    btn.setText("UNFOLLOW");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Get random integer from ListActivity
        TextView helloView = (TextView) findViewById(R.id.helloView);
        int randInt = getIntent().getIntExtra("randInt", 0);
        helloView.setText("MAD" + " " + randInt);

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