package net.njsharpe.netclient.route;

import net.njsharpe.netclient.annotation.Member;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.*;
import net.njsharpe.netclient.dto.model.version.ModelVersion;

@Route(uri = "/api/v1/model-versions/by-hash/{hash}", verb = Verb.GET)
public class GetModelVersionByHash implements Returns<ModelVersion> {

    @Member(required = true, parameter = Parameter.PATH)
    protected String hash;

    @Override
    public Class<ModelVersion> getType() {
        return ModelVersion.class;
    }

}
