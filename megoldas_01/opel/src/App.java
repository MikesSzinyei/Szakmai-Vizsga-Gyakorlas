public class App {
    public static void main(String[] args) throws Exception {
        Feladat fel = new Feladat();
        fel.readFile();
        fel.kivonat();
        fel.write_file();   
    }
}
