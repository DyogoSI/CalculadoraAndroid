package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD

=======
>>>>>>> b5c5bc7d32de23c83399f244328b1fd8b1eb503f
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonIgual;
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;

=======
    private static final String TAG = "Calculator";

    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;

    private Button buttonZero, buttonUm, buttonDois, buttonTres, buttonQuatro;
    private Button buttonCinco, buttonSeis, buttonSete, buttonOito, buttonNove, buttonVirgula;

    private Button buttonSoma, buttonSubtracao, buttonMultiplicacao, buttonDivisao;
    private Button buttonPorcento, buttonDelete, buttonReset, buttonIgual;

>>>>>>> b5c5bc7d32de23c83399f244328b1fd8b1eb503f
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

<<<<<<< HEAD
        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculable avaliadorExpressao = null;
                try {
                    String expressao = "5+1+4*2";
                    avaliadorExpressao = new ExpressionBuilder(expressao).build();

                    Double resultado = avaliadorExpressao.calculate();

                    textViewUltimaExpressao.setText(expressao);
                    textViewResultado.setText(resultado.toString());
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
=======
        buttonZero    = findViewById(R.id.buttonZeroID);
        buttonUm      = findViewById(R.id.buttonUmID);
        buttonDois    = findViewById(R.id.buttonDoisID);
        buttonTres    = findViewById(R.id.buttonTresID);
        buttonQuatro  = findViewById(R.id.buttonQuatroID);
        buttonCinco   = findViewById(R.id.buttonCincoID);
        buttonSeis    = findViewById(R.id.buttonSeisID);
        buttonSete    = findViewById(R.id.buttonSeteID);
        buttonOito    = findViewById(R.id.buttonOitoID);
        buttonNove    = findViewById(R.id.buttonNoveID);
        buttonVirgula = findViewById(R.id.buttonVirgulaID);

        buttonSoma          = findViewById(R.id.buttonSomaID);
        buttonSubtracao     = findViewById(R.id.buttonSubtracaoID);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivisao       = findViewById(R.id.buttonDivisaoID);
        buttonPorcento      = findViewById(R.id.buttonPorcentoID);
        buttonDelete        = findViewById(R.id.buttonDeleteID);
        buttonReset         = findViewById(R.id.buttonResetID);
        buttonIgual         = findViewById(R.id.buttonIgualID);

        // Listener com substituição de operador e limpeza do Erro
        View.OnClickListener appendListener = v -> {
            Button b = (Button) v;
            String symbol = b.getText().toString();
            String current = textViewResultado.getText().toString();

            // Limpa se estiver com "Erro"
            if (current.equals("Erro")) {
                current = "";
            }

            // Substitui operador anterior se necessário
            if (!current.isEmpty()) {
                char lastChar = current.charAt(current.length() - 1);
                boolean lastIsOperator = "+-×÷".indexOf(lastChar) != -1;
                boolean newIsOperator = "+-×÷".contains(symbol);

                if (lastIsOperator && newIsOperator) {
                    current = current.substring(0, current.length() - 1) + symbol;
                    textViewResultado.setText(current);
                    return;
                }
            }

            textViewResultado.setText(current + symbol);
        };

        buttonZero.setOnClickListener(appendListener);
        buttonUm.setOnClickListener(appendListener);
        buttonDois.setOnClickListener(appendListener);
        buttonTres.setOnClickListener(appendListener);
        buttonQuatro.setOnClickListener(appendListener);
        buttonCinco.setOnClickListener(appendListener);
        buttonSeis.setOnClickListener(appendListener);
        buttonSete.setOnClickListener(appendListener);
        buttonOito.setOnClickListener(appendListener);
        buttonNove.setOnClickListener(appendListener);
        buttonVirgula.setOnClickListener(appendListener);

        buttonSoma.setOnClickListener(appendListener);
        buttonSubtracao.setOnClickListener(appendListener);
        buttonMultiplicacao.setOnClickListener(appendListener);
        buttonDivisao.setOnClickListener(appendListener);

        buttonPorcento.setOnClickListener(v -> {
            String current = textViewResultado.getText().toString();
            if (!current.isEmpty()) {
                try {
                    double value = Double.parseDouble(current.replace(",", "."));
                    value /= 100.0;
                    textViewResultado.setText(String.valueOf(value));
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Erro ao calcular %", e);
                }
            }
        });

        buttonDelete.setOnClickListener(v -> {
            String current = textViewResultado.getText().toString();
            if (!current.isEmpty()) {
                textViewResultado.setText(current.substring(0, current.length() - 1));
            }
        });

        buttonReset.setOnClickListener(v -> {
            textViewResultado.setText("");
            textViewUltimaExpressao.setText("");
        });

        buttonIgual.setOnClickListener(v -> {
            String expr = textViewResultado.getText().toString();
            if (!expr.isEmpty()) {
                String evalExpr = expr
                        .replace("÷", "/")
                        .replace("×", "*")
                        .replace(",", ".");

                try {
                    Calculable calc = new ExpressionBuilder(evalExpr).build();
                    double result = calc.calculate();
                    textViewUltimaExpressao.setText(expr);
                    textViewResultado.setText(String.valueOf(result));
                } catch (Exception e) {
                    textViewResultado.setText("Erro");
                    Log.e(TAG, "Erro na avaliação", e);
>>>>>>> b5c5bc7d32de23c83399f244328b1fd8b1eb503f
                }
            }
        });
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> b5c5bc7d32de23c83399f244328b1fd8b1eb503f
