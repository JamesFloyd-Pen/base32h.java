import java.util.ArrayList;
import java.util.Arrays;

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

    ArrayList<String> encode(long n) {
        long rem = n;
        long temp = rem % 32;
        int indexPointer = (int) temp;
        ArrayList out = new ArrayList<>();
        
        if(rem == 0) {
            out.add("0");
            return out;
        }

        while(rem > 0) {
            out.add(0,digits[indexPointer % 32].substring(0,1));
            rem = rem/32;
        }

        return out;
    }

    ArrayList<String> encodeBin(int[] input) {
        ArrayList output = new ArrayList<>();
        ArrayList padded = new ArrayList<>();

        
        int overflow = input.length % 5;
        if(overflow != 0) {
            input = Arrays.copyOf(input, input.length +  5-overflow);
            input = moveZeroesToLeft(input);
            for(int a: input)
                System.out.print(a + " ");
        }

        for(int i = 0; i <input.length; i+=5) {
            input = Arrays.copyOfRange(input, i, i+5);
            long segment = bytesToUint40(input);
            padded.addAll(encode(segment));
            pad(padded);
            output.addAll(padded);
        }

        return output;
    }

    long bytesToUint40(int[] input) {
         
        return input[0]*(long) Math.pow(2, 32) + input[1]*(long) Math.pow(2, 24) + input[2]*(long) Math.pow(2, 16) + input[3]*(long) Math.pow(2, 8) + input[4];
    }

    /*
    The pad makes sure the input returns with exact 8 digits
    */

    ArrayList<String> pad(ArrayList<String> input) {

        int o = input.size() % 8;
        if(o != 0) {
            for(int i = 0; i < 8-o; i++) {
                input.add(i, "0");
            }
            return input;
        }

        return input;
    }

    int[] moveZeroesToLeft(int[] n) {
        
        int count = 0;
        for(int i = 0; i < n.length; i++) {
            if(n[i] == 0) {
                n[i] = n[count];
                n[count++] = 0;
            }
        }

        return n;
    }

    int decodeDigit(String input) {
        int index = -1;
        for(int i = 0; i < digits.length; i++) {
            if(digits[i].contains(input)) {
                index = i;
                break;
            }
        }

        return index;
    }

    long decode(String input) {
        String[] rem = input.split("(?!^)");
        int i = rem.length;
        long answer = 0, exp =0;
        int temp = rem.length;

        while(temp > 0) {
            long digit = decodeDigit(rem[i-1]);
            i-=1;
            temp-=1;

            if(digit < 0) {
                continue;
            }

            answer += digit * (long) Math.pow(32, exp);
            exp++;
        }

        return answer;
    }

    ArrayList<Integer> decodeBin(String input) {
        ArrayList<Integer> output = new ArrayList<>();
        String[] rem = input.split("(?!^)");

        for(int i = 0; i < rem.length; i += 8) {
            String segment = Arrays.copyOfRange(rem, i, i+8).toString();
            long val = decode(segment);
            output.addAll(uint40ToBytes(val));
        }
    
        return output;
    }

    ArrayList<Integer> uint40ToBytes(long input){
        ArrayList<Integer> output = new ArrayList<>();
        //String padded = pad(String.valueOf(input)));
        /*
        Pseudo Code
        output.add(0, padded.substring(0,2));
        output.add(1, padded.substring(2,4));
        output.add(2, padded.substring(4,6));
        output.add(3, padded.substring(6,8));
        output.add(4, padded.substring(8,10));
        */

        return output;
    }

    public static void main(String[] args) {
        /* TODO code application logic here

            1. Create the Encoder for Decimal first | Completed
            2. Create the decoder for Decimal Second | Completed
            3. Test both Hell0World, alongside test cases to pass the first part. | Completed
            4. Build the binary encoder | Mostly done, requires optimization.
            5. Build the binary decoder
            6. Test test for both
            7. Create the method/JSON for command line 
        */
        base32h baseh = new base32h();
        int[] test = {255, 255,255,255,255, 255};
        //To produce "HowdyPartner"
        //int[] test2 = {227,169,72,131,141,245,213,150,217,217};
        System.out.println(baseh.encodeBin(test));
        //System.out.println(baseh.encode(16575));
    }
}
