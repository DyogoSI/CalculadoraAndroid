package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Calculator";

    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;

    private Button buttonZero, buttonUm, buttonDois, buttonTres, buttonQuatro;
    private Button buttonCinco, buttonSeis, buttonSete, buttonOito, buttonNove, buttonVirgula;

    private Button buttonSoma, buttonSubtracao, buttonMultiplicacao, buttonDivisao;
    private Button buttonPorcento, buttonDelete, buttonReset, buttonIgual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

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

        // Novo appendListener com verificação de "Erro"
        View.OnClickListener appendListener = v -> {
            Button b = (Button) v;
            String current = textViewResultado.getText().toString();
            if (current.equals("Erro")) {
                textViewResultado.setText("");
            }
            textViewResultado.append(b.getText());
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
                    double value = Double.parseDouble(current);
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
                }
            }
        });
    }
}
