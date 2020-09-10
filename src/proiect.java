import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class proiect {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        citire citire1 = new citire();
        citire1.citire();
        System.out.println("\n");

        parcurgere temp = new parcurgere();
        parcurgere umid = new parcurgere();
        parcurgere viteza = new parcurgere();
        parcurgere prezenta = new parcurgere();

        temp.temperatura();
        umid.umiditate();
        viteza.viteza();
        prezenta.prezenta();

    }

}

class citire {

    public void citire() {

        try {

            BufferedReader citit = new BufferedReader(new FileReader("C:/Users/FetCatz/Desktop/Date _orig.csv"));
            String rand;

            while ( (rand = citit.readLine()) != null) {

                System.out.println(rand);

            }
        } catch (Exception e) {

            System.err.println(e.getMessage());

        }
    }
}

class parcurgere {

    int k = 0;
    int z = 0;

    File in = new File("C:/Users/FetCatz/Desktop/Date _orig.csv");
    List<String> lines = Files.readAllLines(in.toPath());
    FileWriter date_temp = new FileWriter("C:/Users/FetCatz/Desktop/Andrada/date_temperatura.csv");
    FileWriter date_umid = new FileWriter("C:/Users/FetCatz/Desktop/Andrada/date_umiditate.csv");
    FileWriter date_viteza = new FileWriter("C:/Users/FetCatz/Desktop/Andrada/date_viteza.csv");
    FileWriter date_prezenta = new FileWriter("C:/Users/FetCatz/Desktop/Andrada/date_prezenta.csv");

    parcurgere() throws IOException {
    }

    public void temperatura()  {

        try {

            char bom = '\uFEFF';
            date_temp.write(bom);

            for (String line:lines) {

                String[] array = line.split(",");

                if (k == 0) {

                    date_temp.write(array[0] + "," + array[1] + "," + array[2] + "," + array[array.length-1] + "\n");
                    k = k + 1;

                }

                else {


                    boolean y = false;

                    if (Double.parseDouble(array[0]) < -5) {
                        array[0] = String.valueOf(-5);
                        y = true;
                    }
                    if ( Double.parseDouble(array[1]) < -5) {
                        array[1] = String.valueOf(-5);
                        y = true;
                    }
                    if (Double.parseDouble(array[2]) < -5) {
                        array[2] = String.valueOf(-5);
                        y = true;
                    }
                    if (Double.parseDouble(array[0]) > 5) {
                        array[0] = String.valueOf(5);
                        y = true;
                    }
                    if ( Double.parseDouble(array[1]) > 5) {
                        array[1] = String.valueOf(5);
                        y = true;
                    }
                    if (Double.parseDouble(array[2]) > 5) {
                        array[2] = String.valueOf(5);
                        y = true;
                    }
                    if (y) {

                        z++;
                    }

                    date_temp.write(array[0] + ", " + array[1] + ", " + array[2] + ", " + array[array.length-3] + "\n");
                    k++;

                }

            } date_temp.close();

            System.out.println("Numarul de erori in parsarea temperaturii: " + z);

        } catch (Exception e) {

            System.err.println(e);

        }
    }
    public void umiditate () {

        try {

            for (String line:lines) {

                String[] array = line.split(",");

                if (k == 0){

                    date_umid.write(array[3] + ", " + array[4] + ", " + array[5] + ", " + array[array.length-1] + "\n");
                    k = k + 1;

                }

                else {

                    boolean y = false;

                    if (Double.parseDouble(array[3]) < 40) {
                        array[3] = String.valueOf(40);
                        y = true;
                    }
                    if ( Double.parseDouble(array[4]) < 40) {
                        array[4] = String.valueOf(40);
                        y = true;
                    }
                    if (Double.parseDouble(array[5]) < 40) {
                        array[5] = String.valueOf(40);
                        y = true;
                    }
                    if (y) {
                        z++;
                    }

                    date_umid.write(array[3] + ", " + array[4] + ", " + array[5] + ", " + array[array.length-3] + "\n");
                    k++;

                }
            } date_umid.close();

            System.out.println("Numarul de erori in parsarea umiditatii: " + z);

        } catch (Exception e) {

            System.err.println(e);

        }
    }
    public void viteza () {

        try {

            for (String line:lines) {

                String[] array = line.split(",");

                if (k == 0){

                    date_viteza.write(array[6] + ", " + array[array.length-1] + "\n");
                    k = k + 1;

                }

                else {
                    array[6] = String.valueOf(Double.parseDouble(array[6]) + 1);
                    date_viteza.write(array[6] + ", " + array[array.length-3] + "\n");
                    k++;

                }
            } date_viteza.close();

        } catch (Exception e) {

            System.err.println(e);

        }
    }

    public void prezenta () {

        try {

            for (String line:lines) {

                String[] array = line.split(",");

                if (k == 0){

                    date_prezenta.write(array[7] + ", " + array[8] + ", " + array[array.length-1] + "\n");
                    k = k + 1;

                }

                else {

                    date_prezenta.write(array[7] + ", " + array[8] + ", " + array[array.length-3]  + "\n");
                    k++;

                }
            } date_prezenta.close();

        } catch (Exception e) {

            System.err.println(e);

        }
    }
}




