package CodeForcesVIrtual67;
import java.util.*;
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sc.nextInt();
            sb.append(67).append('\n');
        }
        System.out.print(sb);
    }


    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public int distMoney(int money, int children) {
        money -= children;
        if (money < 0) return -1;

        int eight = Math.min(money / 7, children);
        money -= eight * 7;
        int remaining = children - eight;

        if (remaining == 0 && money > 0) {
            eight--;
            remaining++;
            money += 7;
        }

        if (remaining == 1 && money == 3) {
            eight--;
            money += 7;
        }

        return eight;
    }


    public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 2; i--) {
                if (nums[i - 2] + nums[i - 1] > nums[i]) {
                    return nums[i - 2] + nums[i - 1] + nums[i];
                }
            }
            return 0;
    }


        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalTank = 0, currTank = 0, start = 0;

            for (int i = 0; i < gas.length; i++) {
                int diff = gas[i] - cost[i];
                totalTank += diff;
                currTank += diff;

                if (currTank < 0) {
                    start = i + 1;
                    currTank = 0;
                }
            }

            return totalTank >= 0 ? start : -1;
        }

}
