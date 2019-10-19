package id.ac.poliban.mi.sultan.prj04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private List<String> data = new ArrayList<>();

    {
        data.add("Banjarmasin");
        data.add("Palangkaraya");
        data.add("Samarinda");
        data.add("Pontianak");
        data.add("Tarakan");
        data.add("Bandung");
        data.add("Surabaya");
        data.add("Jogjakarta");
        data.add("Malang");
        data.add("Bali");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) getSupportActionBar().setTitle("Demo Simple List View");

        ListView lv = findViewById(R.id.lvItem);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((adapterView, view, i, l) ->{
            Toast.makeText(this, "You Choosed", Toast.LENGTH_SHORT).show();
        } );

        lv.setOnItemLongClickListener((adapterView, view, i, l) ->{
            data.remove(i);
            adapter.notifyDataSetChanged();
            return true;
        } );
    }
}
