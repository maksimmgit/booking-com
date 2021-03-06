package com.booking.ui.testSource;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class BookingSource implements ArgumentsProvider {
    static RandomString randomString;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("SuperJack", "Maksims", RandomString.randomString(15)+ "@yandex.by", "I would like to have a mountain view room, please.")
        );
    }
}
