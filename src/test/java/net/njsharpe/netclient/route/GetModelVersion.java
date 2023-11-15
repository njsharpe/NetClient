package net.njsharpe.netclient.route;

import net.njsharpe.netclient.annotation.Member;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.*;
import net.njsharpe.netclient.dto.model.version.ModelVersion;

@Route(uri = "/api/v1/model-versions/{modelVersionId}", verb = Verb.GET)
public class GetModelVersion implements Returns<ModelVersion> {

    @Member(required = true, parameter = Parameter.PATH)
    protected int modelVersionId;

    @Override
    public Class<ModelVersion> getType() {
        return ModelVersion.class;
    }

}
