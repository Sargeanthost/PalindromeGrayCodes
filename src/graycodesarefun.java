import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class graycodesarefun {
    /**
     * Generates Binary reflected gray codes of length {@code nBits}. One-one Java impl of book pseudocode.
     * @param nBits the length of gray codes to generate
     * @return returns a list of all nBits length gray codes
     */
    public static List<String> Brgc(int nBits){
        List<String> codes = new ArrayList<>();

        if (nBits == 1){
            codes.add("0");
            codes.add("1");
        } else {
            List<String> l1 = Brgc(nBits-1);
            List<String> l2 = new ArrayList<>(l1);
            Collections.reverse(l2);
            l1 = l1.stream().map(x -> "0" + x).toList();
            l2 = l2.stream().map(x -> "1" + x).toList();
            codes.addAll(l1);
            codes.addAll(l2);
        }
        return codes;
    }

    public static List<String> names(){
        //The name to add is the position of change indexed in the ABACABADABACABA... (alice, bob, chris, dylan)
        //First person to change is alice, then bob, then alice, then chris

        List<String> codes = Brgc(4);
        List<String> names = new ArrayList<>();

        for(String code : codes){
            Integer.parseInt(code, 2);
        }

        return names;
    }
}
