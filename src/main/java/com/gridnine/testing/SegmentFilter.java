package com.gridnine.testing;

import java.util.List;

public interface SegmentFilter {

    List<Segment> getDepartureBeforeNow(List<Flight> flights);
    List<Segment> getArrivalBeforeDeparture(List<Flight> flights);
    List<Flight> getTransferMoreThanTwoHours(List<Flight> flights);
}
