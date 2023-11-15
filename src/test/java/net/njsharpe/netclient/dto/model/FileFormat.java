package net.njsharpe.netclient.dto.model;

import com.google.gson.annotations.SerializedName;

public enum FileFormat {

    @SerializedName("SafeTensor")
    SAFETENSOR,
    @SerializedName("PickleTensor")
    PICKLETENSOR,
    @SerializedName("Other")
    OTHER

}