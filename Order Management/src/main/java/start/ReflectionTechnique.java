package start;

import java.lang.reflect.Field;

/**
 * Clasa care foloseste tehnica reflexiei pentru a extrage proprietatile si valorile proprietatilor unui obiect.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ReflectionTechnique {
    /**
     * Metoda care extrage proprietatile unui obiect.
     *
     * @param object Obiectul caruia vrem sa ii extragem proprietatile.
     * @return String[] Vectorul de proprietati ai obiectului primit ca parametru.
     */
    public static String[] retrieveFieldProperties(Object object) {
        String[] fields = new String[object.getClass().getDeclaredFields().length];
        int i = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                fields[i] = field.getName();
                i++;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return fields;
    }

    /**
     * Metoda care extrage valorile proprietatilor unui obiect.
     *
     * @param object Obiectul caruia vrem sa ii extragem valorile proprietatilor.
     * @return String[] Vectorul de valori ale proprietatilor obiectului primit ca parametru.
     */
    public static String[] retrieveValueProperties(Object object) {
        String[] fields = new String[object.getClass().getDeclaredFields().length];
        int i = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
                fields[i] = "" + value;
                i++;
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fields;
    }
}
