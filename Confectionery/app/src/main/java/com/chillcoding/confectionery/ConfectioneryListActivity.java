package com.chillcoding.confectionery;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by macha on 22/09/16.
 */
public class ConfectioneryListActivity extends ListActivity {
    String [] confectioneryArray = {"Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb","Ice Cream Sandwich","Jelly Bean","KitKat","Lollipop","Marshmallow","Nougat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_confectionery);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,confectioneryArray);

        setListAdapter(adapter);
    }

}
