package com.example.acer.kapil;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by acer on 24.11.2017.
 */

public class CustomDialog extends Dialog  implements
        android.view.View.OnClickListener {
    EditText name;
    RadioGroup typegroup;
    RadioGroup typecategory;
    Button ok;
    String objecttype;
    EditText cost;
    EditText sell;
    EditText pieces;
    public CustomDialog(@NonNull Context context,String objecttype) {
        super(context);
        this.objecttype=objecttype;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.customalert);
        name=(EditText)findViewById(R.id.itemname);
        typegroup=(RadioGroup)findViewById(R.id.typegroup);
        typecategory=(RadioGroup)findViewById(R.id.typecategory);
        ok=(Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        cost=(EditText)findViewById(R.id.itemcost);
        sell=(EditText)findViewById(R.id.itemsell);
        pieces=(EditText)findViewById(R.id.pieces);}

    @Override
    public void onClick(View v) {


        String item=  name.getText().toString();
        String costprice=  cost.getText().toString();
        Float cost= Float.parseFloat(costprice);
        String sellingprice=  sell.getText().toString();
        Float sell= Float.parseFloat(sellingprice);
        String piece=pieces.getText().toString();
        int piece_box=Integer.parseInt(piece);

        String type;
            ProductsDatabase productsDatabase=new ProductsDatabase(getContext());
        if(typegroup.getCheckedRadioButtonId()==R.id.count){
            type="count";
        }
        else{
            type="weight";
        }

         if(objecttype=="fragmentlayout")
         {
             MedicineList medicineList=new MedicineList(item,type,cost,sell,piece_box);
             productsDatabase.insertMedicine(medicineList);

         }
        else if(objecttype=="disposables")
         {
             DisposableList disposableList=new DisposableList(item,type,cost,sell,piece_box);
             productsDatabase.insertDisposables(disposableList);

         }
        else{
             GroceryList groceryList=new GroceryList(item,type,cost,sell,piece_box);
             productsDatabase.insertGrocery(groceryList);
         }
        dismiss();

    }
}
