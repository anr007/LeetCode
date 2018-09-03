/* 
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. 
*/

// Inefficient Solution
class Solution {
    public boolean isNumber(String s) {

        /*
         * '\' in a string literal in Java source code is the character used for
         * escaping (e.g. "\t" for tab). Therefore you need to use '\' before a string
         * literal to end up with a single backslash in the resulting string.
         */

        s = s.trim();

        /*
         * simplified regex
         * s.matches("[-\\+]?((\\d+(|(\\.|e[-\\+]?|\\.\\d*e[-\\+]?)\\d+))|(\\d*(\\.|\\.\\d+e[-\\+]?)\\d+)|(\\d+\\.\\d*))")
         */

        if (s.matches("-{0,1}\\+{0,1}[0-9][0-9]*") // "-111","+2","23"
                || s.matches("-{0,1}\\+{0,1}[0-9][0-9]*\\.[0-9][0-9]*") // "-2.3", "+22.4", "2.0"
                || s.matches("-{0,1}\\+{0,1}[0-9][0-9]*e-{0,1}\\+{0,1}[0-9][0-9]*") // "-49e445254", "+2e4", "2e-10"
                || s.matches("-{0,1}\\+{0,1}[0-9]*\\.[0-9][0-9]*") // "-.5", ".7", "+.99"
                || s.matches("-{0,1}\\+{0,1}[0-9][0-9]*\\.[0-9]*") // "-9.", "+8.7","22."
                || s.matches("[0-9][0-9]*\\.e-{0,1}\\+{0,1}[0-9][0-9]*") // "22.e-8", "5.e4"
                || s.matches("-{0,1}\\+{0,1}[0-9]*\\.[0-9][0-9]*e-{0,1}\\+{0,1}[0-9][0-9]*") // "-.9e6", "+8.2e-7"
                || s.matches("-{0,1}\\+{0,1}[0-9][0-9]*\\.[0-9]*e-{0,1}\\+{0,1}[0-9][0-9]*") // "-1.e49046"
        ) {
            return true;
        } else {
            return false;
        }
    }
}
