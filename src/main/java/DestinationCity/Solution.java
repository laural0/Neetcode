package DestinationCity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> counter = new HashMap<>();

        for (List<String> path : paths) {
            counter.merge(path.get(0), 1, Integer::sum);

            counter.merge(path.get(1), -1, Integer::sum);
        }

        return counter.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() < 0).findFirst().get().getKey();
    }
}
