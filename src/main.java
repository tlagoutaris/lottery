import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.security.SecureRandom;

public class main {

    // Details
    public static String lottery_name = "Powerball";
    public static int num_normal_balls = 5;
    public static int num_special_balls = 1;
    public static int normal_ball_range = 69;
    public static int special_ball_range = 26;
    public static Set<Integer> lottery_set = new HashSet<>();
    public static Set<Integer> lottery_special_set = new HashSet<>();
    public static ArrayList<Integer> lottery_ticket_nums;
    public static ArrayList<Integer> special_lottery_ticket_nums;

    /* TO-DO
    public static String store_name = "Amy's Convenience Store";
    public static int cost = 2;
    * */

    public static void main(String[] args) {
        /*Scanner input = new Scanner(System.in);

        System.out.println("What lottery are you doing today?");
        String answer = input.nextLine();*/

        run_lottery("Powerball");
    }

    public static void run_lottery(String lottery_name) {
        SecureRandom r = new SecureRandom();

        if (lottery_name.equals("Powerball")) {
            // Normal balls
            while (lottery_set.size() < num_normal_balls) {
                int ball = r.nextInt(1, normal_ball_range + 1);
                lottery_set.add(ball);
            }

            // Add to final lottery ticket
            ArrayList<Integer> lottery_ticket_nums = new ArrayList<>(lottery_set);

            // Sort normal balls
            Collections.sort(lottery_ticket_nums);

            // Print normal balls
            //System.out.println("Normal balls: " + lottery_ticket_nums);

            // If special balls
            if (num_special_balls > 0) {
                while (lottery_special_set.size() < num_special_balls) {
                    int ball = r.nextInt(1, special_ball_range + 1);
                    lottery_special_set.add(ball);
                }
            }

            // Add special set to special list
            ArrayList<Integer> special_lottery_ticket_nums = new ArrayList<>(lottery_special_set);

            // order the special balls
            Collections.sort(special_lottery_ticket_nums);

            // Add ordered list to final lottery ticket
            lottery_ticket_nums.addAll(special_lottery_ticket_nums);

            // Print final ticket
            System.out.println("\nFinal lottery ticket: ");
            for (int i = 0; i < num_normal_balls; i++) {
                System.out.print(lottery_ticket_nums.get(i) + " ");
            }

            for (int i = num_normal_balls; i < lottery_ticket_nums.size(); i++) {
                System.out.print("*" + lottery_ticket_nums.get(i) + " ");
            }
        }
    }
}
