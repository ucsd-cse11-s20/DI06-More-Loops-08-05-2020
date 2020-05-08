class LoopExamples {
    static int initialize(int i) {
        System.out.println("Initializing to " + i);
        return i;
    }

    static boolean condition(boolean b) {
        System.out.println("Condition is " + b);
        return b;
    }

    static int update(int i) {
        System.out.println("Updating to " + i);
        return i;
    }

    public static void main(String[] args) {
        for (int i = initialize(1); condition(i <= 3); i = update(i + 1)) {
            System.out.println("The loop body: Loop variable is " + i);
        }
        System.out.println("exit");
    }
}