package ie.distilledsch.codekata;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class SongTest {

    private Song song = new Song();

    @Test(expected = RuntimeException.class)
    public void testSongWithNoAnimalsThrowsException(){
        song.sing(new ArrayList<>());
    }

    @Test
    public void testGenerateFirstVerse(){
        String lyrics = "There was an old lady who swallowed a moose.\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n";

        assertEquals("First verse should be generated correctly", lyrics, song.generateFirstVerse("moose"));
    }

    @Test
    public void testGenerateFinalVerse(){
        String lyrics = "There was an old lady who swallowed a cheetah...\n" +
            "...She's dead, of course!";

        assertEquals("First verse should be generated correctly", lyrics, song.generateFinalVerse("cheetah"));
    }

    @Test
    public void testSongWithTwoAnimals(){
        List<String> animals = Stream.of("moose", "goose")
            .collect(Collectors.toList());

        String lyrics = "There was an old lady who swallowed a moose.\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a goose...\n" +
            "...She's dead, of course!";

        assertEquals("Lyrics should include two animals", lyrics, song.sing(animals));
    }

    @Test
    public void testGenerateLyricsWithFiveAnimals(){
        List<String> animals = Stream.of("moose", "goose", "llama", "frog", "cheetah")
            .collect(Collectors.toList());

        String lyrics = "There was an old lady who swallowed a moose.\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a goose;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the goose to catch the moose;\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a llama;\n" +
            "How absurd to swallow a llama.\n" +
            "She swallowed the llama to catch the goose;\n" +
            "She swallowed the goose to catch the moose;\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a frog;\n" +
            "Fancy that to swallow a frog.\n" +
            "She swallowed the frog to catch the llama;\n" +
            "She swallowed the llama to catch the goose;\n" +
            "She swallowed the goose to catch the moose;\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cheetah...\n" +
            "...She's dead, of course!";

        assertEquals("Lyrics should include five animals", lyrics, song.generateLyrics(animals));
    }

    @Test
    public void testSongWithSevenAnimals(){
        List<String> animals = Stream.of("moose", "goose", "llama", "frog", "cheetah", "tiger", "lion")
            .collect(Collectors.toList());

        String lyrics = "There was an old lady who swallowed a moose.\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a goose;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the goose to catch the moose;\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a llama;\n" +
            "How absurd to swallow a llama.\n" +
            "She swallowed the llama to catch the goose;\n" +
            "She swallowed the goose to catch the moose;\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a frog;\n" +
            "Fancy that to swallow a frog.\n" +
            "She swallowed the frog to catch the llama;\n" +
            "She swallowed the llama to catch the goose;\n" +
            "She swallowed the goose to catch the moose;\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cheetah;\n" +
            "What a hog, to swallow a cheetah.\n" +
            "She swallowed the cheetah to catch the frog;\n" +
            "She swallowed the frog to catch the llama;\n" +
            "She swallowed the llama to catch the goose;\n" +
            "She swallowed the goose to catch the moose;\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a tiger;\n" +
            "I don't know how she swallowed a tiger.\n" +
            "She swallowed the tiger to catch the cheetah;\n" +
            "She swallowed the cheetah to catch the frog;\n" +
            "She swallowed the frog to catch the llama;\n" +
            "She swallowed the llama to catch the goose;\n" +
            "She swallowed the goose to catch the moose;\n" +
            "I don't know why she swallowed a moose - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a lion...\n" +
            "...She's dead, of course!";

        assertEquals("Lyrics should include seven animals", lyrics, song.sing(animals));
    }

    @Test
    public void testShouldUseAOrAn(){
        assertEquals("Animal beginning with the letter a should require an", "an ", song.shouldUseAOrAn("alligator"));
        assertEquals("Animal beginning with the letter e should require an", "an ", song.shouldUseAOrAn("emu"));
        assertEquals("Animal beginning with the letter i should require an", "an ", song.shouldUseAOrAn("iguana"));
        assertEquals("Animal beginning with the letter o should require an", "an ", song.shouldUseAOrAn("octopus"));
        assertEquals("Animal not beginning with the letters a,e,i,o should require a", "a ", song.shouldUseAOrAn("giraffe"));
    }

    @Test(expected = RuntimeException.class)
    public void testSongWithEightAnimalsThrowsException(){
        List<String> animals = Stream.of("llama", "frog", "cheetah", "tiger", "lion", "chicken", "pig", "butterfly")
            .collect(Collectors.toList());

        song.sing(animals);
    }
}
