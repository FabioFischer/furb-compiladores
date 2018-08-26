package constants;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

public class ScannerResources {
    private int[][] scannerTable;

    public ScannerResources() {
        try {
            this.setScannerTable(ScannerResources.class.getResourceAsStream("scanner-table.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int[][] getScannerTable() {
        return this.scannerTable;
    }

    private void setScannerTable(InputStream inputStream) throws IOException {
        String[] mapRow = readFile(inputStream).split("([|])+");

        int[][] map = new int[mapRow.length][];

        for (int i = 0; i < mapRow.length; i++) {
            String[] mapCol = mapRow[i].split("([,])+");
            int[] tempCol = new int[mapCol.length];

            for (int j = 0; j < mapCol.length; j++) {
                tempCol[j] = Integer.parseInt(mapCol[j]);
            }

            map[i] = tempCol;
        }

        this.scannerTable = map;
    }

    private String readFile(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder str = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            str.append(line);
        }
        reader.close();

        return str.toString();
    }
}
