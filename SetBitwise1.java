package dsa.Bitwise;

public class SetBitwise1 {
    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
        public static int countTotalSetBits(int n) {
        int totalSetBits = 0;
        for (int i = 1; i <= n; i++) {
            totalSetBits += countSetBits(i);
        }
        return totalSetBits;
    }
    
    public static void main(String[] args) {
        int n = 10; 
        int totalSetBits = countTotalSetBits(n);
        System.out.println("Total set bits from 1 to " + n + ": " + totalSetBits);
    }
}
