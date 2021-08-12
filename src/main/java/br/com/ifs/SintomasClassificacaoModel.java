package br.com.ifs;

public class SintomasClassificacaoModel {
	private String sintomas, classificacao, local, grupo, tempoAtendimentoImediato;
	
	public String getTempoAtendimentoImediato() {
		return tempoAtendimentoImediato;
	}

	public void setTempoAtendimentoImediato(String tempoAtendimentoImediato) {
		this.tempoAtendimentoImediato = tempoAtendimentoImediato;
	}

	private int tempoAtendimentoMinutos;

	public int getTempoAtendimentoMinutos() {
		return tempoAtendimentoMinutos;
	}

	public void setTempoAtendimentoMinutos(int tempoAtendimento) {
		this.tempoAtendimentoMinutos = tempoAtendimento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
}
