package EncodeAndDecodeStrings;

// https://neetcode.io/problems/string-encode-and-decode

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        strs.forEach(s -> {
            sb.append("*").append(s.length()).append("#").append(s);
        });

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '*') {
                i++;
                int initialIndex = i;
                while (str.charAt(i) != '#') i++;
                int chNumber = Integer.parseInt(str.substring(initialIndex, i));
                i += 1;
                result.add(str.substring(i, i + chNumber));
                i += chNumber;
            }
        }

        return result;
    }

}
