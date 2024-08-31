package com.HSBCBank;

public class Test {
    /**
     * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, remove them from the string. Repeat this process until
     * there is no more than 3 identical characters sitting besides each other.
     * Example:
     * Input: aabcccbbad
     * Output:
     * -> aabbbad
     * -> aaad
     * -> d
     */
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


    /**
     *#Stage 2 - advanced requirement
     * Instead of removing the consecutively identical characters, replace them with a
     * single character that comes before it alphabetically.
     * Example:
     * ccc -> b
     * bbb -> a
     * Input: abcccbad
     * Output:
     * -> abbbad, ccc is replaced by b
     * -> aaad, bbb is replaced by a
     * -> d
     */
    public String replaceConsecutive(String s) {
        while (true) {
            StringBuilder newString = new StringBuilder();
            int count = 1;

            for (int i = 1; i < s.length(); i++) {
                if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                } else {
                    if (count >= 3) {
                        // 替换为前一个字母
                        if ((s.charAt(i - 1) - 1) == 96) {
                            newString.append("");
                        } else {
                            char newChar = (char) (s.charAt(i - 1) - 1);
                            newString.append(newChar);
                        }
                    } else {
                        for (int j = 0; j < count; j++) {
                            newString.append(s.charAt(j));
                        }
                    }
                    count = 1;
                }
            }

            // 处理最后一组字符
            if (count >= 3) {
                char newChar = (char) (s.charAt(s.length() - 1) - 1);
                newString.append(newChar);
            } else {
                for (int j = 0; j < count; j++) {
                    newString.append(s.charAt(s.length() - 1));
                }
            }

            String newStr = newString.toString();
            if (newStr.equals(s)) { // 没有变化
                break;
            }
            s = newStr;
        }
        return s;
    }


    public static void main(String[] args) {
        Test t = new Test();
        String s1 = "aabcccbbad";
        String s2 = "abcccbad";
        System.out.println(t.removeConsecutive(s1));   // d
        System.out.println(t.replaceConsecutive(s2));  // d


    }

}
