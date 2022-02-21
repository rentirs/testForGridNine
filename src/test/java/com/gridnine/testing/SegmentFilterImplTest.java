package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SegmentFilterImplTest {

    List<Flight> flightList = FlightBuilder.createFlights();

    @Test
    @DisplayName("Get flights where departure time is before now")
    void getDepartureBeforeNow() {
        assertFalse((new SegmentFilterImpl()).getDepartureBeforeNow(flightList).isEmpty());
        assertEquals(1, (new SegmentFilterImpl()).getDepartureBeforeNow(flightList).size());
    }

    @Test
    @DisplayName("Get flights where arrival time is before departure time")
    void getArrivalBeforeDeparture() {
        assertFalse((new SegmentFilterImpl()).getArrivalBeforeDeparture(flightList).isEmpty());
        assertEquals(1, (new SegmentFilterImpl()).getArrivalBeforeDeparture(flightList).size());
    }

    @Test
    @DisplayName("Get transfers where transfer is more than two hours")
    void getTransferMoreThanTwoHours() {
        assertFalse((new SegmentFilterImpl()).getTransferMoreThanTwoHours(flightList).isEmpty());
        assertEquals(1, (new SegmentFilterImpl()).getTransferMoreThanTwoHours(flightList).size());
    }
}