package com.example.contactwithrecyclerandcardview;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewId);

        preferences = this.getSharedPreferences("My_Pref",MODE_PRIVATE);
        getNames();
    }

    private void getNames() {
        ArrayList<Model> models = new ArrayList<>();
        Model m = new Model();

        m.setTitle("Mahbubur Rahman");
        m.setNumber("01992376452");
        m.setImage(R.drawable.sir);
        models.add(m);

        m=new Model();
        m.setTitle("Monir Hossain");
        m.setNumber("01993422911");
        m.setImage(R.drawable.noyon);
        models.add(m);

        m=new Model();
        m.setTitle("Munim Hossain");
        m.setNumber("01734652876");
        m.setImage(R.drawable.munim);
        models.add(m);

        m=new Model();
        m.setTitle("Julshan Alam Ratu");
        m.setNumber("01345982387");
        m.setImage(R.drawable.ratu);
        models.add(m);

        m=new Model();
        m.setTitle("Shohanur Rahman");
        m.setNumber("01776342251");
        m.setImage(R.drawable.shohan);
        models.add(m);

        String sorting = preferences.getString("Sort","ascending");

        if (sorting.equals("ascending"))
        {
            Collections.sort(models, Model.BY_TITLE_ASCENDING);
        }
        else if (sorting.equals("descending"))
        {
            Collections.sort(models, Model.BY_TITLE_DESCENDING);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(models,this);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.sorting)
        {
            showDialogue();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialogue() {
        String[] options = {"Ascending","Descending"};

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Select Options");
        alert.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i==0)
                {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Sort","ascending");
                    editor.apply();
                    getNames();
                }
               if (i==1)
                {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Sort","descending");
                    editor.apply();
                    getNames();
                }

            }
        });
        alert.show();

    }
}
