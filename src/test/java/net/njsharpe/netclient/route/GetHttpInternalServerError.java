package net.njsharpe.netclient.route;

import net.njsharpe.netclient.http.Returns;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.Verb;
import net.njsharpe.netclient.dto.MockHttpResponse;

@Route(uri = "/http/500/xP", verb = Verb.GET)
public class GetHttpInternalServerError implements Returns<MockHttpResponse> {

    @Override
    public Class<MockHttpResponse> getType() {
        return MockHttpResponse.class;
    }

}
