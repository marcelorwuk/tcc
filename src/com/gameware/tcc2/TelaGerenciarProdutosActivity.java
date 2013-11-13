package com.gameware.tcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaGerenciarProdutosActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_gerenciar_produtos);
	}

	public void onButtonClick (View v){
		
		if (R.id.button_cadastrar_produto==v.getId()){
			Intent intent = new Intent(TelaGerenciarProdutosActivity.this,TelaCadastroProduto.class);
			startActivity(intent);			
		}
		else if (R.id.button_dados_cadastrais==v.getId()){
			Intent intent = new Intent(TelaGerenciarProdutosActivity.this,TelaDadosCadastraisProduto.class);
			startActivity(intent);			
		}
	}
}
