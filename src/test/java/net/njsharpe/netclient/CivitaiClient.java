package net.njsharpe.netclient;

import net.njsharpe.netclient.dto.creator.Creators;
import net.njsharpe.netclient.dto.image.Images;
import net.njsharpe.netclient.dto.model.Model;
import net.njsharpe.netclient.dto.model.Models;
import net.njsharpe.netclient.dto.model.version.ModelVersion;
import net.njsharpe.netclient.dto.tag.Tags;
import net.njsharpe.netclient.route.*;

public class CivitaiClient extends JsonClient {

    public CivitaiClient() {
        this(null);
    }

    public CivitaiClient(String apiKey) {
        super("https://civitai.com", apiKey);
    }

    public Creators findCreators(FindCreators request) {
        return this.send(FindCreators.class, request);
    }

    public Images findImages(FindImages request) {
        return this.send(FindImages.class, request);
    }

    public Models findModels(FindModels request) {
        return this.send(FindModels.class, request);
    }

    public Tags findTags(FindTags request) {
        return this.send(FindTags.class, request);
    }

    public Model getModel(GetModel request) {
        return this.send(GetModel.class, request);
    }

    public ModelVersion getModelVersion(GetModelVersion request) {
        return this.send(GetModelVersion.class, request);
    }

    public ModelVersion getModelVersionByHash(GetModelVersionByHash request) {
        return this.send(GetModelVersionByHash.class, request);
    }

}
