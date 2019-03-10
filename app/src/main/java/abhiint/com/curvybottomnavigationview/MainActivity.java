package abhiint.com.curvybottomnavigationview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomBottomNavigationView curvedBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        curvedBottomNavigationView.inflateMenu(R.menu.bottom_navigation_item);
    }
}
