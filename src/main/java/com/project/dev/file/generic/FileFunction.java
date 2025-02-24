/*
 * @fileoverview    {FileFunction}
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
package com.project.dev.file.generic;

import java.util.List;
import lombok.NonNull;

/**
 * TODO: Description of {@code FileFunction}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public class FileFunction {

    /**
     * Muestra el contenido de un {@code String} y es un ejemplo de {@code Function} que puede ser
     * usada como parámetro de {@code forEachLine} para mostar cada línea del archivo.
     *
     * @param line es un {@code String} que contiene una línea de un archivo.
     * @return {@code true}.
     */
    public static boolean printLine(@NonNull String line) {
        System.out.println(line);
        return true;
    }

    /**
     * Muestra el contenido de un {@code String} si contiene un url y es un ejemplo de
     * {@code Function} que puede ser usada como parámetro de {@code forEachLine}.
     *
     * @param line es un {@code String} que contiene una línea de un archivo.
     * @return {@code true}.
     */
    public static boolean printUrl(@NonNull String line) {
        if (line.matches("(http://|https://).*?"))
            System.out.println(line);
        return true;
    }

    /**
     * Almacena un {@code String} en un {@code List} y es un ejemplo de {@code BiFunction} que puede
     * ser usada como parámetro de {@code forEachLine} para almacenar cada línea del archivo en una
     * lista.
     *
     * @param line es un {@code String} que contiene una línea de un archi.vo.
     * @param list es la lista donde se guardará el {@code line}.
     * @return {@code true}.
     */
    public static boolean addLineToList(@NonNull String line, @NonNull List<String> list) {
        list.add(line);
        return true;
    }

    /**
     * Agrega un {@code String} a un {@code List} si el {@code String} es el url de una página y es
     * un ejemplo de {@code BiFunction} que puede ser usada como parámetro de {@code forEachLine}
     *
     * @param line es el {@code String} que se va a validar.
     *
     * @param list es la lista donde se almacenará el {@code String}.
     * @return {@code true}.
     */
    public static boolean addUrlToList(@NonNull String line, @NonNull List<String> list) {
        if (line.matches("(http://|https://).*?"))
            list.add(line);
        return true;
    }

}
