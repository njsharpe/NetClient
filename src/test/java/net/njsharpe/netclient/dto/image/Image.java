package net.njsharpe.netclient.dto.image;

import lombok.Getter;
import net.njsharpe.netclient.dto.Nsfw;

import java.util.Date;

@Getter
public class Image {

    private int id;
    private String url;
    private String hash;
    private int width;
    private int height;
    private boolean nsfw;
    private Nsfw nsfwLevel;
    private Date createdAt;
    private int postId;
    private Statistics stats;
    private String username;
    private String type;
    private Metadata metadata;

    @Getter
    public class Statistics {

        private int cryCount;
        private int laughCount;
        private int likeCount;
        private int heartCount;
        private int commentCount;

    }

    @Getter
    public class Metadata {

        private String hash;
        private int width;
        private int height;

    }

}
