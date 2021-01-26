import java.util.ArrayList;

public class base32h {

    /*
    canonical list, alongside the Alias
    */
    public final String[] digits = {
    "0Oo",
    "1Ii",
    "2",
    "3",
    "4",
    "5Ss",
    "6",
    "7",
    "8",
    "9",
    "Aa",
    "Bb",
    "Cc",
    "Dd",
    "Ee",
    "Ff",
    "Gg",
    "Hh",
    "Jj",
    "Kk",
    "Ll",
    "Mn",
    "Nn",
    "Pp",
    "Qq",
    "Rr",
    "Tt",
    "VvUu",
    "Ww",
    "Xx",
    "Yy",
    "Zz"
    };

    ArrayList<String> encode(int n) {
        int rem = n;
        ArrayList out = new ArrayList<>();
        
        if(rem == 0) {
            out.add("0");
            return out;
        }

        while(rem > 0) {
            out.add(0,digits[rem % 32].substring(0,1));
            rem = rem/32;
        }

        return out;
    }

    String encodeBin(int[] input) {
        
        int overflow = input.length % 5;
        if(overflow == 0) {
           // input = [...(5 - overflow), ...input];
        }
        
        String acc = "";
        
        for(int i = 0; i <input.length; i+=5) {
            //int segment = input.slice[i];

        }

        return acc;
    }

    int decodeDigit(String input) {
        int index = -1;
        for(int i = 0; i < digits.length; i++) {
            if(digits[i].contains(input)) {
                index = i;
                break;
            }
        }
        System.out.println(index);
        return index;
    }

    int decode(String input) {
        String[] rem = input.split("(?!^)");
        int exp = 0, i = rem.length, answer = 0;
        int temp = rem.length;

        while(temp > 0) {
            int digit = decodeDigit(rem[i-1]);
            i-=1;
            temp-=1;

            if(digit < 0) {
                continue;
            }

            answer += digit * (int) Math.pow(32, exp);
            exp++;
        }

        System.out.print(answer);
        return answer;
    }

    int decodeBin(int n) {
        return n;
    }

    public static void main(String[] args) {
        /* TODO code application logic here

            1. Create the Encoder for Decimal first | Completed
            2. Create the decoder for Decimal Second | Partialty works
            3. Test both Hell0World, alongside test cases to pass the first part.
            4. Build both the binary for encoder
            5. Build the binary decoder
            6. Test test for both
            7. Create the method/JSON for command line 
        */
        base32h baseh = new base32h();
        baseh.decode("88pzd");
        //int[] test = {255, 255, 255, 255, 255};
        //int overflow = test.length % 5;
        //System.out.println(overflow);
        //baseh.encodeBin(test);
        //System.out.println(baseh.encode(614236187289229));
    }
}
