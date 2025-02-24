/*
 * @fileoverview    {AppTester}
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

import com.project.dev.flag.processor.Flag;
import com.project.dev.flag.processor.FlagProcessor;

/**
 * TODO: Description of {@code AppTester}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public class AppTester {

    /**
     * Ejecuta las pruebas de la aplicación.
     *
     * @param args argumentos de la linea de comandos.
     * @return {@code true} si se ejecutan las pruebas correctamente, {@code false} caso contrario.
     */
    public static boolean startTesting(String[] args) {
        boolean result = false;
        String requiredFlags[][] = {
            {"-urlsFilePath"},
            {"-outputPath"}
        };

        String optionalFlags[][] = {};

        String defaultArgs[] = {
            "-urlsFilePath",
            "res\\urls.xml",
            "-outputPath",
            "res\\output"
        };

        Flag[] flags = FlagProcessor.convertArgsToFlags(args, defaultArgs, requiredFlags, optionalFlags, true);
        if (flags != null)
            result = ProcessorTester.processFlags(flags);

        return result;
    }

}
