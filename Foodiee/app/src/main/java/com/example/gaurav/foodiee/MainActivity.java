package com.example.gaurav.foodiee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Restro> restros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = (ListView) findViewById(R.id.listView);
        //list.setCacheColorHint(getResources().getColor(R.color.transparent));
        restros = new ArrayList<>();

        restros.add(new Restro("Burger-King", R.drawable.burger_king, "HAVE IT YOUR WAY"));
        restros.add(new Restro("Chillis", R.drawable.chillis, "LICENSE TO GRILL"));
        restros.add(new Restro("Cooper", R.drawable.cooper,"LOVE THE TASTE"));
        restros.add(new Restro("KFC",R.drawable.kfc,"FINGER LICKIN’ GOOD"));
        restros.add(new Restro("Dominos", R.drawable.dominos,"PIZZA DELIVER EXPERTS"));
        restros.add(new Restro("McDonalds", R.drawable.mcd,"I’M LOVIN’ IT"));
        restros.add(new Restro("Paprika", R.drawable.paprika,"THE TASTE FROM SPACE"));
        restros.add(new Restro("Pizza", R.drawable.pizza,"JUST VOW"));
        restros.add(new Restro("Pizza-Hut", R.drawable.pizza_hut,"MAKE IT GREAT"));
        restros.add(new Restro("Rositto", R.drawable.risotto,"YOU CAN'T EAT IT JUST ONE"));
        restros.add(new Restro("Subway", R.drawable.subway,"EAT FRESH"));
        restros.add(new Restro("Hardees", R.drawable.hardees,"WHERE THE FOOD’S THE STAR"));
        restros.add(new Restro("Taco Bell", R.drawable.taco_bell, "THINK OUTSIDE THE BUN"));
        restros.add(new Restro("Dominos", R.drawable.dominos,"PIZZA DELIVER EXPERTS" ));
        restros.add(new Restro("McDonalds", R.drawable.mcd,"I’M LOVIN’ IT"));
        restros.add(new Restro("Paprika", R.drawable.paprika, "THE TASTE FROM SPACE"));
        restros.add(new Restro("Pizza", R.drawable.pizza,"JUST VOW"));



        MyAdapter adapter = new MyAdapter(this, restros);

        list.setAdapter(adapter);

    }
}
