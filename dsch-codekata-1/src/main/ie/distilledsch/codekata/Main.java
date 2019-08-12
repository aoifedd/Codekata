package ie.distilledsch.codekata;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Song song = new Song();
        System.out.println(song.sing(Arrays.stream(args).collect(Collectors.toList())));
    }
}
