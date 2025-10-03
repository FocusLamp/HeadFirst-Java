// A
class StreamingSong {
    String title;
    String artist;
    int duration;

    void play() {
        System.out.println("Playing song");
    }

    void printDetails() {
        System.out.println("This is " + title + "by " + artist);
    }
}

class StreamingSongTestDrive {
    public static void main(String[] args) {
        StreamingSong song = new StreamingSong();
        song.artist = "The beatles";
        song.title = "Come Tegther";
        song.play();
        song.printDetails();
    }
}


// ======================================================
// B
class Episode {
    int seriesNumber;
    int episodeNumber;

    void skipIntro() {
        System.out.println("Skipping intro...");
    }
    void skipToNext() {
        System.out.println("Loading next episode...");
    }
    void play() {
        System.out.println("Playing Episode...");
    }
}

class EpisodeTestDrive {
    public static void main(String[] args) {
        Episode episode = new Episode();
        episode.seriesNumber = 4;
        episode.play();
        episode.skipIntro();
    }
}

