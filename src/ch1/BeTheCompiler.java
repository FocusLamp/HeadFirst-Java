class BeTheCompiler {
    public static void main(String[] args) {

        // A
        int x1 = 1;
        while (x1 < 10) {
            x1++;
            if (x1 > 3) {
                System.out.println("big x");
            }
        }

        // B
        int x2 = 5;
        while (x2 > 1) {
            x2 = x2 - 1;
            if (x2 < 3) {
                System.out.println("small x");
            }
        }

        // C
        int x3 = 5;
        while (x3 > 1) {
            x3--;
            if (x3 < 3) {
                System.out.println("small x");
            }
        }
    }
}