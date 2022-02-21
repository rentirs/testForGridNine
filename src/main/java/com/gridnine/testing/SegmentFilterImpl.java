package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SegmentFilterImpl implements SegmentFilter {

    public List<Segment> getDepartureBeforeNow(List<Flight> flightList) {
        List<Segment> res = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments().stream().filter(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())).forEach(res::add));
        return res;
    }

    public List<Segment> getArrivalBeforeDeparture(List<Flight> flightList) {
        List<Segment> res = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments().stream().filter(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())).forEach(res::add));
        return res;
    }

    public List<Flight> getTransferMoreThanTwoHours(List<Flight> flightList) {
        List<Flight> res = new ArrayList<>();
        flightList.stream().filter(flight -> flight.getSegments().size() > 1).forEach(flight -> {
            LocalDateTime previousSegmentArrival = flight.getSegments().get(0).getArrivalDate();
            for (int i = 1; i < flight.getSegments().size(); i++) {
                if (Duration.between(previousSegmentArrival, flight.getSegments().get(i).getDepartureDate()).toHours() > 2) {
                    res.add(flight);
                }
                previousSegmentArrival = flight.getSegments().get(i).getArrivalDate();
            }
        });
        return res;
    }
}
