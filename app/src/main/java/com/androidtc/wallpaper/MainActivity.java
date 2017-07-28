package com.androidtc.wallpaper;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.GridView1);
        gridView.setAdapter(new ImageAdapter(this));
        registerForContextMenu(gridView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo cmi = ( AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.add(1, cmi.position, 0, "Set as Wallpaper");
        menu.add(2, cmi.position, 0, "View image");
    }

    @Override
    public void onCreateContextItemSelected(MenuItem item){
        GridView g = (GridView) findViewById(R.id.GridView1);
        Integer resourcedId = (Integer) g.getItemAtPosition (item.getItemId());
            switch (item.getGroupId()) {
                case 1:
                    final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                    try {
                        wallpaperManager.setResource (resourcedId);
                        Toast.makeText(getAplicationContext(), "Your wallpaper has been changed!!", Toast.LENGTH_LONG).show();
                    }
                    
            }
    }

}
