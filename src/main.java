import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.security.SecureRandom;

public class main {

    // Details

    /* TO-DO
    public static String store_name = "Amy's Convenience Store";
    public static int cost = 2;
    * */

    public static void main(String[] args) {

        LotteryTicket lottery_ticket = new LotteryTicket("lfl");

        lottery_ticket.run_lottery();
    }
}
