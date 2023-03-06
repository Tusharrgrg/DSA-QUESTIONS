public class GeekHatesTooMany1s {
    public static int noConseBits(int n) {
        // code here
        String binary=Integer.toBinaryString(n).replaceAll("111", "110");
        int res=Integer.parseInt(binary, 2);
        
        return res;
    }
}
