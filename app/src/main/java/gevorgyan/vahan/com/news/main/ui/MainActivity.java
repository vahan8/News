package gevorgyan.vahan.com.news.main.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import gevorgyan.vahan.com.news.R;
import gevorgyan.vahan.com.news.main.ui.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
