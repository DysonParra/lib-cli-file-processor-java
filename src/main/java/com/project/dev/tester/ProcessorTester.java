/*
 * @overview        {ProcessorTester}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.tester;

import com.project.dev.file.generic.FileFunction;
import com.project.dev.file.generic.FileProcessor;
import com.project.dev.flag.processor.Flag;
import com.project.dev.flag.processor.FlagMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO: Description of {@code ProcessorTester}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public class ProcessorTester {

    /**
     * Procesa las {@code Flag} pasadas por consola y ejecuta la función de prueba.
     *
     * @param flags son las {@code Flag} pasadas por consola.
     * @return {@code false} si ocurrió algún error durante la ejecución, caso contrario
     *         {@code true}.
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
            result = FileProcessor.forEachLine(urlsFilePath, FileFunction::addUrlToList, urls);

            System.out.println("Urls:");
            urls.forEach(url -> System.out.println(url));
        }

        return result;
    }

}
