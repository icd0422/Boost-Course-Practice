package com.example.boostcoursepractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("장주느", "010-5212-7024", R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("장주느1", "010-52024", R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("장주느2", "010-51-7024", R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("장주느3", "0-5-7024", R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("장주4", "010-59-7024", R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("장주5", "-52 -7024", R.drawable.ic_launcher_background));

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem) adapter.getItem(i);
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_LONG).show();
            }
        });



    }

    class SingerAdapter extends BaseAdapter
    {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>() ;

        public void addItem(SingerItem item)
        {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            SingerItemView singerItemView = null ;

            if(view == null)
            {
                singerItemView = new SingerItemView(getApplicationContext());
            }
            else
            {
                singerItemView = (SingerItemView) view;
            }

            SingerItem item = items.get(i) ;
            singerItemView.setName(item.getName());
            singerItemView.setMobile(item.getMobile());
            singerItemView.setImg(item.getResID());

            return singerItemView;
        }
    }
}
