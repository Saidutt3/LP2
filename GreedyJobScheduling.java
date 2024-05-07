import java.util.Scanner;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class GreedyJobScheduling {

    public static void printJobScheduling(Job[] jobs) {
        int n = jobs.length;
        sortJobs(jobs);

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        boolean[] slot = new boolean[maxDeadline];
        char[] result = new char[maxDeadline];

        for (int i = 0; i < maxDeadline; i++) {
            slot[i] = false;
            result[i] = '\0';
        }

        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("Job Sequence:");
        for (char job : result) {
            if (job != '\0') {
                System.out.print(job + " ");
            }
        }
        System.out.println();
        System.out.println("Total Profit: " + totalProfit);
    }

    public static void sortJobs(Job[] jobs) {
        for (int i = 0; i < jobs.length; i++) {
            for (int j = 0; j < jobs.length - 1 - i; j++) {
                if (jobs[j].profit < jobs[j + 1].profit) {
                    Job temp = jobs[j];
                    jobs[j] = jobs[j + 1];
                    jobs[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of jobs: ");
        int n = scanner.nextInt();

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter job id, deadline, and profit (separated by spaces): ");
            char id = scanner.next().charAt(0);
            int deadline = scanner.nextInt();
            int profit = scanner.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        printJobScheduling(jobs);

        scanner.close();
    }
}
