package net.njsharpe.netclient.dto.model.version;

import lombok.Getter;
import net.njsharpe.netclient.dto.File;
import net.njsharpe.netclient.dto.image.Image;
import net.njsharpe.netclient.dto.model.*;

import java.util.Date;

@Getter
public class ModelVersion {

    private int id;
    private int modelId;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private String[] trainedWords;
    private String trainingStatus;
    private String trainingDetails;
    private String baseModel;
    private String baseModelType;
    private long earlyAccessTimeFrame;
    private String description;
    private Statistics stats;
    private Model model;
    private File[] files;
    private Image[] images;
    private String downloadUrl;

    @Getter
    public class Model {

        private String name;
        private Type type;
        private boolean nsfw;
        private boolean poi;

    }

    @Getter
    public class Statistics {

        private int downloadCount;
        private int ratingCount;
        private float rating;

    }

}
