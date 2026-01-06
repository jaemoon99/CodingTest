import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                int compareHead = head1.toUpperCase().compareTo(head2.toUpperCase());

                if (compareHead == 0) {
                    o1 = o1.substring(head1.length());
                    o2 = o2.substring(head2.length());

                    String number1 = "";
                    for (char o : o1.toCharArray()) {
                        if (number1.length() >= 5 || !Character.isDigit(o)) {
                            break;
                        }

                        number1 += o;
                    }

                    String number2 = "";
                    for (char o : o2.toCharArray()) {
                        if (number2.length() >= 5 || !Character.isDigit(o)) {
                            break;
                        }

                        number2 += o;
                    }

                    return Integer.parseInt(number1) - Integer.parseInt(number2);
                }

                return compareHead;
            }
        });

        return files;
    }
}