package ro.sci.carrental.io;





public interface Convertor <T> {


    /**
     * Convert string lines
     * @param convertedString lines of strings
     * @return .
     * @throws InvalidEntityException .
     */
    T convert(String convertedString) throws InvalidEntityException;
}

