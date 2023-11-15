package net.njsharpe.netclient.route;

import net.njsharpe.netclient.http.ReturnsVoid;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.Verb;

@Route(uri = "/http/404", verb = Verb.GET)
public class GetHttpNotFound implements ReturnsVoid {

}
