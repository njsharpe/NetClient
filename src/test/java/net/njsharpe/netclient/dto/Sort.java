package net.njsharpe.netclient.dto;

import com.google.gson.annotations.SerializedName;

public class Sort {

    public enum Image {

        @SerializedName("Most Reactions")
        MOST_REACTIONS,
        @SerializedName("Most Comments")
        MOST_COMMENTS,
        @SerializedName("Newest")
        NEWEST

    }

    public enum Model {

        @SerializedName("Highest Rated")
        HIGHEST_RATED,
        @SerializedName("Most Downloaded")
        MOST_DOWNLOADED,
        @SerializedName("Newest")
        NEWEST

    }

}
