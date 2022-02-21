package com.gridnine.testing;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Renat Mavlikhanov
 * Date: 19.02.2022
 * Time: 20:44
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        SegmentFilter segmentFilter = new SegmentFilterImpl();

        System.out.println("Список всех перелетов:");
        flightList.forEach(System.out::println);

        System.out.println("\nВремя вылета до текущего момента времени:");
        segmentFilter.getDepartureBeforeNow(flightList).forEach(System.out::println);

        System.out.println("\nСегменты перелета с датой прилёта раньше даты вылета:");
        segmentFilter.getArrivalBeforeDeparture(flightList).forEach(System.out::println);

        System.out.println("\nПерелеты с пересадкой более двух часов:");
        segmentFilter.getTransferMoreThanTwoHours(flightList).forEach(System.out::println);
    }
}
