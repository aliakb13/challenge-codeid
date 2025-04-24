public class MathStringCh {
    public static void main(String[] args) {
//        System.out.println(reverse(4563));

//        System.out.println(isPalindrome(20202));
        System.out.println(capitalize("this is a very special title"));
//        System.out.println(isNoDuplicateChar("toky"));
//        System.out.println(isBrace("())"));
    }

    public static int reverse(int num) {
//        StringBuilder str = new StringBuilder();
//        str.append(num);
//        System.out.println(str.reverse());

        int reversed = 0;
        while(num > 0) {
            reversed =  reversed * 10 + num % 10;
            num /= 10;
        }

        return reversed;
    }

    public static boolean isPalindrome(int n) {
//        String num = String.valueOf(n);
//        StringBuilder reverse = new StringBuilder(num);
//        return num.contentEquals(reverse.reverse());

        return reverse(n) == n;
    }

    public static String capitalize(String input) {
        if (input.equals(" ") || input.isEmpty() || input == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        String[] words = input.split(" ");
        for (String word: words) {
            result.append(Character.toTitleCase(word.charAt(0)));
            result.append(word.substring(1));
            result.append(" ");
        }

        return result.toString();

    }
//
    public static boolean isNoDuplicateChar(String s) {
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
//
    public static boolean isBrace(String s) {
        int match = 0;

        for (int i = 0; i < s.length(); i++) {
            char brace = s.charAt(i);

            if (brace == '(') {
                match++;
            } else if(brace == ')') {
                match--;
                if(match < 0) {
                    return false;
                }
            }
        }

        return match == 0;
    }
}
