package com.HSBCBank;

public class ReplaceConsecutiveCharacters {
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
}
