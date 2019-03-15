import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (40.53%)
 * Total Accepted:    354.7K
 * Total Submissions: 873.8K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            return num2String(digits.charAt(0));
        }
        List<String> first = num2String(digits.charAt(0));
        List<String> second = letterCombinations(digits.substring(1));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                result.add(first.get(i) + second.get(j));
            }
        }
        return result;
    }

    public List<String> num2String(char num) {
        List<String> result = new ArrayList<>();
        switch (num) {
        case '2':
            result.add("a");
            result.add("b");
            result.add("c");
            break;
        case '3':
            result.add("d");
            result.add("e");
            result.add("f");
            break;
        case '4':
            result.add("g");
            result.add("h");
            result.add("i");
            break;
        case '5':
            result.add("j");
            result.add("k");
            result.add("l");
            break;
        case '6':
            result.add("m");
            result.add("n");
            result.add("o");
            break;
        case '7':
            result.add("p");
            result.add("q");
            result.add("r");
            result.add("s");
            break;
        case '8':
            result.add("t");
            result.add("u");
            result.add("v");
            break;
        case '9':
            result.add("w");
            result.add("x");
            result.add("y");
            result.add("z");
            break;
        default:
            break;
        }
        return result;
    }
}
