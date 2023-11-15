package net.njsharpe.netclient.route;

import net.njsharpe.netclient.annotation.Member;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.*;
import net.njsharpe.netclient.dto.model.Model;

@Route(uri = "/api/v1/models/{modelId}", verb = Verb.GET)
public class GetModel implements Returns<Model> {

    @Member(required = true, parameter = Parameter.PATH)
    protected int modelId;

    @Override
    public Class<Model> getType() {
        return Model.class;
    }

}
