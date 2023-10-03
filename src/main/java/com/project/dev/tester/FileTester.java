/*
 * @fileoverview    {FileTester}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.project.dev.tester;

import com.project.dev.file.generic.FileProcessor;
import com.project.dev.flag.processor.Flag;
import com.project.dev.flag.processor.FlagMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO: Definición de {@code FileTester}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class FileTester {

    /**
     * TODO: Definición de {@code addUrlsToList}.
     *
     * @param line
     * @param list
     * @return
     */
    private static boolean addUrlsToList(String line, List<String> list) {
        if (line.matches("(http://|https://).*?"))
            list.add(line);
        return true;
    }

    /**
     * TODO: Definición de {@code processFlags}.
     *
     * @param flags
     * @return
     */
    public static boolean processFlags(Flag[] flags) {
        boolean result;

        Map<String, String> flagsMap = FlagMap.convertFlagsArrayToMap(flags);
        String urlsFilePath = flagsMap.get("-urlsFilePath");
        String outputPath = flagsMap.get("-outputPath");

        if (!FileProcessor.validateFile(urlsFilePath)) {
            System.out.println("Invalid file in flag '-urlsFilePath'");
            result = false;
        } else if (!FileProcessor.validatePath(outputPath) && !new File(outputPath).mkdirs()) {
            System.out.println("Invalid path in flag '-outputPath'");
            result = false;
        } else {
            List<String> urls = new ArrayList<>();
            result = FileProcessor.forEachLine(urlsFilePath, FileTester::addUrlsToList, urls);

            System.out.println("Urls:");
            urls.forEach(url -> System.out.println(url));
            System.out.println("");
        }
        return result;
    }

}
