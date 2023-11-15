package net.njsharpe.netclient.route;

import net.njsharpe.netclient.annotation.Member;
import net.njsharpe.netclient.http.Returns;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.Verb;
import net.njsharpe.netclient.dto.tag.Tags;

@Route(uri = "/api/v1/tags", verb = Verb.GET)
public class FindTags implements Returns<Tags> {

    @Member
    protected int limit;

    @Member
    protected int page;

    @Member
    protected String query;

    @Override
    public Class<Tags> getType() {
        return Tags.class;
    }

}
