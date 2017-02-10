package com.example.guillermomarquezru.androidproject;

import java.io.FileOutputStream;
import java.util.*;


public class MyRandom {
	static Random R=new Random();
	public static int nextInt(int Num){
		return R.nextInt(Num);
	}
	public static int nextInt(int LimInf,int LimSup){
		return R.nextInt(  LimSup-LimInf+1)+LimInf;
	}
	
	
	static String [] Nom={"Alicia","Sofia","Juan","Arturo","Eliseo","Federico","Natalia"};
	static String [] Ap={"Lopez","Perez","Garcia","Hernandez","Rodriguez","Pe�a","Nieto"};
	public static String nextName(){
		return Nom[nextInt(Nom.length)]+" "+Ap[ nextInt(Ap.length)]+" "+Ap[nextInt(Ap.length)];   
		
	}

	 public static String PonBlancos(String Nom,int Ancho){
	       for(int i=0;Nom.length()<Ancho;i++)
	          Nom=Nom+" ";
	          return Nom;
	  }
	 
	 public static String PonCeros(int Valor,int Tam){
			String Cad=Valor+"";
			while(Cad.length()<Tam)
				Cad="0"+Cad;
			return Cad;
		}
	 public static double Redondear(double numero,int digitos)
	 {
	       int cifras=(int) Math.pow(10,digitos);
	       return Math.rint(numero*cifras)/cifras;
	 }


}
