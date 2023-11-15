package net.njsharpe.netclient.dto.model;

import com.google.gson.annotations.SerializedName;

public enum CommercialUse {

    @SerializedName("None")
    NONE,
    @SerializedName("Image")
    IMAGE,
    @SerializedName("Rent")
    RENT,
    @SerializedName("Sell")
    SELL

}