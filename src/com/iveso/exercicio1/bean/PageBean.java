package com.iveso.exercicio1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean implements Serializable {
	
	
	private List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	private List<Integer> valores;
	private int quantidade;
	private int minimo;
	private int maximo;
	
	public String doGenerate() {
		valores = new ArrayList<Integer>();
		
		if (maximo < minimo) {
			
			for (int i = 0; i < quantidade; i++) {
				valores.add(0);
			}
			return null;
		}
		
		for (int i = 0; i < quantidade; i++) {
			int num = validate(minimo, maximo);
			valores.add(num);
		}
		
		return null;
	}
	
	public List<Integer> getNumeros() {
		return numeros;
	}
	
	public List<Integer> getValores() {
		return valores;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public int getMinimo() {
		return minimo;
	}
	
	public int getMaximo() {
		return maximo;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
	private int validate(int min, int max) {
		Random random = new Random();
		int num = 0;
		max++;
		
		num = random.nextInt(max);
		while (num < minimo) {
			num = random.nextInt(max);
		}
		return num;
	}
}
