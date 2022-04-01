package br.com.aluno.app12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private EditText metEmail;
  private EditText metSenha;
  private Button mbtnSalvar;
  SharedPreferences sp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    metEmail = findViewById(R.id.etEmail);
    metSenha = findViewById(R.id.etSenha);
    mbtnSalvar = findViewById(R.id.btnSalvar);
    sp = getSharedPreferences("MeusDados.dat", Context.MODE_PRIVATE);
    metEmail.setText( sp.getString("email", "") ) ;
  }

  public void gravarDados(View v){
    sp = getSharedPreferences("MeusDados.dat", Context.MODE_PRIVATE);
    SharedPreferences.Editor ed;
    ed = sp.edit();
    ed.putString("email", metEmail.getText().toString());
    ed.putString("senha", metSenha.getText().toString());
    ed.apply();
    Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
  }
}