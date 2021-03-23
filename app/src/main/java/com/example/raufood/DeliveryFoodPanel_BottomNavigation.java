package com.example.raufood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.raufood.deliveryFoodPanel.DeliveryPendingOrderFragment;
import com.example.raufood.deliveryFoodPanel.DeliveryShipOrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DeliveryFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_food_panel__bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.delivery_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
//        String name = getIntent().getStringExtra("PAGE");
//        if (name!=null){
//            if (name.equalsIgnoreCase("DeliveryOrderpage")){
//                loaddeliveryfragment(new DeliveryPendingOrderFragment());
//            }
//        }else {
//            loaddeliveryfragment(new DeliveryPendingOrderFragment());
//        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.shiporders:
                fragment=new DeliveryShipOrderFragment();
                break;
        }
        switch (item.getItemId()){
            case R.id.pendingorders:
                fragment=new DeliveryPendingOrderFragment();
                break;
        }
        return loaddeliveryfragment(fragment);
    }

    private boolean loaddeliveryfragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }
}