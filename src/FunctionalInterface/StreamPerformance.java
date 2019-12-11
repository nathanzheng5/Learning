package FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamPerformance {

    public static void main(String[] args) {
        System.out.println("initializing source list");
        List<Double> sourceList = new ArrayList<>();
        for (int i = 0; i < 1e7; i++) {
            final Random random = new Random();
            boolean addZero = random.nextBoolean();
            sourceList.add(addZero ? 0.0 : random.nextDouble());
        }

        System.out.println("\nstarting 1");
        List<Double> filteredList = new ArrayList<>();
        final long startTime = System.currentTimeMillis();
        for (double element : sourceList) {
            if (element != 0.0) {
                filteredList.add(element);
            }
        }
        System.out.println("for loop takes " + (System.currentTimeMillis() - startTime)
                + ", end list size = " + filteredList.size());

        System.out.println("\nstarting 2");
        List<Double> filteredList2 = new ArrayList<>();
        final long startTime2 = System.currentTimeMillis();
        filteredList2.addAll(
                sourceList.stream()
                        .filter(element -> element != 0.0)
                        .collect(Collectors.toList()));
        System.out.println("stream addAll takes " + (System.currentTimeMillis() - startTime2)
                + ", end list size = " + filteredList2.size());

        System.out.println("\nstarting 3");
        final long startTime3 = System.currentTimeMillis();
        final List<Double> filteredList3 = sourceList.stream()
                .filter(element -> element != 0.0)
                .collect(Collectors.toList());
        System.out.println("stream collect takes " + (System.currentTimeMillis() - startTime3)
                + ", end list size = " + filteredList3.size());

        System.out.println("\nstarting 4");
        List<Double> filteredList4 = new ArrayList<>();
        final long startTime4 = System.currentTimeMillis();
        filteredList4.addAll(
                sourceList.parallelStream()
                        .filter(element -> element != 0.0)
                        .collect(Collectors.toList()));
        System.out.println("parallel stream add takes " + (System.currentTimeMillis() - startTime4)
                + ", end list size = " + filteredList4.size());

        System.out.println("\nstarting 5");
        final long startTime5 = System.currentTimeMillis();
        List<Double> filteredList5 = sourceList.parallelStream()
                .filter(element -> element != 0.0)
                .collect(Collectors.toList());
        System.out.println("parallel stream collect takes " + (System.currentTimeMillis() - startTime5)
                + ", end list size = " + filteredList5.size());
    }

}
