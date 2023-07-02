package com.example.contextualactionmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ActionMode mActionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar  = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView txtView = findViewById(R.id.txtView);
        txtView.setOnLongClickListener(view->showActionMode());

        // dont forget to change background on floating context see. (themes.xml)
    }

    private boolean showActionMode(){
        if(mActionMode != null) return false;
        mActionMode = startSupportActionMode(this.callback);
        return true;
    }

    private final ActionMode.Callback callback = new ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.example_menu, menu);
            actionMode.setTitle("Choose Option");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if(menuItem.getItemId() == R.id.delete){
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                actionMode.finish();
                return true;
            }
            if(menuItem.getItemId() == R.id.share){
                Toast.makeText(MainActivity.this, "Shared", Toast.LENGTH_SHORT).show();
                actionMode.finish();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            mActionMode = null;
        }
    };
}