class MyGuitar {
    public static void main(String[] args) {
        ElectricGuitar band = new ElectricGuitar();
        
        band.setBrand("The Walking Cats");
        band.setNumOfPickups(2);
        band.setRockStarUsesIt(true);
    }
}

class ElectricGuitar {
    String brand;
    int numOfPickups;
    boolean rockStarUsesIt;

    String getBrand() {
        return brand;
    }

    void setBrand(String aBrand) {
        brand = aBrand;
    }

    int getNumOfPickups() {
        return numOfPickups;
    }

    void setNumOfPickups(int num) {
        numOfPickups = num;
    }

    boolean getRockStarUsesIt() {
        return rockStarUsesIt;
    }

    void setRockStarUsesIt(boolean yesOrNo) {
        rockStarUsesIt = yesOrNo;
    }
}