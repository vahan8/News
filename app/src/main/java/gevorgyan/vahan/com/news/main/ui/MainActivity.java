package gevorgyan.vahan.com.news.main.ui;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import gevorgyan.vahan.com.news.R;
import gevorgyan.vahan.com.news.main.ui.articles.ArticlesFragment;
import gevorgyan.vahan.com.news.main.ui.saved.SavedArticlesFragment;

public class MainActivity extends AppCompatActivity {

    private int current_navigation_item_id = R.id.navigation_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ArticlesFragment.newInstance())
                    .commitNow();
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() != current_navigation_item_id) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            current_navigation_item_id = R.id.navigation_home;
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, ArticlesFragment.newInstance()).commitNow();
                            return true;
                        case R.id.navigation_saved:
                            current_navigation_item_id = R.id.navigation_saved;
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, SavedArticlesFragment.newInstance()).commitNow();
                            return true;
                    }
                }
                current_navigation_item_id = item.getItemId();
                return false;

            }
        });

    }
}
