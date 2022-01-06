package com.example.seryozniy_tema.Modul;

import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable {
    int id;
    String name;

    public Member(int id, String name){
        this.id = id;
        this.name = name;
    }


    protected Member(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
