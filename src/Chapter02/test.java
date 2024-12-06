class test {
    public static void main(String[] args) {        
        String input = "2 4";
        int[] newInput = new int[2];

        String[] inputArray = input.split(" ");
        for (int i = 0; i < inputArray.length; i++) {
            newInput[i] = Integer.parseInt(inputArray[i]);
        }
        System.out.println(newInput[0] + newInput[1]);


        // System.out.println(input.getClass());

    }
}
