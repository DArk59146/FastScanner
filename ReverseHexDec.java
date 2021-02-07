import java.io.*;

public class ReverseHexDec {

        public static void main(String[] args) {
            int b;
            int i;
            IVector num = new IVector(40);
            IVector p = new IVector(40);
            final RequiredSymbols requiredSymbols = new RequiredSymbols() {
                @Override
                public boolean isRequiredSymbol(int c) {
                    return Character.isDigit(c) || Character.getType(c) == Character.DASH_PUNCTUATION || Character.isLetter(c);
                }
            };
            try {
                FastScanner sc = new FastScanner(System.in, "utf8", requiredSymbols);
                try {
                    int value;
                    while (sc.hasNextLine() || sc.hasNextSequence()) {
                        i = 0;
                        while (sc.hasNextSequenceInLine()) {
                            value = sc.nextHexDec();
                            num.add(value);
                            i++;
                        }
                        sc.newLine();
                        p.add(i);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } finally {
                    sc.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            i = num.length() - 1;
            for (int k = p.length() - 1; k >= 0; k--) {
                b = 0;
                while (b < p.get(k)) {
                    System.out.print(num.get(i - b) + " ");
                    b++;
                }
                System.out.println();
                i -= b;
            }
        }
}
