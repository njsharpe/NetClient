package net.njsharpe.netclient.dto;

import com.google.gson.annotations.SerializedName;

public enum Nsfw {

    @SerializedName("None")
    NONE,
    @SerializedName("Soft")
    SOFT,
    @SerializedName("Mature")
    MATURE,
    @SerializedName("X")
    X

}
