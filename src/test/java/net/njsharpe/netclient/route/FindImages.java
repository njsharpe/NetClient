package net.njsharpe.netclient.route;

import net.njsharpe.netclient.annotation.Member;
import net.njsharpe.netclient.http.Returns;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.Verb;
import net.njsharpe.netclient.dto.Nsfw;
import net.njsharpe.netclient.dto.Period;
import net.njsharpe.netclient.dto.Sort;
import net.njsharpe.netclient.dto.image.Images;

@Route(uri = "/api/v1/images", verb = Verb.GET)
public class FindImages implements Returns<Images> {

    @Member
    protected int limit;

    @Member
    protected int postId;

    @Member
    protected int modelId;

    @Member
    protected int modelVersionId;

    @Member
    protected String username;

    @Member
    protected Nsfw nsfw;

    @Member
    protected Sort.Image sort;

    @Member
    protected Period period;

    @Member
    protected int page;

    @Override
    public Class<Images> getType() {
        return Images.class;
    }

}
