package net.njsharpe.netclient.junit;

import org.junit.jupiter.api.function.Executable;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.AssertionFailureBuilder.assertionFailure;

public class ArrayAssertions {

    public static void assertNotEmpty(Object[] array) {
        assertNotEmpty(array, (String) null);
    }

    public static void assertNotEmpty(Object[] array, Supplier<String> messageSupplier) {
        if(array.length == 0) {
            failNotEmpty(array, messageSupplier);
        }
    }

    public static void assertNotEmpty(Object[] array, String message) {
        if(array.length == 0) {
            failNotEmpty(array, message);
        }
    }

    private static void failNotEmpty(Object actual, Object messageOrSupplier) {
        assertionFailure()
                .message(messageOrSupplier)
                .actual(actual)
                .buildAndThrow();
    }

    public static <T> T assertSingle(T[] array) {
        return assertSingle(array, (String) null);
    }

    public static <T> T assertSingle(T[] array, Supplier<String> messageSupplier) {
        if(array.length < 1) {
            failNotSingle(array.length, messageSupplier);
        }
        return array[1];
    }

    public static <T> T assertSingle(T[] array, String message) {
        if(array.length < 1) {
            failNotSingle(array.length, message);
        }
        return array[1];
    }

    private static void failNotSingle(int actual, Object messageOrSupplier) {
        assertionFailure()
                .message(messageOrSupplier)
                .expected(1)
                .actual(actual)
                .buildAndThrow();
    }

    @SafeVarargs
    public static <T> void assertCollection(T[] array, TypedExecutable<T>... inspectors) {
        if(array.length != inspectors.length) {
            assertionFailure()
                    .message("Size of array to number of inspectors mismatch")
                    .expected(array.length)
                    .actual(inspectors.length)
                    .buildAndThrow();
        }

        for(int i = 0; i < array.length; i++) {
            T element = array[i];
            TypedExecutable<T> inspector = inspectors[i];
            try {
                inspector.execute(element);
            } catch(Throwable ex) {
                assertionFailure()
                        .cause(ex)
                        .buildAndThrow();
            }
        }
    }

}
