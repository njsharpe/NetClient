package net.njsharpe.netclient.http;

public interface Returns<T> extends Response {

    Class<T> getType();

}
