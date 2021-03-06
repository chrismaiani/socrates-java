package com.github.reducktion.socrates.validator;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.reducktion.socrates.Country;

class IdValidatorTest {

    @ParameterizedTest
    @MethodSource("validatorsForCountries")
    void newInstance_shouldReturnCorrectValidatorForCountry(final Country country, final Class clazz) {
        final IdValidator idValidator = IdValidator.newInstance(country);

        assertThat(idValidator, is(instanceOf(clazz)));
    }

    private static List<Arguments> validatorsForCountries() {
        return Arrays.asList(
            Arguments.arguments(Country.BE, BelgiumIdValidator.class),
            Arguments.arguments(Country.BR, BrazilIdValidator.class),
            Arguments.arguments(Country.CA, CanadaIdValidator.class),
            Arguments.arguments(Country.DE, GermanyIdValidator.class),
            Arguments.arguments(Country.DK, DenmarkIdValidator.class),
            Arguments.arguments(Country.FR, FranceIdValidator.class),
            Arguments.arguments(Country.IT, ItalyIdValidator.class),
            Arguments.arguments(Country.LU, LuxembourgIdValidator.class),
            Arguments.arguments(Country.MX, MexicoIdValidator.class),
            Arguments.arguments(Country.PT, PortugalIdValidator.class),
            Arguments.arguments(Country.ES, SpainIdValidator.class),
            Arguments.arguments(Country.US, UsaIdValidator.class)
        );
    }
}
