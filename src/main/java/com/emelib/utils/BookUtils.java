package com.emelib.utils;

import com.emelib.entities.Book;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BookUtils {
    public static String getBookLink(Book book) {
        return "<a href=\"/book?id=\"" + book.getId() + "\">" + book.getName() + "</a>";
    }

    public static StringBuffer getBookText(Book book, boolean isAvailable) throws IOException {
        StringBuffer buffer = new StringBuffer();
//        File file = book.getFile();
//        FileReader reader= new FileReader(file);
//        Scanner scan = new Scanner(reader);
//
//        while (scan.hasNextLine()) {
//            buffer.append(scan.nextLine());
//        }
        Files.lines(Paths.get(book.getFile()), StandardCharsets.UTF_8).forEach(buffer::append);
//        reader.close();
        if (isAvailable) {
            return buffer;
        } else {
            buffer.substring((int) (buffer.length() * 0.2));
        }
        return buffer;
    }
}
