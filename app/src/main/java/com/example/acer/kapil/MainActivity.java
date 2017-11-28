package com.example.acer.kapil;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SearchEvent;

public class MainActivity extends AppCompatActivity  {
           int count=3;
    Context c;
    SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            c=this;

    }

   public void hii()
   { ViewPager viewPager =(ViewPager)findViewById(R.id.viewPager);
       viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));}

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
             ProductsDatabase productsDatabase=new ProductsDatabase(c);
            if(position==0)
            {MedicineFragment medicineFragment=new MedicineFragment();

                return  medicineFragment.newInstance(productsDatabase.getAllMedicines(),searchView);}
            else if(position==1)
                return  GroceryFragment.newInstance(productsDatabase.getAllGrocery());
            else{
                return DisposablesFragment.newInstance(productsDatabase.getAllDisposables());
            }

        }

        @Override
        public int getCount() {
            return count;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.
                getSearchableInfo(getComponentName()));
        MenuItemCompat.setOnActionExpandListener(searchMenuItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Intent i=new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);
                return true;
            }
        });
        searchView.setSubmitButtonEnabled(true);

         hii();
        return true;

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


        }

        return super.onOptionsItemSelected(item);
    }




}
