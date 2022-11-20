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

    public static List<String> names() {
        //The name to add is the position of change indexed in the ABACABADABACABA... (names give a hint: alice, bob,
        // chris, dylan.) This is the xor of sequential elements

        List<String> codes = Brgc(4);
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
                default -> names.add("ERROR");
            }
        }
        return names;
    }
    //we have seen this in binary trees. the ABACABA fractal pattern is recursive, so it would be trivial to add Eve,
    // felix etc by simply adding one more bit length and adding one more switch case to account for that.
}
