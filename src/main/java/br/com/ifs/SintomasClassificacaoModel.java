package br.com.ifs;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SINTOMASCLASSIFICACAO")
public class SintomasClassificacaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int tempoAtendimentoMinutos;
	private String sintomas, classificacao, local, grupo, tempoAtendimentoImediato,fluxograma;

	public String getFluxograma() {
		return fluxograma;
	}

	public void setFluxograma(String fluxograma) {
		this.fluxograma = fluxograma;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTempoAtendimentoImediato() {
		return tempoAtendimentoImediato;
	}

	public void setTempoAtendimentoImediato(String tempoAtendimentoImediato) {
		this.tempoAtendimentoImediato = tempoAtendimentoImediato;
	}

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

	@Override
	public String toString() {
		return "SintomasClassificacaoModel [id=" + id + ", tempoAtendimentoMinutos=" + tempoAtendimentoMinutos
				+ ", sintomas=" + sintomas + ", classificacao=" + classificacao + ", local=" + local + ", grupo="
				+ grupo + ", tempoAtendimentoImediato=" + tempoAtendimentoImediato + ", fluxograma=" + fluxograma + "]";
	}


	
}
