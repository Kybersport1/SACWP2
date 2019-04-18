package com.example.sacwp.recycler_p_list;

import android.os.Parcel;
import android.os.Parcelable;

public class RecyclerItem_p implements Parcelable {
    private String city;
    private String coment;

    public RecyclerItem_p(String city, String coment) {
        this.city = city;
        this.coment = coment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.city);
        dest.writeString(this.coment);
    }

    protected RecyclerItem_p(Parcel in) {
        this.city = in.readString();
        this.coment = in.readString();
    }

    public static final Parcelable.Creator<RecyclerItem_p> CREATOR = new Parcelable.Creator<RecyclerItem_p>() {
        @Override
        public RecyclerItem_p createFromParcel(Parcel source) {
            return new RecyclerItem_p(source);
        }

        @Override
        public RecyclerItem_p[] newArray(int size) {
            return new RecyclerItem_p[size];
        }
    };
}
