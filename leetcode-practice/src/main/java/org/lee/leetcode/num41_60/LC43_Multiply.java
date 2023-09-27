package org.lee.leetcode.num41_60;

public class LC43_Multiply {

    public String multiply(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length()];
        int s = arr.length - 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int add = 0, k = s--, x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = x * (num2.charAt(j) - '0') + add + arr[k];
                add = y / 10;
                arr[k--] = y % 10;
            }
            if (add > 0)
                arr[k--] = add;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && sb.length() == 0)
                continue;
            else
                sb.append(arr[i]);
        }
        if (sb.length() == 0)
            sb.append("0");

        return sb.toString();
    }

}
