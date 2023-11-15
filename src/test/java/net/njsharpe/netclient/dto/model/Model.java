package net.njsharpe.netclient.dto.model;

import lombok.Getter;
import net.njsharpe.netclient.dto.creator.Creator;
import net.njsharpe.netclient.dto.model.version.ModelVersion;

@Getter
public class Model {

    private int id;
    private String name;
    private String description;
    private Type type;
    private boolean poi;
    private boolean nsfw;
    private boolean allowNoCredit;
    private CommercialUse allowCommercialUse;
    private boolean allowDerivatives;
    private boolean allowDifferentLicenses;
    private Statistics stats;
    private Creator creator;
    private String[] tags;
    private ModelVersion[] modelVersions;

    @Getter
    public class Statistics {

        private int downloadCount;
        private int favoriteCount;
        private int commentCount;
        private int ratingCount;
        private float rating;

    }

}