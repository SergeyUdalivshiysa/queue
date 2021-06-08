package ru.volegov.messagequeue.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class DatabaseInit {

    public static void initializeDatabase() {

        InputStream in = DatabaseInit.class.getClassLoader().getResourceAsStream("static/init.sql");
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (in, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
