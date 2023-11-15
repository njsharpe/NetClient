package net.njsharpe.netclient;

import net.njsharpe.netclient.http.Returns;
import net.njsharpe.netclient.http.ReturnsVoid;

import java.net.URI;

public interface Client {

    URI getBaseAddress();
    <U, T extends Returns<U>> U send(Class<T> clazz, T request);
    <T extends ReturnsVoid> void send(Class<T> clazz, T request);

}
