package net.njsharpe.netclient.dto.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Hashes {

    @SerializedName("AutoV1")
    private String autoV1;
    @SerializedName("AutoV2")
    private String autoV2;
    @SerializedName("SHA256")
    private String sha256;
    @SerializedName("CRC32")
    private String crc32;
    @SerializedName("BLAKE3")
    private String blake3;

}