package wordsCounter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueWordsCounter {

    public static void main(String [] args) throws IOException {
        File inputFile = new File("src/main/resources/inputFile.txt");
        File outputFile = new File("output.txt");

        List<String> lines = FileUtils.readLines(inputFile,"UTF-8");
        Set<String> uniqueWords = new HashSet<>();

        for(String line : lines){
            String[] words = StringUtils.split(line);
            for(String word :words){
                uniqueWords.add(word);
            }
        }
        FileUtils.writeStringToFile(outputFile,String.valueOf(uniqueWords.size()),"UTF-8");
        System.out.println(uniqueWords.size());
    }
}
