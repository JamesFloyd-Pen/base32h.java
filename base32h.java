import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.element.Element;

public class base32h {

    /*
    canonical list, alongside the Alias
    */
    public final String[] digits =
    {
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

    ArrayList<String> encode(int n)
    {
        int rem = n;
        ArrayList out = new ArrayList<>();
        
        if(rem == 0)
        {
            out.add("0");
            return out;
        }

        while(rem > 0)
        {
            out.add(0,digits[rem % 32].substring(0,1));
            rem = rem/32;
        }

        return out;
    }


    int encodeBin(int n)
    {
        int i = 0;

        return i;
    }

    int decodeDigit(String input )
    {
        int index = -1;
        for(int i = 0; i < digits.length; i++)
        {
            if(digits[i].contains(input))
            {
                index = i;
                break;
            }
        }
        //Fix up the input to find the specific character in the array
        //int index = Arrays.asList(digits).indexOf(input);
        System.out.println(index);
        return index;
    }

    ArrayList<Integer> decode(String input)
    {
        ArrayList acc = new ArrayList<>();
        ArrayList<Character> rem = new ArrayList<Character>();
        int exp = 0;

        for(int i = 0; i<input.length(); i++)
        {
            rem.add(input.charAt(i));
        }

        while(rem.size() > 0)
        {
            /*
            int digit = decodeDigit(rem.pop());

            if(digit < 0 )
            {
                continue;
            }

            acc.add(digit * 32**exp);
            exp += 1;
            */
        }
        
        return acc;
    }

    int decodeBin(int n)
    {
        return n;
    }

    public static void main(String[] args) {
        /* TODO code application logic here

            1. Create the Encoder for Decimal first | Completed
            2. Create the decoder for Decimal Second
            3. Test both Hell0World, alongside test cases to pass the first part.
            4. Build both the binary for encoder
            5. Build the binary decoder
            6. Test test for both
            7. Create the method/JSON for command line 
        */
        base32h baseh = new base32h();
        baseh.decodeDigit("o");
        //System.out.println(baseh.encode(17854910));

    }
}
