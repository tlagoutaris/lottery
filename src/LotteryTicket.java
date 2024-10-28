import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.security.SecureRandom;

public class LotteryTicket {

    // Lottery details
    public String lottery_name;

    // Lottery ticket properties
    public int num_normal_balls;
    public int num_special_balls;
    public int normal_ball_range;
    public int special_ball_range;

    // Lottery ticket numbers
    public Set<Integer> lottery_set;
    public Set<Integer> lottery_special_set;
    public ArrayList<Integer> lottery_ticket_nums;
    public ArrayList<Integer> special_lottery_ticket_nums;

    // Constructor
    public LotteryTicket(String lottery_name) {
        this.lottery_name = lottery_name;
        setLottery();
    }

    public void setLottery() {
        if (lottery_name.equalsIgnoreCase("Powerball") || lottery_name.equalsIgnoreCase("Power Ball") || lottery_name.equalsIgnoreCase("PB")) {
            this.lottery_name = "Powerball";
            this.num_normal_balls = 5;
            this.num_special_balls = 1;
            this.normal_ball_range = 69;
            this.special_ball_range = 26;
        } else if (lottery_name.equalsIgnoreCase("Mega Millions") || lottery_name.equalsIgnoreCase("Mega Million") || lottery_name.equalsIgnoreCase("MM")) {
            this.lottery_name = "Mega Millions";
            this.num_normal_balls = 5;
            this.num_special_balls = 1;
            this.normal_ball_range = 70;
            this.special_ball_range = 25;
        } else if (lottery_name.equalsIgnoreCase("Lucky For Life") || lottery_name.equalsIgnoreCase("LFL")) {
            this.lottery_name = "Lucky For Life";
            this.num_normal_balls = 5;
            this.num_special_balls = 1;
            this.normal_ball_range = 48;
            this.special_ball_range = 18;
        } else {
            System.out.println("Invalid lottery name.");
        }
    }

    public void run_lottery() {
        SecureRandom r = new SecureRandom();

        try {

            lottery_set = new HashSet<>();

            // Normal balls
            while (lottery_set.size() < num_normal_balls) {
                int ball = r.nextInt(1, normal_ball_range + 1);
                lottery_set.add(ball);
            }

            // Add to final lottery ticket
            lottery_ticket_nums = new ArrayList<>(lottery_set);

            // Sort normal balls
            Collections.sort(lottery_ticket_nums);

            lottery_special_set = new HashSet<>();

            // If special balls
            if (num_special_balls > 0) {
                while (lottery_special_set.size() < num_special_balls) {
                    int ball = r.nextInt(1, special_ball_range + 1);
                    lottery_special_set.add(ball);
                }
            }

            // Add special set to special list
            special_lottery_ticket_nums = new ArrayList<>(lottery_special_set);

            // order the special balls
            Collections.sort(special_lottery_ticket_nums);

            // Add ordered list to final lottery ticket
            lottery_ticket_nums.addAll(special_lottery_ticket_nums);

            print_ticket();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void print_ticket() {
        System.out.println("\nFinal lottery ticket: ");
        for (int i = 0; i < num_normal_balls; i++) {
            System.out.print(lottery_ticket_nums.get(i) + " ");
        }

        for (int i = num_normal_balls; i < lottery_ticket_nums.size(); i++) {
            System.out.print("*" + lottery_ticket_nums.get(i) + " "); // Add star(s) for special ball
        }
    }

    public void print_lottery_details() {
        System.out.println("Lottery name: " + lottery_name);
        System.out.println("Number of normal balls: " + num_normal_balls);
        System.out.println("Number of special balls: " + num_special_balls);
        System.out.println("Normal ball range: " + normal_ball_range);
        System.out.println("Special ball range: " + special_ball_range);
    }
}
