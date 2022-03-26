import java.awt.*;
import java.io.*;

public class Simple {
    public static void main(String[] args) throws IOException {
        System.out.println("Привет, твои мечты начинают осуществлятся по поставленным целям " +
                "и самое главное их не забыть!");
        System.out.println("Работает он по принципу - идет запись пока ты не введешь слово 'exit'");
        Simple simple = new Simple();
        simple.getFill();
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("diary.txt"));
    }


    public BufferedReader setFill() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public void getFill() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter("diary.txt"))) {
            String line;
            System.out.println("Идет запись");
            wr.write("Мой план:" + "\n");
            Thread.sleep(3000);
            while (!((line = setFill().readLine()).equals("exit"))) {
                wr.write(line + "\n");
            }
            System.out.println("Запись закончена");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}



