package Utilities;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class FileReader {

//    public static File getFileUsingPageSize( String pageSize) {
//        try {
//            File folder = Paths.get(ClassLoader.getSystemResource("requestBody/pdf").toURI()).toFile();
//            File[] listOfFiles = folder.listFiles((d, name) -> name.endsWith(".pdf"));
        public static File getFileUsingPageSize(final String pageSize, final String fileType) {
            try {
                File folder = Paths.get(ClassLoader.getSystemResource("requestBody/" + fileType).toURI()).toFile();
                File[] listOfFiles = folder.listFiles((d, name) -> name.endsWith(fileType.toLowerCase()));
            Optional<File> fileOptional = Arrays.stream(Objects.requireNonNull(listOfFiles))
                    .filter(file -> file.getName().matches("[^0-9]*" + pageSize + "[^0-9]*"))
                    .findAny();
            String filePath = fileOptional
                    .map(File::getAbsolutePath)
                    .orElseGet(() -> Objects.requireNonNull(listOfFiles)[(int) (Math.random() * listOfFiles.length)].getAbsolutePath());
            return new File(filePath.replace("\\target\\test-classes", "\\src\\test\\resources"));
        } catch (URISyntaxException exception) {
            System.out.println(exception.getMessage());
            return null;
        }

    }
}