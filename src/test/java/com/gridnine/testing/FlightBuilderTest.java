package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightBuilderTest {

    List<Flight> flightList = FlightBuilder.createFlights();

    @Test
    @DisplayName("Check creating flights")
    void createFlights() {
        assertNotNull(flightList);
        assertEquals(6, flightList.size());
    }
}