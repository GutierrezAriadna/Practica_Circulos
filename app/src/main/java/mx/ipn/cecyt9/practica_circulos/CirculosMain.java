package mx.ipn.cecyt9.practica_circulos;

import android.app.Activity;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.*;


public class CirculosMain extends Activity {
    private EditText entrada;
    private TextView salida;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulos_main);
        entrada = (EditText) findViewById(R.id.Numero);
        salida = (TextView) findViewById(R.id.Imprimir);
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "! = ");
        HiloFactorial rs = new HiloFactorial(n);
        rs.run();
    }
    public void calcularOperacion2(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "f = ");
        HiloFibonacci rs = new HiloFibonacci(n);
        rs.run();
    }

    public int factorial(int n) {
        int res = 1;
        int aux = 100 / n;
        for (int i = 1; i <= n; i++) {
            res *= i;
            SystemClock.sleep(1000);
        }

        return res;

    }

    class HiloFactorial extends Thread {
        private int n, res;

        public HiloFactorial(int n) {

            this.n = n;
        }

        @Override
        public void run() {
            res = factorial(n);
            salida.append(res + "\n");
        }
    }
        
    class HiloFibonacci extends Thread {
        private int n, res;

        public HiloFibonacci(int n) {
            this.n = n;
        }


        @Override
        public void run() {
            res = fibonacci(n);
            salida.append(res + "\n");
        }
    }


    public int fibonacci(int n){
        int res = 0;
        int aux = 100 / n;
        if(n == 0){
            res = 0;
        }else
            for (int i = 0; i < n; i++) {
                res += Auxiliar(i);
            }
        return res;
    }

    public int Auxiliar(int n)
    {
        if (n>1){
            return Auxiliar(n-1) + Auxiliar(n-2);  //función recursiva
        }
        else if (n==1) {  // caso base
            return 1;
        }
        else if (n==0){  // caso base
            return 0;
        }
        else{ //error
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1;
        }
    }
}
