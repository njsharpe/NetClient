package net.njsharpe.netclient.dto;

import com.google.gson.annotations.SerializedName;

public enum Period {

    @SerializedName("AllTime")
    ALL_TIME,
    @SerializedName("Year")
    YEAR,
    @SerializedName("Month")
    MONTH,
    @SerializedName("Week")
    WEEK,
    @SerializedName("Day")
    DAY

}