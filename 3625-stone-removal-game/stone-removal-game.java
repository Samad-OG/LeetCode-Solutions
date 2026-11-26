class Solution {
    public boolean canAliceWin(int n) {
        int stonesToRemove = 10;
        boolean isAliceTurn = true;

        while (n >= stonesToRemove && stonesToRemove > 0) {
            n -= stonesToRemove;
            stonesToRemove--;
            isAliceTurn = !isAliceTurn;
        }

        return !isAliceTurn;
    }
}
