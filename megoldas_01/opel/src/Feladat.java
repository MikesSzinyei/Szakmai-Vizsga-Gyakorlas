import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Feladat {
    ArrayList<Jarmu> jarmuLista = new ArrayList<>();
    ArrayList<Jarmu> opel_lista = new ArrayList<>();

    public void readFile() {
        try {
            tryReadFile();
        } catch (Exception e) {
            System.err.println("Hiba! A file nem található");
            System.err.println(e.getMessage());
        }
    }
    public void tryReadFile() throws FileNotFoundException{
        File file = new File("jarmuvek_opel.csv");
        Scanner sc = new Scanner(file);
        String elsoSor = sc.nextLine();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(":");
            Jarmu jarmu = new Jarmu();
            jarmu.az = Integer.parseInt(lineArray[0]);
            jarmu.rendszam = lineArray[1];
            jarmu.marka = lineArray[2];
            jarmu.urtartalom = Integer.parseInt(lineArray[3]);
            jarmu.ar = Double.parseDouble(lineArray[4]);
            jarmuLista.add(jarmu);
        }
        // System.out.println(jarmuLista.get(0).rendszam);
    }
    public void kivonat() {
        for(Jarmu jarmu: jarmuLista) {
            if(jarmu.marka.equals("Opel")) {
                opel_lista.add(jarmu);
            }
        }
    }

    public void write_file() {
        try {
            tryWrite_file();
        } catch (IOException e) {
            System.err.println("Hiba! A file nem írható");
            System.err.println(e.getMessage());
        }
    }
    public void tryWrite_file() throws IOException {
        FileWriter fw = new FileWriter("onlyopel.csv");
        for(Jarmu jarmu : opel_lista) {
            fw.write(jarmu.az.toString());
            fw.write(":");
            fw.write(jarmu.rendszam);
            fw.write(":");
            fw.write(jarmu.marka);
            fw.write(":");
            fw.write(jarmu.urtartalom.toString());
            fw.write(":");
            fw.write(jarmu.ar.toString());
            fw.write("\n");
        }
        fw.close();
    }
}
