package com.gameware.tcc2.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class GamewareUtils {
	
    private static void eraseTime(Calendar cal)  
    {  
        cal.set(Calendar.HOUR, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);          
    }  
      
    public static long retornaDiaSemana(long dateLong, Date date, boolean isPrimeiroDia ) {  
        final long millisPorDia = 1000 * 60 * 60 * 24;  

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long time = dateLong;
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK); 
  
        //Calculo do primeiro dia da semana  
        long primeiroDiaDaSemana = time - ((diaDaSemana - Calendar.SUNDAY) * millisPorDia);  
        Calendar primeiroDia = Calendar.getInstance();  
        primeiroDia.setTimeInMillis(primeiroDiaDaSemana);  
        eraseTime(primeiroDia);  
          
        //Calculo do último dia da semana  
        long ultimoDiaDaSemana = time + ((Calendar.SATURDAY - diaDaSemana) * millisPorDia);  
        Calendar ultimoDia = Calendar.getInstance();  
        ultimoDia.setTimeInMillis(ultimoDiaDaSemana);  
        eraseTime(ultimoDia);  
        
        if (isPrimeiroDia){
        	return primeiroDiaDaSemana;
        }
        else{
        	return ultimoDiaDaSemana;
        }
    }
    
    public static boolean dataMaiorAtual (String dia, String mes, String ano) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
    	String dataConc = dia+mes+ano;
    	Date data = sdf.parse(dataConc);
    	
    	if (data.after(new Date())){
    		return true;
    	}
    	
    	return false;
    }
    
    public static boolean dataMaiorAtual (String mes, String ano) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
    	String dataConc = "01"+mes+ano;
    	Date data = sdf.parse(dataConc);
    	
    	if (data.after(new Date())){
    		return true;
    	}
    	
    	return false;
    }
    
    public static boolean dataMaiorAtual (String ano) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
    	String dataConc = "01"+"01"+ano;
    	Date data = sdf.parse(dataConc);
    	
    	if (data.after(new Date())){
    		return true;
    	}
    	
    	return false;
    }
    
    public static String adicionaZeroEsquerdaDiaMes (int originalNumber){
    	String number = String.valueOf(originalNumber);
    	if (number.length()==1){
    		number = 0+number;
    	}
    	return number;
    }
    
	public static boolean validaData(String data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		try {
			df.parse(data);
		} catch (ParseException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}
}