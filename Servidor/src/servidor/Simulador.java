package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel2
 */
public class Simulador extends Thread {

    double valor = 1;
    int i = 1;
    double max = 0.02, min = -0.01;
    double aux;
    Socket clientSocket;

    Random rand = new Random();

    @Override
    public void run() {
        while (true) {
            /*try {
                //aux = rand.nextFloat() * max + min;
                //valor = valor + aux;
                recibirValor();
                //System.out.println(aux + "\t"+valor);
            } catch (IOException ex) {
                Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }

    public int getValor() {
       // System.out.println(valor % 10);
        return (int) (valor % 10);

    }

    public void recibirValor() throws IOException {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                valor = Integer.parseInt(inputLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}