package net.njsharpe.netclient.route;

import net.njsharpe.netclient.annotation.Member;
import net.njsharpe.netclient.http.Returns;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.Verb;
import net.njsharpe.netclient.dto.creator.Creators;

@Route(uri = "/api/v1/creators", verb = Verb.GET)
public class FindCreators implements Returns<Creators> {

    @Member
    protected int limit;

    @Member
    protected int page;

    @Member
    protected String query;

    @Override
    public Class<Creators> getType() {
        return Creators.class;
    }

}
