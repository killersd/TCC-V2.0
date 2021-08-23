package br.com.ifs;

import java.util.List;

public class SintomasModel {
	public List<String> sintomas;

	public List<String> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<String> sintomas) {
		this.sintomas = sintomas;
	}

	@Override
	public String toString() {
		return "SintomasModel [sintomas=" + sintomas + "]";
	}
	
}
