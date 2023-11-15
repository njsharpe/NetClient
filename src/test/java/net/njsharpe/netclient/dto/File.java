package net.njsharpe.netclient.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import net.njsharpe.netclient.dto.model.*;

import java.util.Date;

@Getter
public class File {

    private int id;
    @SerializedName("sizeKB")
    private double sizeKb;
    private String name;
    private Type type;
    private Metadata metadata;
    private String pickleScanResult;
    private String pickleScanMessage;
    private String virusScanResult;
    private String virusScanMessage;
    private Date scannedAt;
    private Hashes hashes;
    private String downloadUrl;
    private boolean primary;

    @Getter
    public class Metadata {

        private Precision fp;
        private Size size;
        private FileFormat format;

    }

}
