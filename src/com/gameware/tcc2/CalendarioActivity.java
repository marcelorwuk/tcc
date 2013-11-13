package com.gameware.tcc2;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.gameware.tcc2.utils.Constants;
import com.gameware.tcc2.utils.GamewareUtils;

@SuppressLint("SimpleDateFormat")
public class CalendarioActivity extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendario);
		Intent it = getIntent();
		Bundle bundle = it.getExtras();
		Integer periodOption = bundle.getInt(Constants.SESSION_PERIOD_OPTION);
		TextView textView = (TextView) findViewById(R.id.textView_selecione_periodo);
		TextView textView1 = (TextView) findViewById(R.id.textView_ate);
		DatePicker datePicker = (DatePicker) findViewById(R.id.seletor_data);
		DatePicker datePicker1 = (DatePicker) findViewById(R.id.seletor_data1);
		if (periodOption==Constants.PERIODO_DIA){
			datePicker.setVisibility(View.VISIBLE);
			textView.setText("Selecione o Dia desejado");
		}else if (periodOption==Constants.PERIODO_SEM){
			CalendarView calendar = (CalendarView)findViewById(R.id.calendario);
			Date dataAtual = new Date();
			calendar.setVisibility(View.VISIBLE);
			calendar.setMaxDate(dataAtual.getTime());
			
			textView.setText("Selecione a Semana desejada");
		}else if (periodOption==Constants.PERIODO_MES){
			datePicker.setVisibility(View.VISIBLE);
			try {
			    Field f[] = datePicker.getClass().getDeclaredFields();
			    for (Field field : f) {
			        if (field.getName().equals("mDaySpinner")) {
			            field.setAccessible(true);
			            Object dayPicker = new Object();
			            dayPicker = field.get(datePicker);
			            ((View) dayPicker).setVisibility(View.GONE);
			        }
			    }
			} catch (SecurityException e) {
			    Log.d("ERROR", e.getMessage());
			} 
			catch (IllegalArgumentException e) {
			    Log.d("ERROR", e.getMessage());
			} catch (IllegalAccessException e) {
			    Log.d("ERROR", e.getMessage());
			}
			textView.setText("Selecione o Mês desejado");
		}else if (periodOption==Constants.PERIODO_ANO){
			datePicker.setVisibility(View.VISIBLE);
			try {
			    Field f[] = datePicker.getClass().getDeclaredFields();
			    for (Field field : f) {
			        if (field.getName().equals("mDaySpinner")) {
			            field.setAccessible(true);
			            Object dayPicker = new Object();
			            dayPicker = field.get(datePicker);
			            ((View) dayPicker).setVisibility(View.GONE);
			        }
			        if (field.getName().equals("mMonthSpinner")) {
			            field.setAccessible(true);
			            Object dayPicker = new Object();
			            dayPicker = field.get(datePicker);
			            ((View) dayPicker).setVisibility(View.GONE);
			        }
			    }
			} catch (SecurityException e) {
			    Log.d("ERROR", e.getMessage());
			} 
			catch (IllegalArgumentException e) {
			    Log.d("ERROR", e.getMessage());
			} catch (IllegalAccessException e) {
			    Log.d("ERROR", e.getMessage());
			}
			textView.setText("Selecione o Ano desejado");
		}else if (periodOption==Constants.PERIODO_PER){
			datePicker.setVisibility(View.VISIBLE);
			textView1.setVisibility(View.VISIBLE);
			datePicker1.setVisibility(View.VISIBLE);
			textView.setText("Selecione o Período desejado");
		}
	}

	@SuppressLint("NewApi")
	public void onButtonClick (View v) throws ParseException{
		Intent it = getIntent();
		Bundle bundle = it.getExtras();
		Integer periodOption = bundle.getInt(Constants.SESSION_PERIOD_OPTION);
		
		DatePicker datePicker = (DatePicker)findViewById(R.id.seletor_data);
		DatePicker datePicker1 = (DatePicker)findViewById(R.id.seletor_data1);
		CalendarView calendarView = (CalendarView)findViewById(R.id.calendario);
		
		String dataConsulta = "";
		String dataConsulta1 = "";
		boolean errorFound = false;
	if (R.id.button_ok==v.getId()){	
		if (periodOption==Constants.PERIODO_DIA){
			Integer dia = datePicker.getDayOfMonth();
			Integer mes = datePicker.getMonth()+1;
			Integer ano = datePicker.getYear();
			
			if (GamewareUtils.dataMaiorAtual(GamewareUtils.adicionaZeroEsquerdaDiaMes(dia),GamewareUtils.adicionaZeroEsquerdaDiaMes(mes), String.valueOf(ano))){
				Toast.makeText(CalendarioActivity.this, "Data Inválida.", Toast.LENGTH_SHORT).show();
				errorFound=true;
			}
			
			dataConsulta = GamewareUtils.adicionaZeroEsquerdaDiaMes(dia)+GamewareUtils.adicionaZeroEsquerdaDiaMes(mes)+String.valueOf(ano);
			dataConsulta1 = GamewareUtils.adicionaZeroEsquerdaDiaMes(dia)+GamewareUtils.adicionaZeroEsquerdaDiaMes(mes)+String.valueOf(ano);
			
		}else if (periodOption==Constants.PERIODO_MES){
			Integer mes = datePicker.getMonth()+1;
			Integer ano = datePicker.getYear();
			
			if (GamewareUtils.dataMaiorAtual(GamewareUtils.adicionaZeroEsquerdaDiaMes(mes), String.valueOf(ano))){
				Toast.makeText(CalendarioActivity.this, "Data Inválida.", Toast.LENGTH_SHORT).show();
				errorFound=true;
			}
			
			dataConsulta = "01"+GamewareUtils.adicionaZeroEsquerdaDiaMes(mes)+String.valueOf(ano);
			dataConsulta1 = "30"+GamewareUtils.adicionaZeroEsquerdaDiaMes(mes)+String.valueOf(ano);
			
		}else if (periodOption==Constants.PERIODO_SEM){
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

			Date date = new Date(calendarView.getDate());

			dataConsulta = sdf.format(new Date(GamewareUtils.retornaDiaSemana(calendarView.getDate(), date, true)));
			dataConsulta1 = sdf.format(new Date(GamewareUtils.retornaDiaSemana(calendarView.getDate(), date, false)));
			
		}else if (periodOption==Constants.PERIODO_ANO){
			Integer ano = datePicker.getYear();

			if (GamewareUtils.dataMaiorAtual(String.valueOf(ano))){
				Toast.makeText(CalendarioActivity.this, "Ano Inválido.", Toast.LENGTH_SHORT).show();
				errorFound=true;
			}
			
			dataConsulta = "0101"+String.valueOf(ano);
			dataConsulta1 = "3112"+String.valueOf(ano);
			
			System.out.println(ano);
		}else if (periodOption==Constants.PERIODO_PER){
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			
			String dia = GamewareUtils.adicionaZeroEsquerdaDiaMes(datePicker.getDayOfMonth());
			String mes = GamewareUtils.adicionaZeroEsquerdaDiaMes(datePicker.getMonth()+1);
			String ano = String.valueOf(datePicker.getYear());
			String dia1 = GamewareUtils.adicionaZeroEsquerdaDiaMes(datePicker1.getDayOfMonth());
			String mes1 = GamewareUtils.adicionaZeroEsquerdaDiaMes(datePicker1.getMonth()+1);
			String ano1 = String.valueOf(datePicker1.getYear());
			
			Date data = sdf.parse(dia+mes+ano);
			Date data1 = sdf.parse(dia1+mes1+ano1);
			
			if (data.after(data1) || GamewareUtils.dataMaiorAtual(dia1,mes1,ano1)){
				Toast.makeText(CalendarioActivity.this, "Período Inválido.", Toast.LENGTH_SHORT).show();
				errorFound=true;
			}
			
			dataConsulta = dia+mes+ano;
			dataConsulta1 = dia1+mes1+ano1;

		}
		if (!errorFound){
		bundle.putString(Constants.SESSION_DATE_QUERY, dataConsulta);
		bundle.putString(Constants.SESSION_DATE_QUERY1, dataConsulta1);
		Intent intent = new Intent(CalendarioActivity.this,TelaFaturamentoPeriodoActivity.class);
		intent.putExtras(bundle);
		startActivity(intent);					
		}
	}
  }
}