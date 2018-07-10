class Solution {
    public int lengthOfLongestSubstring(String s) {
        int NO_OF_CHARS = 256; // ASCII char count
        int max_len = 1;
        String cur_str = "";
        ArrayList<String> prev_max_str = new ArrayList();
        ArrayList<String> max_str = new ArrayList();
        int visited[] = new int[NO_OF_CHARS];

        /*
         * Initialize the visited array as -1, -1 is used to indicate that character has
         * not been visited yet.
         */
        for (int i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

        if (s.length() <= 0)
            return 0;

        /*
         * Mark first character as visited by storing the index of first character in
         * visited array.
         */
        visited[s.charAt(0)] = 0;
        cur_str = s.charAt(0) + "";
        max_str.add(cur_str);

        /*
         * Start from the second character. First character is already processed
         * (cur_len and max_len are initialized as 1, and visited[str[0]] is set
         */
        for (int i = 1; i < s.length(); i++) {

            /*
             * If the current character is not present in the already processed substring
             */
            if (visited[s.charAt(i)] == -1) {
                cur_str = cur_str + s.charAt(i);
                if (max(cur_str, max_str.get(0)) == 1) {
                    max_str.clear();
                    if (!max_str.contains(cur_str))
                        max_str.add(cur_str);
                } else if (max(cur_str, max_str.get(0)) == 0) {
                    if (!max_str.contains(cur_str))
                        max_str.add(cur_str);
                }
                visited[s.charAt(i)] = 0;
            } else {

                boolean last_char = (i == s.length() - 1) ? true : false;

                String prev_str = ""; // used if last char of the input string

                int prev_index = cur_str.indexOf(s.charAt(i)); // if -1 then given char is not found in the current
                                                               // substring

                if (prev_index == -1) {
                    cur_str = cur_str + s.charAt(i);
                } else if (prev_index + 1 <= cur_str.length() - 1) {

                    if (last_char)
                        prev_str = cur_str;

                    cur_str = cur_str.substring(prev_index + 1);
                    cur_str = cur_str + s.charAt(i);

                } else {

                    cur_str = "";
                    cur_str = cur_str + s.charAt(i);
                }

                if (max(cur_str, max_str.get(0)) == 1) {
                    max_str.clear();
                    if (last_char && max(prev_str, cur_str) == 0) {
                        if (!max_str.contains(prev_str))
                            max_str.add(prev_str);
                    }
                    if (!max_str.contains(cur_str))
                        max_str.add(cur_str);
                } else if (max(cur_str, max_str.get(0)) == 0) {
                    if (last_char && max(prev_str, cur_str) == 0) {
                        if (!max_str.contains(prev_str))
                            max_str.add(prev_str);
                    }
                    if (!max_str.contains(cur_str))
                        max_str.add(cur_str);
                }

            }
        }
        
        for (String max : max_str) {
            System.out.println(max + "\n");
        }
        return max_str.get(0).length();

    }

    private int max(String s1, String s2) {
        if (s1.length() > s2.length())
            return 1;
        else if (s1.length() < s2.length())
            return 2;
        else
            return 0;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static void main(String[] args) throws IOException {

        String s = "pwwkew";

        int ret = new Solution().lengthOfLongestSubstring(s);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}