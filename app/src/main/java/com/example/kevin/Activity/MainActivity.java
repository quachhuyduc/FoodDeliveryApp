package com.example.kevin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kevin.Adaptor.CategoryAdaptor;
import com.example.kevin.Adaptor.PoplurarAdaptor;
import com.example.kevin.Domain.CategoryDomain;
import com.example.kevin.Domain.FoodDomain;
import com.example.kevin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPopular();
        recyclerViewCategory();
        bottomNavigation();

    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton =findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
    }
    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);


        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter= new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recyclerView3);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);


        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza", "pop_1" ,"slices pepperoni,mozzerella cheese,fresh oregano,ground black pepper,pizza sauce",9.76));
        foodlist.add(new FoodDomain("Cheese Burger","pop_2","beef,Gouda Cheese, Special Sauce, Lettuce,tomato", 8.79));
        foodlist.add(new FoodDomain("Vegetable Pizza" , "pop_3","olive oil, Vegetable oil,pitted kalamata,cherry tomatoes,fresh oregano,basil",8.5));

        adapter2 = new PoplurarAdaptor(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}