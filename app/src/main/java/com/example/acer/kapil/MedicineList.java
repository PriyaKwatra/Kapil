package com.example.acer.kapil;

import android.os.Parcel;
import android.os.Parcelable;

public class MedicineList implements Parcelable{

    String name;
    String type;
    float  costprice;
    float sellingprice;
    int pieces;


    public MedicineList(String name, String type, float costprice, float sellingprice, int pieces) {
        this.name = name;
        this.type = type;
        this.costprice = costprice;
        this.sellingprice = sellingprice;
        this.pieces = pieces;
    }

    protected MedicineList(Parcel in) {
        name = in.readString();
        type = in.readString();
        costprice = in.readFloat();
        sellingprice = in.readFloat();
        pieces = in.readInt();
    }

    public static final Creator<MedicineList> CREATOR = new Creator<MedicineList>() {
        @Override
        public MedicineList createFromParcel(Parcel in) {
            return new MedicineList(in);
        }

        @Override
        public MedicineList[] newArray(int size) {
            return new MedicineList[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public float getCostprice() {
        return costprice;
    }

    public float getSellingprice() {
        return sellingprice;
    }

    public int getPieces() {
        return pieces;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCostprice(float costprice) {
        this.costprice = costprice;
    }

    public void setSellingprice(float sellingprice) {
        this.sellingprice = sellingprice;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;

}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeFloat(costprice);
        dest.writeFloat(sellingprice);
        dest.writeInt(pieces);
    }
}
