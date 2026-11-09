public class AgeDistribution {
    public static void main(String[] args) {
        final int REITERATIONS = 1000;
        final int MAXAGE = 35;

        // {cumulative upper bound, age}
        int agedistribution[][] = {
                {10, 20},   // 10 %  -> random numbers 1..10
                {30, 21},   // 20 %  -> 11..30
                {60, 22},   // 30 %  -> 31..60
                {80, 23},   // 20 %  -> 61..80
                {95, 25},   // 15 %  -> 81..95
                {100, 30},  //  5 %  -> 96..100
        };

        int generatedAges[] = new int[MAXAGE+1];

        // Generate ages according to the distribution
        for (int i = 1; i <= REITERATIONS; i++) {
            int x = (int)(Math.random()*100)+1;
            int j = 0;
            while (x > agedistribution[j][0]) j++;
            generatedAges[agedistribution[j][1]]++;
        }

        // Output
        System.out.println("Age  count     %-share");
        for (int age = 0; age <= MAXAGE; age++) {
            if (generatedAges[age] != 0) {
                String str = "%-4d %-8d %-8.2f\n";
                System.out.printf(str, age, generatedAges[age],((double)generatedAges[age])/REITERATIONS*100);
            }
        }
    }
}
