
package com.example.musicapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment homeFragment = new HomeFragment();
    Fragment nowPlayingFragment = new NowPlayingFragment();
    Fragment libraryFragment = new LibraryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selected = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    selected = homeFragment;
                    break;
                case R.id.nav_now_playing:
                    selected = nowPlayingFragment;
                    break;
                case R.id.nav_library:
                    selected = libraryFragment;
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selected).commit();
            return true;
        });
    }
}
