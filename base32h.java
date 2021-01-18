import java.util.ArrayList;

public class base32h {

    /*
    canonical list, alongside the Alias
    */
    public final String[] digits =
    {"0Oo",
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

    String encode(int n)
    {
        int rem = n;
        ArrayList<String> out = new ArrayList<>();


        while(rem > 0)
        {
            //Add a new element in the first element
            //Then remm & 32 to 
            //use temp value  temp/32 for the loop to continue until 0
            out.add(0,digits[rem % 32].substring(0,1));
            rem = rem/32;
        }

        System.out.println(" test " + out);

        String answer = String.valueOf(n);
        return answer;
    }


    int encodeBin(int n)
    {
        int i = 0;

        return i;
    }

    int decode(int n)
    {
        return n;
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
        */
        base32h baseh = new base32h();
        baseh.encode(1234567890);

    }
}
