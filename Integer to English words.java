//Convert a non-negative integer num to its English words representation.
//TC:O(1) and SC:O(1)
class Solution {
    private static final String[] BELOW_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();
        int unitIndex = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder chunk = new StringBuilder();
                convertChunk(num % 1000, chunk);
                words.insert(0, chunk.append(THOUSANDS[unitIndex]).append(" "));
            }
            num /= 1000;
            unitIndex++;
        }

        return words.toString().trim();
    }
//The convertChunk method converts a number less than 1000 into its English words representation and appends it to the chunk StringBuilder.
    private static void convertChunk(int num, StringBuilder chunk) {
        if (num >= 100) {
            chunk.append(BELOW_TWENTY[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            chunk.append(TENS[num / 10]).append(" ");
            num %= 10;
        }
        if (num > 0) {
            chunk.append(BELOW_TWENTY[num]).append(" ");
        }
    }

}
