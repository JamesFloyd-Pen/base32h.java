package base32Java.src.test.java.mavenpackage;

public class specs {
    static base32h baseh = new base32h();

    public static void main(String[] args) {
        specs mySpecs = new specs();

        //System.out.println(baseh.decodeBin("2060W2G6009"));
        mySpecs.testEncode();
        //mySpecs.testDecodeBin();
    }

    public void testEncode() {
        System.out.println(baseh.encode(1));
        System.out.println(baseh.encode(20));
        //Prints L
        System.out.println(baseh.encode(1234567890));
    }

    public void testDecode() {
        System.out.println(baseh.decode("L"));
        System.out.println(baseh.decode("I"));
        System.out.println(baseh.decode("132TLY9FTL5"));
    }

    public void testEncodeBin() {
        int[] WELLH0WDYPARDNERTEST = {227, 169, 72, 131, 141, 245, 213, 150, 217, 217};
        int[] zTest = {255, 255, 255, 255, 255};
        int[] signleZTest= {255};
        System.out.println(baseh.encodeBin(WELLH0WDYPARDNERTEST));
        System.out.println(baseh.encodeBin(zTest));
        System.out.println(baseh.encodeBin(signleZTest));

    }

    public void testDecodeBin() {
        System.out.println(baseh.decodeBin("ZZZZZZZZ"));
        System.out.println(baseh.decodeBin("0000007Z"));
        System.out.println(baseh.decodeBin("017L6N9M99M6YVAFF5CKGJKA6HNM0YAR"));
    }

    
}
