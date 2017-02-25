package ru.job4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Aleksandr Smirnov.
 */
public class FileSort {
    /**
     * Файл с неотсортированными строками.
     */
    private File sour = new File("E:\\Java programm\\project\\Alexandr_Smirnov\\chap_003\\src\\main\\resources\\Sources");
    /**
     * Файл для хранения осортированных сторк.
     */
    private File dist = new File("E:\\Java programm\\project\\Alexandr_Smirnov\\chap_003\\src\\main\\resources\\Distance");
    /**
     * Разделитель строк
     */
    private final String separator = System.getProperty("line.separator");
    /**
     * Главный метод сортировки.
     * @param source   - файл для сортировки.
     * @param distance - записываем отсортированные строки.
     */
    public void sort(File source, File distance) {
        clearDistance(distance);
        mainSort(source, distance);
    }
    /**
     * Метод удаляет все данные в файле.
     * @param distance - файл с данными.
     */
    public void clearDistance(File distance) {
        try (RandomAccessFile dis = new RandomAccessFile(distance, "rw")) {
            dis.setLength(0);
            dis.writeBytes("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод  разделяет файл на две части.
     * @param source   - файл с данными.
     * @param distance - пустой файл.
     */
    public void mainSort(File source, File distance) {
        File firstFile = new File("FirstFile.txt");
        File secondFile = new File("SecondFile.txt");
        int fileNumber = 0;
        int rowFileOne = 0;
        int rowFileTwo = 0;
        try (RandomAccessFile sour = new RandomAccessFile(source, "r");
             RandomAccessFile first = new RandomAccessFile(firstFile, "rw");
             RandomAccessFile second = new RandomAccessFile(secondFile, "rw")) {
            String line;
            while ((line = sour.readLine()) != null) {
                if (fileNumber == 0) {
                    first.writeBytes(line);
                    first.writeBytes(separator);
                    fileNumber = 1;
                    rowFileOne++;
                } else {
                    second.writeBytes(line);
                    second.writeBytes(separator);
                    fileNumber = 0;
                    rowFileTwo++;
                }
            }
            String[] str1 = sortArray(rowFileOne, firstFile);
            String[] str2 = sortArray(rowFileTwo, secondFile);
            getSortDistance(str1, str2, distance);
            first.close();
            firstFile.deleteOnExit();
            second.close();
            secondFile.deleteOnExit();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод дергает из файла строку и сохраняет её в String[] и сортирует получившийся массив.
     * @param row - размер массива.
     * @param file - файл с данными.
     */
    public String[] sortArray(int row, File file) {
        try (RandomAccessFile first = new RandomAccessFile(file, "rw")) {
            String[] strings = new String[row];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = first.readLine();
                for (int j = 0; j < i; j++) {
                    if (strings[i].length() < strings[j].length()) {
                        String temp;
                        temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод формирует отсортированный файл.
     * @param oneArray - первый отсортированный массив.
     * @param twoArray - второй отсортированный массив.
     * @param distance - пустой файл.
     */
    public void getSortDistance(String[] oneArray, String[] twoArray, File distance) {
        try (RandomAccessFile dis = new RandomAccessFile(distance, "rw")) {
            int arrayLength = oneArray.length + twoArray.length;
            int j = 0, k = 0;
            dis.seek(0);
            String line;
            for (int i = 0; i < arrayLength; i++) {
                if (j >= oneArray.length) {
                    line = twoArray[k];
                    dis.writeBytes(line);
                    dis.writeBytes(separator);
                    k++;
                } else if (k >= twoArray.length) {
                    line = oneArray[j];
                    dis.writeBytes(line);
                    dis.writeBytes(separator);
                    j++;
                } else if (oneArray[j].length() < twoArray[k].length()) {
                    line = oneArray[j];
                    dis.writeBytes(line);
                    dis.writeBytes(separator);
                    j++;
                } else if (oneArray[j].length() > twoArray[k].length()) {
                    line = twoArray[k];
                    dis.writeBytes(line);
                    dis.writeBytes(separator);
                    k++;
                } else if (oneArray[j].length() == twoArray[k].length()) {
                    line = oneArray[j];
                    dis.writeBytes(line);
                    dis.writeBytes(separator);
                    line = twoArray[k];
                    dis.writeBytes(line);
                    dis.writeBytes(separator);
                    i++;
                    j++;
                    k++;
                }
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}