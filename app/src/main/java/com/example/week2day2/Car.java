package com.example.week2day2;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {

    private String make;
    private String model;
    private String year;
    private String titleStatus;
    private String color;
    private String engine;
    private String transmission;

    public Car(Parcel in) {
        this.make = in.readString();
        this.model = in.readString();
        this.year = in.readString();
        this.titleStatus = in.readString();
        this.color = in.readString();
        this.engine = in.readString();
        this.transmission = in.readString();
    }

    public Car(String make, String model, String year, String titleStatus, String color, String engine, String transmission) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.titleStatus = titleStatus;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitleStatus() {
        return titleStatus;
    }

    public void setTitleStatus(String titleStatus) {
        this.titleStatus = titleStatus;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(year);
        dest.writeString(titleStatus);
        dest.writeString(color);
        dest.writeString(engine);
        dest.writeString(transmission);
    }
}
