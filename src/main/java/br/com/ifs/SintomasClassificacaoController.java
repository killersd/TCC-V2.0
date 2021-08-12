package br.com.ifs;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SintomasClassificacaoController {
	
	@RequestMapping("/exibirForm")
	public String exibirForm() {
		return "index";
	}
	
	@Autowired
	private KieSession session;

	@PostMapping("/SintomasClassificacaoModel")
	public SintomasClassificacaoModel classificarPaciente(@RequestBody SintomasClassificacaoModel sintomasClassificacao) {
		session.insert(sintomasClassificacao);
		session.fireAllRules();
		
		switch (sintomasClassificacao.getGrupo()) {
		case "criancas":
		sintomasClassificacao.setGrupo("Crianças");
		break;
		case "traumas":
		sintomasClassificacao.setGrupo("Traumas");
		break;
		case "problemasEmPartesDoCorpo":
		sintomasClassificacao.setGrupo("Problemas em partes do corpo");
		break;
		case "dores":
		sintomasClassificacao.setGrupo("Dores");
		break;
		case "sintomasComuns":
		sintomasClassificacao.setGrupo("Sintomas comuns");
		break;
		case "outros":
			sintomasClassificacao.setGrupo("Outros");
			break;
		}
		
		if(!sintomasClassificacao.getClassificacao().equalsIgnoreCase("VERDE")) {
			sintomasClassificacao.setLocal("HOSPITAL");			
		}else {
			sintomasClassificacao.setLocal("POSTO DE SAUDE");
		}
		
		switch (sintomasClassificacao.getClassificacao()) {
		case "VERMELHA":
			sintomasClassificacao.setTempoAtendimentoImediato("ATENDIMENTO IMEDIATO");
			break;
		case "LARANJA":
			sintomasClassificacao.setTempoAtendimentoImediato("ATENDIMENTO MUITO URGENTE");
			sintomasClassificacao.setTempoAtendimentoMinutos(10);
			break;	
		case "AMARELA":
			sintomasClassificacao.setTempoAtendimentoImediato("ATENDIMENTO URGENTE");
			sintomasClassificacao.setTempoAtendimentoMinutos(50);
			break;
		case "VERDE":
			sintomasClassificacao.setTempoAtendimentoImediato("ATENDIMENTO POUCO URGENTE");
			sintomasClassificacao.setTempoAtendimentoMinutos(120);
			break;
		}
		return sintomasClassificacao;
	}
}
