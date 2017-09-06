package app.dgandroid.eu.mycityforecast.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by Duilio on 05/09/2017.
 */

public class Temperature implements Serializable {

    @SerializedName("min")
    private float min;
    @SerializedName("max")
    private float max;
    @SerializedName("morn")
    private float morn;
    @SerializedName("eve")
    private float eve;
    @SerializedName("night")
    private float night;
    @SerializedName("day")
    private float day;

    public Temperature(float min, float max, float day, float morn, float eve, float night) {
        this.min        = min;
        this.max        = max;
        this.day        = day;
        this.morn       = morn;
        this.eve        = eve;
        this.night      = night;
    }

    public float getMax() {
        return max;
    }

    public float getMin() {
        return min;
    }

    public float getDay() {
        return day;
    }

    public float getEve() {
        return eve;
    }

    public float getMorn() {
        return morn;
    }

    public float getNight() {
        return night;
    }
}