package commons;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import model.Directory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandle {

    //  dau phan casch cot
    public static final char DEFAULT_SEPARATOR = ',';
    //  phan cach phan tu
    public static final char DEFAULT_QUOTE = '"';
    // the line number to skip for start reading
    public static final int NUM_OF_LINE_SKIP = 1;

    public static final String pathDirectory = "./data/Directory.csv";


    public static String[] headerColDiectory = new String[]{"phoneNumber","name","group","gender","address","birthday","email"};

    public static void writeDrirectory(List<Directory> directoryList){

        try (Writer writer = new FileWriter(pathDirectory);
            CSVWriter csvWrite = new CSVWriter(
                    writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            )){
            csvWrite.writeNext(headerColDiectory);
            for (Directory directory: directoryList) {
                csvWrite.writeNext(new String[]{

                        directory.getPhoneNumber(),
                        directory.getName(),
                        directory.getGroup(),
                        String.valueOf(directory.getGender()),
                        directory.getAddress(),
                        String.valueOf(directory.getBirthday()),
                        directory.getEmail()
                });
            }
            csvWrite.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //readfile
    public static ArrayList<Directory> readDirectory(){
        String csvPath =pathDirectory;
        String[] headerRecord =headerColDiectory;

        Path path = Paths.get(csvPath);
        if(!Files.exists(path)){
            try {
                Writer writer = new FileWriter(csvPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Directory.class);
        strategy.setColumnMapping(headerRecord);

        //
        List<Directory> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder(new FileReader(csvPath))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return (ArrayList<Directory>) csvToBean;
    }
}
