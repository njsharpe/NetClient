package net.njsharpe.netclient.junit;

import org.apiguardian.api.API;

@FunctionalInterface
@API(status = API.Status.STABLE, since = "5.0")
public interface TypedExecutable<T> {

    void execute(T t) throws Throwable;

}
