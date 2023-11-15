package net.njsharpe.netclient.route;

import net.njsharpe.netclient.annotation.Authed;
import net.njsharpe.netclient.annotation.Member;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.*;
import net.njsharpe.netclient.dto.Period;
import net.njsharpe.netclient.dto.Sort;
import net.njsharpe.netclient.dto.model.Models;
import net.njsharpe.netclient.dto.model.CommercialUse;
import net.njsharpe.netclient.dto.model.Type;

@Route(uri = "/api/v1/models", verb = Verb.GET)
public class FindModels implements Returns<Models> {

    @Member
    protected int limit;

    @Member
    protected int page;

    @Member
    protected String query;

    @Member
    protected String tag;

    @Member
    protected String username;

    @Member
    protected Type[] types;

    @Member
    protected Sort.Model sort;

    @Member
    protected Period period;

    @Member
    protected int rating;

    @Member
    @Authed
    protected boolean favorites;

    @Member
    @Authed
    protected boolean hidden;

    @Member
    protected boolean primaryFileOnly;

    @Member
    protected boolean allowNoCredit;

    @Member
    protected boolean allowDerivatives;

    @Member
    protected boolean allowDifferentLicenses;

    @Member
    protected CommercialUse allowCommercialUse;

    @Member
    protected boolean nsfw;

    @Override
    public Class<Models> getType() {
        return Models.class;
    }

}
