package ro.sci.carrental.io;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class TxtReader {
    private static final Logger LOGGER = Logger.getLogger(TxtReader.class.getName());



    public List<String> readLines(File file) {
        Charset charset = Charset.forName("UTF8");

        List<String> readList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                readList.add(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARN, "IO exception found!" + e);
        }
        return readList;
    }




}
