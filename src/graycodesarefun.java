import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class graycodesarefun {
    /**
     * Generates Binary reflected gray codes of length {@code nBits}. One-one Java impl of book pseudocode.
     *
     * @param nBits the length of gray codes to generate
     * @return returns a list of all nBits length gray codes
     */
    public static List<String> Brgc(int nBits) {
        List<String> codes = new ArrayList<>();

        if (nBits == 1) {
            codes.add("0");
            codes.add("1");
        } else {
            List<String> l1 = Brgc(nBits - 1);
            List<String> l2 = new ArrayList<>(l1);
            Collections.reverse(l2);
            l1 = l1.stream().map(x -> "0" + x).toList();
            l2 = l2.stream().map(x -> "1" + x).toList();
            codes.addAll(l1);
            codes.addAll(l2);
        }
        return codes;
    }

    @SuppressWarnings("SameParameterValue")
    private static List<String> names(int n) {
        //The name to add is the position of change indexed in the ABACABADABACABA... (names give a hint: alice, bob,
        // chris, dylan.) This is the xor of sequential elements

        List<String> codes = Brgc(n);
        List<String> names = new ArrayList<>();

        for (int i = 0; i < codes.size() - 1; i++) {
            // size - 1 because ascending pair for last .get(size-1) elem is .get(size), which is out of bounds
            int temp = i;
            int xor = Integer.parseInt(codes.get(i), 2) ^ Integer.parseInt(codes.get(++temp), 2);
            switch (xor) {
                //powers of 2.
                case 1 -> names.add("Alice");
                case 2 -> names.add("Bob");
                case 4 -> names.add("Chris");
                case 8 -> names.add("Dylan");
                case 16 -> names.add("Eve");
                default -> names.add("ERROR");
            }
        }
        return names;
    }

    private static List<String> moves(List<String> code) {
        //List = "Alice in" on entry 0, "Bob in" on entry 1" etc
        List<String> operations = new ArrayList<>();
        final String IN = " in";
        final String OUT = " out";

        for (String curWord : code) {
            if (Collections.frequency(operations, curWord + IN) - Collections.frequency(operations, curWord + OUT)
                == 1) {//more ins than out
                operations.add(curWord + OUT);
            } else {
                operations.add(curWord + IN);
            }
        }
        return operations;
    }

    private static List<String> inPhoto(List<String> codes) {
        List<String> inPhoto = new ArrayList<>();
        for (int i = 0; i < codes.size(); i++) {
            int rep = Integer.parseInt(codes.get(i), 2);
            String str = "";
            if ((rep & 1) == 1) {
                str += "Alice";
            }
            if ((rep & 2) == 2) {
                if (str.equals("")) {
                    str += "Bob";
                } else {
                    str += " & Bob";
                }
            }
            if ((rep & 4) == 4) {
                if (str.equals("")) {
                    str += "Chris";
                } else {
                    str += " & Chris";
                }
            }
            if ((rep & 8) == 8) {
                if (str.equals("")) {
                    str += "Dylan";
                } else {
                    str += " & Dylan";
                }
            }
            if ((rep & 16) == 16) {
                if (str.equals("")) {
                    str += "Eve";
                } else {
                    str += " & Eve";
                }
            }
            inPhoto.add(i, str);
        }
        return inPhoto;
    }

    public static String picnic() {
        final int BITS = 5;
        //index | code | children in photo | action
        List<String> codes = Brgc(BITS);
        List<String> inPhoto = inPhoto(codes);
        List<String> names = names(BITS);
        List<String> action = moves(names);

        final String SEP = " | ";
        StringBuilder table = new StringBuilder();
        table.append("Number").append(SEP).append("Code").append(SEP).append("Children in photo").append(SEP)
            .append("Action\n");
        for (int i = 0; i < 31; i++) {//15 names
            int temp = i;
            table.append(++temp).append(SEP).append(codes.get(temp)).append(SEP).append(inPhoto.get(temp)).append(SEP)
                .append(action.get(i));
            table.append("\n");
        }
        return table.toString();
    }
    //we have seen this in binary trees. the ABACABA fractal pattern is recursive.It would be trivial to add extra
    // orders for pictures, you would just have to create the new names and add them to the program
}
