package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);
        User userObj = new User();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userObj.Followed) {
                    userObj.Followed = false;
                    btn.setText("FOLLOW");
                }
                else {
                    userObj.Followed = true;
                    btn.setText("UNFOLLOW");

                }
            }
        });
    }
}