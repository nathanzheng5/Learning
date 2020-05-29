package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectingFlights {
    /*
    Given a list of flight tickets, find the route (in sequence) for the passenger.
    e.g. Tickets: Chicago -> Edmonton, Banff -> Dubai, Guangzhou -> Chicago, Dubai -> Guangzhou
    Output: Banff -> Dubai -> Guangzhou -> Chicago -> Edmonton
     */

    public static void main(String[] args) {
        String[][] tickets = {{"Chicago", "Edmonton"},
                {"Banff", "Dubai"},
                {"Guangzhou", "Chicago"},
                {"Dubai", "Guangzhou"}};

        List<String> route = findRoute(tickets);
        System.out.println(route);
    }

    static List<String> findRoute(String[][] tickets) {
        Map<String, String> start2End = new HashMap<>();
        Map<String, String> end2Start = new HashMap<>();
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            start2End.put(start, end);
            end2Start.put(end, start);
        }

        List<String> retVal = new ArrayList<>();
        start2End.keySet().stream()
                .filter(start -> !end2Start.containsKey(start))
                .findFirst()
                .ifPresent(start -> {
                    retVal.add(start);
                    String end = start2End.get(start);
                    while (end != null) {
                        retVal.add(end);
                        start = end;
                        end = start2End.get(start);
                    }
                });
        return retVal;
    }
}
