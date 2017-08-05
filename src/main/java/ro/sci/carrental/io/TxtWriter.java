package ro.sci.carrental.io;

import java.io.File;
import java.util.List;

public interface TxtWriter<T> {


    /**
     * Write in a txt file
     * @param t Object to be written
     * @param file Destination file
     */
    void writeObj(List<T> t, File file);
}
