package br.edu.fecap.projetoquarta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button BotaoLimpar;
    Button BotaoVerificar;
    EditText tarefa1, tarefa2, tarefa3, tarefa4, tarefa5;
    CheckBox Check1, Check2, Check3, Check4, Check5;

    ImageView IMGTrab, IMGEscola, IMGPessoal;
    TextView Resultado, TextPre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BotaoLimpar = findViewById(R.id.btnClear);
        BotaoVerificar = findViewById(R.id.btnVerify);
        tarefa1 = findViewById(R.id.T1);
        tarefa2 = findViewById(R.id.T2);
        tarefa3 = findViewById(R.id.T3);
        tarefa4 = findViewById(R.id.T4);
        tarefa5 = findViewById(R.id.T5);

        Check1 = findViewById(R.id.cb1);
        Check2 = findViewById(R.id.cb2);
        Check3 = findViewById(R.id.cb3);
        Check4 = findViewById(R.id.cb4);
        Check5 = findViewById(R.id.cb5);

        Resultado = findViewById(R.id.Result);

        IMGTrab = findViewById(R.id.imgT);
        IMGEscola = findViewById(R.id.imgE);
        IMGPessoal = findViewById(R.id.imgP);

        TextPre = findViewById(R.id.TextImg);

    }

public void setT(View view){
        TextPre.setText("LISTA DE TAREFAS DO TRABALHO: ");
}
public void setE(View view){
        TextPre.setText("LISTA DE TAREFAS DA ESCOLA: ");
}

public void SetP(View view){
        TextPre.setText("LISTA DE TAREFAS PESSOAL: ");
}

    // Metodo para limpar os campos de texto
    public void Clean(View view) {
        tarefa1.setText("");
        tarefa2.setText("");
        tarefa3.setText("");
        tarefa4.setText("");
        tarefa5.setText("");
    }

    public void Verify(View view) {
        //um array para armazenar as tarefas pendentes para printar depois
        ArrayList<String> TarefasPendentes = new ArrayList<>();


        if(!Check1.isChecked()){
            TarefasPendentes.add("TAREFA 1 PENDENTE");
        }
        if(!Check2.isChecked()){
            TarefasPendentes.add("TAREFA 2 PENDENTE");
        }
        if(!Check3.isChecked()){
            TarefasPendentes.add("TAREFA 3 PENDENTE");
        }
        if(!Check4.isChecked()){
            TarefasPendentes.add("TAREFA 4 PENDENTE");
        }
        if(!Check5.isChecked()){
            TarefasPendentes.add("TAREFA 5 PENDENTE");
        }
        //logica para o alertDialog

        if(TarefasPendentes.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("PARABENS!!!");
            builder.setMessage("VOCE COMPLETOU TODAS AS SUAS TAREFAS PENDENTES!!!");
            AlertDialog dialog = builder.create();
            dialog.show();
        }


        StringBuilder Resultados = new StringBuilder();
        for(String tarefa : TarefasPendentes){
            Resultados.append(tarefa).append("\n");
        }
        //print
        Resultado.setText(Resultados.toString());

    }
}
