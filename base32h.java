import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        ArrayList out = new ArrayList<>();
        
        if(rem == 0) {
            out.add("0");
            return out;
        }

        while(rem > 0) {
            long temp = rem % 32;
            int indexPointer = (int) temp;
            out.add(0,digits[indexPointer % 32].substring(0,1));
            rem = rem/32;
        }

        return out;
    }

    ArrayList<String> encodeBin(int[] input) {
        ArrayList output = new ArrayList<>();

        int overflow = input.length % 5;
        if(overflow != 0) {
            input = Arrays.copyOf(input, input.length +  5-overflow);
            input = moveZeroesToLeft(input);
        }

        for(int i = 0; i <input.length; i+=5) {
            int[] segment  = Arrays.copyOfRange(input, i, i+5);
            long segLong = bytesToUint40(segment);
            output.addAll(encode(segLong));
            pad(output);
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
        ArrayList<String> padded = new ArrayList<>();
        padded.addAll(stringToArraylist(input));
        String[] temp = new String[padded.size()];

        for(int i = 0; i < padded.size(); i += 8) {
            for(int j = 0; j <padded.size(); j++)
                temp[j] = padded.get(j);
            String[] simpleArray = Arrays.copyOfRange(temp, i, i+8);
            String segment = String.join("",simpleArray);
            long val = decode(segment);
            output = IntStream.of(uint40ToBytes(val)).boxed().collect(Collectors.toCollection(ArrayList::new));          
        }
        return output;
    }

    ArrayList<String> stringToArraylist(String input) {
        ArrayList<String> output = new ArrayList<>();
        String[] rem = input.split("(?!^)");
        for(int i = 0; i < rem.length; i++) {
            int answer = decodeDigit(rem[i]);
            if(answer != -1) {
                output.add(String.valueOf(rem[i]));
            }
        }
        pad(output);

        return output;
    }

    int[] uint40ToBytes(long input){
        int[] bytes = {0,0,0,0,0};
        for(int idx = bytes.length-1; idx >= 0; idx--) {
            float myByte = input & 0xff;
            bytes[idx] = (int) myByte;
            input = (input - (long) myByte) / 256;
            if(input == 0) {
                break;
            }
        }
        return bytes;
    }

    public static void main(String[] args) {
        /* TODO code application logic here

            1. Create the Encoder for Decimal first | Completed
            2. Create the decoder for Decimal Second | Completed
            3. Test both Hell0World, alongside test cases to pass the first part. | Completed
            4. Build the binary encoder | Done.
            5. Build the binary decoder | Close to done!
            6. Test test for both
            7. Create the method/JSON for command line 
        */
        base32h baseh = new base32h();
        System.out.println(baseh.decodeBin("zZzZzZzZzZzZzZzZ"));
    }
}
