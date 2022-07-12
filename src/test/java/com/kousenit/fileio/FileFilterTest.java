package com.kousenit.fileio;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileFilterTest {
    private final File root = new File("src/main/java/com/kousenit");

    // list all files in the root directory
    @Test
    public void listFiles() {
        File[] files = root.listFiles();
        assertNotNull(files);
        assertEquals(20, files.length);
    }

    // list all directories in root
    @Test
    public void listDirectories_anonInnerClass() {
        File[] directories = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        assertNotNull(directories);
        assertEquals(20, directories.length);
    }

    // list all directories in root
    @Test
    public void listDirectories_expressionLambda() {
        // File[] directories = root.listFiles((File file) -> file.isDirectory());
        //File[] directories = root.listFiles(file -> file.isDirectory());
        File[] directories = root.listFiles(File::isDirectory);
        assertNotNull(directories);
        assertEquals(20, directories.length);
    }

    private boolean isEvenLength(File file) {
        return file.getName().length() % 2 == 0;
    }

    @Test
    public void listEvenLengthFiles_fileFilter_methodReference() {
        File[] files = root.listFiles(this::isEvenLength);
        assertNotNull(files);
        assertEquals(12, files.length);
    }

    // list all directories in root
    @Test
    public void listEvenLengthFilenames_filenameFilter_expressionLambda() {
        File[] files = root.listFiles((dir, name) -> name.length() % 2 == 0);
        assertNotNull(files);
        for (File file : files) {
            System.out.println(file.getName() + " (" + file.getName().length() + ")");
        }
        Arrays.asList(files).forEach(System.out::println);
        assertEquals(12, files.length);
    }

}
