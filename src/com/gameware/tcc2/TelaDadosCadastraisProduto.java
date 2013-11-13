package com.gameware.tcc2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class TelaDadosCadastraisProduto extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_dados_cadastrais_produto);
		Spinner seletorDesconto = (Spinner) findViewById(R.id.seletor_desconto);
		seletorDesconto.setEnabled(false);
	}

	public void onButtonClick (View v){
		CheckBox checkBoxEditar = (CheckBox) findViewById(R.id.checkBox_editar);

		if (R.id.checkBox_editar==v.getId()){
			if (checkBoxEditar.isChecked()){
				CheckBox checkBoxDesconto = (CheckBox) findViewById(R.id.checkBox_desconto);
				checkBoxDesconto.setVisibility(View.VISIBLE);
				CheckBox checkBoxValidade = (CheckBox) findViewById(R.id.checkBox_validade);
				checkBoxValidade.setVisibility(View.VISIBLE);
				EditText textFieldDescricao = (EditText) findViewById(R.id.text_descricao);
				textFieldDescricao.setEnabled(true);
				Spinner seletorCategoria = (Spinner) findViewById(R.id.seletor_categoria);
				seletorCategoria.setEnabled(true);
				EditText textFieldQuantidadeEstoque = (EditText) findViewById(R.id.text_qtde_estoque);
				textFieldQuantidadeEstoque.setEnabled(true);
				EditText textFieldValor = (EditText) findViewById(R.id.text_valor);
				textFieldValor.setEnabled(true);
			}
			else if (!checkBoxEditar.isChecked()){
				CheckBox checkBoxDesconto = (CheckBox) findViewById(R.id.checkBox_desconto);
				checkBoxDesconto.setVisibility(View.GONE);
				CheckBox checkBoxValidade = (CheckBox) findViewById(R.id.checkBox_validade);
				checkBoxValidade.setVisibility(View.GONE);
				EditText textFieldDescricao = (EditText) findViewById(R.id.text_descricao);
				textFieldDescricao.setEnabled(false);
				Spinner seletorCategoria = (Spinner) findViewById(R.id.seletor_categoria);
				seletorCategoria.setEnabled(false);
				EditText textFieldQuantidadeEstoque = (EditText) findViewById(R.id.text_qtde_estoque);
				textFieldQuantidadeEstoque.setEnabled(false);
				EditText textFieldValor = (EditText) findViewById(R.id.text_valor);
				textFieldValor.setEnabled(false);
			}
		}
		else if (R.id.button_excluir==v.getId()){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Você tem certeza que deseja excluir este registro?")
					.setCancelable(false)
					.setPositiveButton("Sim",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									dialog.cancel();
								}
							})
					.setNegativeButton("Não",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									dialog.cancel();
								}
							});
			AlertDialog alert = builder.create();
			alert.show();
		}else if (R.id.checkBox_validade==v.getId()){
			CheckBox checkBoxValidade = (CheckBox) findViewById(R.id.checkBox_validade);
			if (checkBoxValidade.isChecked()){
				EditText textFieldValidadePreco = (EditText) findViewById(R.id.text_validade_preco);
				textFieldValidadePreco.setEnabled(true);
			}
			else if (!checkBoxValidade.isChecked()){
				EditText textFieldValidadePreco = (EditText) findViewById(R.id.text_validade_preco);
				textFieldValidadePreco.setEnabled(false);
			}
		}else if (R.id.checkBox_desconto==v.getId()){
			CheckBox checkBoxDesconto = (CheckBox) findViewById(R.id.checkBox_desconto);
			if (checkBoxDesconto.isChecked()){
				Spinner seletorDesconto = (Spinner) findViewById(R.id.seletor_desconto);
				seletorDesconto.setEnabled(true);
			}
			else if (!checkBoxDesconto.isChecked()){
				Spinner seletorDesconto = (Spinner) findViewById(R.id.seletor_desconto);
				seletorDesconto.setEnabled(false);
			}
		}
		
	}
}
