package com.chillcoding.confectionery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chillcoding.confectionery.adapter.ConfectioneryAdapter;
import com.chillcoding.confectionery.model.AndroidConfectionery;

import java.util.ArrayList;

/**
 * Created by macha on 24/09/16.
 */
public class ConfectioneryCustomListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<AndroidConfectionery> mConfectioneryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mConfectioneryList = new ArrayList<AndroidConfectionery>();

        initList();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ConfectioneryAdapter(mConfectioneryList);

        mRecyclerView.setAdapter(mAdapter);

    }

    private void updateConfectioneryList(ConfectioneryAdapter adapter) {
        adapter.notifyDataSetChanged();
    }

    private void initList() {
        AndroidConfectionery cupcake = new AndroidConfectionery("Cupcake");
        cupcake.setVersionNumber("1.5");
        cupcake.setResourceIdImage(R.drawable.cupcake);

        AndroidConfectionery donut = new AndroidConfectionery("Donut");
        donut.setVersionNumber("1.6");
        donut.setResourceIdImage(R.drawable.donut);

        AndroidConfectionery eclair = new AndroidConfectionery("Eclair");
        eclair.setVersionNumber("2.1");
        eclair.setResourceIdImage(R.drawable.eclair);

        AndroidConfectionery froyo = new AndroidConfectionery("Froyo");
        froyo.setVersionNumber("2.2");
        froyo.setResourceIdImage(R.drawable.froyo);

        AndroidConfectionery gingerbread = new AndroidConfectionery("Gingerbread");
        gingerbread.setVersionNumber("2.3");
        gingerbread.setResourceIdImage(R.drawable.gingerbread);

        AndroidConfectionery honeycomb = new AndroidConfectionery("Honeycomb");
        honeycomb.setVersionNumber("3.0");
        honeycomb.setResourceIdImage(R.drawable.honeycomb);

        AndroidConfectionery iceCreamSandwich = new AndroidConfectionery("Ice Cream Sandwich");
        iceCreamSandwich.setVersionNumber("4.0");
        iceCreamSandwich.setResourceIdImage(R.drawable.icecreamsandwich);

        AndroidConfectionery jellyBean = new AndroidConfectionery("Jelly Bean");
        jellyBean.setVersionNumber("4.1");
        jellyBean.setResourceIdImage(R.drawable.jellybean);

        AndroidConfectionery kitkat = new AndroidConfectionery("KitKat");
        kitkat.setVersionNumber("4.4");
        kitkat.setResourceIdImage(R.drawable.kitkat);

        AndroidConfectionery lollipop = new AndroidConfectionery("Lollipop");
        lollipop.setVersionNumber("5.1");
        lollipop.setResourceIdImage(R.drawable.lollipop);

        AndroidConfectionery marshmallow = new AndroidConfectionery("Marshmallow");
        marshmallow.setVersionNumber("6.0");
        marshmallow.setResourceIdImage(R.drawable.marshmallow);

        AndroidConfectionery nougat = new AndroidConfectionery("Nougat");
        nougat.setVersionNumber("7.0");
        nougat.setResourceIdImage(R.drawable.nougat);

        mConfectioneryList.add(cupcake);
        mConfectioneryList.add(donut);
        mConfectioneryList.add(eclair);
        mConfectioneryList.add(froyo);
        mConfectioneryList.add(gingerbread);
        mConfectioneryList.add(honeycomb);
        mConfectioneryList.add(iceCreamSandwich);
        mConfectioneryList.add(jellyBean);
        mConfectioneryList.add(kitkat);
        mConfectioneryList.add(lollipop);
        mConfectioneryList.add(marshmallow);
        mConfectioneryList.add(nougat);
    }
}
