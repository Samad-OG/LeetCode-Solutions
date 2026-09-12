 class Solution {
    public boolean validUtf8(int[] data) {
        int numberOfBytesToProcess = 0;

        for (int val : data) {
            if (numberOfBytesToProcess == 0) {
                if ((val >> 7) == 0b0) {
                    continue;
                } else if ((val >> 5) == 0b110) {
                    numberOfBytesToProcess = 1;
                } else if ((val >> 4) == 0b1110) {
                    numberOfBytesToProcess = 2;
                } else if ((val >> 3) == 0b11110) {
                    numberOfBytesToProcess = 3;
                } else {
                    return false;
                }
            } else {
                if ((val >> 6) != 0b10) {
                    return false;
                }
                numberOfBytesToProcess--;
            }
        }

        return numberOfBytesToProcess == 0;
    }
}