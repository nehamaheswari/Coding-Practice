/*At a lemonade stand, each lemonade costs $5. 
Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). 
Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. 
You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
Note that you do not have any change in hand at first.
Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.*/

public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0; // Initialize counters for $5 and $10 bills
    
    for (int bill : bills) { // Iterate through each bill in the input array
        if (bill == 5) { 
            five++; // Increase the count of $5 bills
        } else if (bill == 10) {
            if (five == 0) { // If no $5 bill is available for change
                return false; // Can't give change, return false
            }
            five--; // Use one $5 bill for change
            ten++; // Increase the count of $10 bills
        } else { // bill == 20
            if (ten > 0 && five > 0) { // Prefer to give one $10 and one $5 bill as change
                ten--;
                five--;
            } else if (five >= 3) { // Otherwise, give three $5 bills as change
                five -= 3;
            } else {
                return false; // Can't give change, return false
            }
        }
    }
    return true; // Successfully provided change to all customers
}
