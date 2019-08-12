package ie.distilledsch.codekata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Song implements GrammarCheck {

    private static final int MIN_ANIMALS = 2;
    private static final int MAX_ANIMALS = 7;

    String sing(List<String> animals) throws RuntimeException {
        if (animals.size() >= MIN_ANIMALS && animals.size() <= MAX_ANIMALS){
            return generateLyrics(animals);
        }
        throw new RuntimeException("The list of animals must contain between " + MIN_ANIMALS +" and " + MAX_ANIMALS + " animals.");
    }

    String generateLyrics(List<String> animals){
        StringBuilder lyrics = new StringBuilder();
        lyrics.append(generateFirstVerse(animals.get(0)));
        for (int i=2;i < animals.size();i++){
            lyrics.append(generateMiddleVerse(animals, i));
        }
        lyrics.append(generateFinalVerse(animals.get(animals.size()-1)));
        return lyrics.toString();
    }

    String generateFirstVerse(String firstAnimal){
        String nounDescriptor = shouldUseAOrAn(firstAnimal);

        return SongLyrics.FIRST_LINE
            + nounDescriptor
            + firstAnimal
            + "."
            + SongLyrics.LINEBREAK
            + SongLyrics.SECOND_LINE_PART_ONE
            + nounDescriptor
            + firstAnimal
            + SongLyrics.SECOND_LINE_PART_TWO
            + SongLyrics.LINEBREAK
            + SongLyrics.LINEBREAK;
    }

    String generateMiddleVerse(List<String> animals, int currentVerse){
        String nounDescriptor = shouldUseAOrAn(animals.get(currentVerse-1));
        StringBuilder middleVerse = new StringBuilder();
        middleVerse.append(SongLyrics.FIRST_LINE)
            .append(nounDescriptor)
            .append(animals.get(currentVerse-1))
            .append(";")
            .append(SongLyrics.LINEBREAK);
        middleVerse.append(getVerseLine(currentVerse, nounDescriptor, animals.get(currentVerse-1)));
        for (int i = currentVerse-1; i > 0; i--){
            middleVerse.append("She swallowed the ")
                .append(animals.get(i))
                .append(" to catch the ")
                .append(animals.get(i-1))
                .append(";")
                .append(SongLyrics.LINEBREAK);
        }
        middleVerse.append(SongLyrics.SECOND_LINE_PART_ONE)
            .append(shouldUseAOrAn(animals.get(0)))
            .append(animals.get(0))
            .append(SongLyrics.SECOND_LINE_PART_TWO)
            .append(SongLyrics.LINEBREAK)
            .append(SongLyrics.LINEBREAK);
        return middleVerse.toString();
    }

    String generateFinalVerse(String finalAnimal){
        return SongLyrics.FIRST_LINE
            + shouldUseAOrAn(finalAnimal)
            + finalAnimal
            + "..."
            + SongLyrics.LINEBREAK
            + SongLyrics.FINAL_LINE;
    }

    private String getVerseLine(int currentVerse, String nounDescriptor, String currentAnimal){
        StringBuilder verseLine = new StringBuilder();
        switch (currentVerse){
            case 2:
                verseLine.append(SongLyrics.SECOND_VERSE)
                    .append(SongLyrics.LINEBREAK);
                break;
            case 3:
                verseLine.append(SongLyrics.THIRD_VERSE)
                    .append(nounDescriptor)
                    .append(currentAnimal)
                    .append(".")
                    .append(SongLyrics.LINEBREAK);
                break;
            case 4:
                verseLine.append(SongLyrics.FOURTH_VERSE)
                    .append(nounDescriptor)
                    .append(currentAnimal)
                    .append(".")
                    .append(SongLyrics.LINEBREAK);
                break;
            case 5:
                verseLine.append(SongLyrics.FIFTH_VERSE)
                    .append(nounDescriptor)
                    .append(currentAnimal)
                    .append(".")
                    .append(SongLyrics.LINEBREAK);
                break;
            case 6:
                verseLine.append(SongLyrics.SIXTH_VERSE)
                    .append(nounDescriptor)
                    .append(currentAnimal)
                    .append(".")
                    .append(SongLyrics.LINEBREAK);
                break;
        }
        return verseLine.toString();
    }

    public String shouldUseAOrAn(String animal){
        // note: this won't cover all cases, but it's the best we can do for now
        List<String> firstLettersToUseAnFor = Stream.of("a", "e", "i", "o")
            .collect(Collectors.toList());

        String firstLetterOfAnimal = String.valueOf(animal.charAt(0));

        return (firstLettersToUseAnFor.stream().anyMatch(str -> str.equals(firstLetterOfAnimal)))
            ? "an "
            : "a ";
    }

}
