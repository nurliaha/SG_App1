package com.nurliah.sg_app1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class USer implements Parcelable {
    public String nama,gender;
    public int id, umur;

//    Nama table
    public static final String TABLE = "User";
//    Atribut Table
    public static final String KEY_ID = "id";
    public static final String KEY_nama = "nama";
    public static final String KEY_umur = "umur";
    public static final String KEY_gender = "gender";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(this.nama);
        dest.writeString(this.gender);
        dest.writeInt(this.umur);
    }

    public USer() {
    }

    protected USer(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
        this.gender = in.readString();
        this.umur = in.readInt();
    }

    public static final Parcelable.Creator<USer> CREATOR = new Parcelable.Creator<USer>() {
        @Override
        public USer createFromParcel(Parcel source) {
            return new USer(source);
        }

        @Override
        public USer[] newArray(int size) {
            return new USer[size];
        }
    };
}
