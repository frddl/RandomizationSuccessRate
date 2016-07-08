import java.util.Random;

public class Main {
    static Random r = new Random();
    static int max = r.nextInt(10000), 
        ran1 = r.nextInt(100000),
        ran2 = r.nextInt(100000),
        ran3 = r.nextInt(100000),
        temp1 = 0, 
        temp2 = 0, 
        temp3 = 0, 
        changed = 0, 
        checkbox = 1;

    public static void main(String[] args) {
        System.out.print("Total " + max + " loop(s). | ");

        for (int i = 0; i < max; i++) {
            assign1(ran1);
            assign2(ran2);
            assign3(ran3);
            printInitials(checkbox);
        
            int ran12 = r.nextInt(100000), ran22 = r.nextInt(100000), ran32 = r.nextInt(100000);
        
            if (bigger(ran12 * ran22 * ran32, ran1 * ran2 * ran3)) {
                ran1 = ran12;
                ran2 = ran22;
                ran3 = ran32;
                changed++;
                System.out.println("Result: " + ran12 * ran22 * ran32 + ", (" + changed + ": " + ran1 + ", " + ran2 + ", " + ran3 + ");");
            }
        }

        System.out.println("\nSo, final randoms: " + ran1 + ", " + ran2 + ", " + ran3 + ".");
        
        System.out.println("Total " + changed + " successful swaps.");
        
        System.out.println("Success rate is " + changed + "/" + max + ", " + round(changed * 1.0 / max, 10) + "%.");
    }

    public static void printInitials(int a) {
        if (a > 0) 
            System.out.println("Initial randoms: " + temp1 + ", " + temp2 + ", " + temp3 + ".\n");
        checkbox = 0;
    }
    
    public static void assign1(int a) {
        if (temp1 == 0)
            temp1 = a;
    }
    
    public static void assign2(int a) {
        if (temp2 == 0)
        temp2 = a;
    }
    
    public static void assign3(int a) {
        if (temp3 == 0)
        temp3 = a;
    }
    
    public static boolean bigger(int a, int b) {
        if (a > b) 
            return true;
        else 
            return false;
    }
    
    public static double round(double value, int places) {
        return (double) Math.round(value * ((long) Math.pow(10, places))) / (long) Math.pow(10, places);
    }
}
