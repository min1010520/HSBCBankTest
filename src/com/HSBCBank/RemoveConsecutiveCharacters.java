package com.HSBCBank;

public class RemoveConsecutiveCharacters {

    public String removeConsecutive(String s) {
        StringBuilder result = new StringBuilder();
        if (s.length() >= 1) {
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                int count = 0;

                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == currentChar) {
                        count++;
                    }
                }
                if (count <= 2) {
                    result = result.append(currentChar);
                }
            }
        }
        return result.toString();
    }

}
