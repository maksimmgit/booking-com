package com.booking.ui.testSource;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DetailsPageSourse implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        String name = "Peter" + RandomString.randomString(5);
        return Stream.of(
                Arguments.of(name, "24", "12", "1945", "24/12/1945")
        );
    }
}
