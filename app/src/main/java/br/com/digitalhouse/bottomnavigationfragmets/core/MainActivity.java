package br.com.digitalhouse.bottomnavigationfragmets.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.digitalhouse.bottomnavigationfragmets.R;
import br.com.digitalhouse.bottomnavigationfragmets.dashboard.DashboardFragment;
import br.com.digitalhouse.bottomnavigationfragmets.home.HomeFragment;
import br.com.digitalhouse.bottomnavigationfragmets.notifications.NotificationsFragment;
import br.com.digitalhouse.bottomnavigationfragmets.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        //fragment for home
                        replaceFragment(new HomeFragment());
                        return true;
                    case R.id.navigation_dashboard:
                        //fragment for dashboard
                        replaceFragment(new DashboardFragment());
                        return true;
                    case R.id.navigation_notifications:
                        //fragment for notifications
                        replaceFragment(new NotificationsFragment());
                        return true;
                    case R.id.navigation_settings:
                        //fragment for settings
                        replaceFragment(new SettingsFragment());
                        return true;
                }
                return false;
            }
        });
        replaceFragment(new HomeFragment());
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }

}
