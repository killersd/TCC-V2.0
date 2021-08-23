package br.com.ifs;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BebeChorandoController {

	public static int maiorPrioridade = 10;
	public static List<String> sintomasSelecionados;
	public static String sintomaMaisGrave;
	public static HashMap<String, Integer> sintomas_e_prioridades = new HashMap<>();
	public static SintomasClassificacaoModel scm = new SintomasClassificacaoModel();;

	@GetMapping("/bebeChorando")
	public String mostrarEscolhaSintomas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "bebeChorando";
	}

	@PostMapping("/bebeChorando")
	public String selecionandoSintomas(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		BebeChorandoController.sintomasSelecionados = sintomasModel.getSintomas();

		System.out.println("Sintomas Model: " + sintomasModel);
		sintomasModel.setSintomas(sintomasSelecionados);
		System.out.println("Sintomas Selecionados: " + sintomasSelecionados);

		// Vermelha
		sintomas_e_prioridades.put("Baba-se", 1);
		sintomas_e_prioridades.put("Convulsionando", 1);
		sintomas_e_prioridades.put("Crianca_nao_reativa", 1);
		sintomas_e_prioridades.put("Estridor", 1);
		sintomas_e_prioridades.put("Hipoglicemia", 1);
		sintomas_e_prioridades.put("Obstrucao_das_vias_aereas", 1);
		sintomas_e_prioridades.put("Respiracao_inadequada", 1);
		sintomas_e_prioridades.put("Choque", 1);
		sintomas_e_prioridades.put("Nao_reativa", 1);
		// Laranja
		sintomas_e_prioridades.put("Comprometimento_vascular_distal", 2);
		sintomas_e_prioridades.put("Crianca_quente", 2);
		sintomas_e_prioridades.put("Erupção cultânea fixa", 2);
		sintomas_e_prioridades.put("Esforço respiratório aumentado", 2);
		sintomas_e_prioridades.put("Evacuação de sangue vivo ou escurecido", 2);
		sintomas_e_prioridades.put("Exaustão", 2);
		sintomas_e_prioridades.put("Frases entrecortadas", 2);
		sintomas_e_prioridades.put("Hemoptise", 2);
		sintomas_e_prioridades.put("Hipotermia", 2);
		sintomas_e_prioridades.put("História de overdose ou envenenamento", 2);
		sintomas_e_prioridades.put("História respiratória significativa", 2);
		sintomas_e_prioridades.put("Inicio agudo após trauma", 2);
		sintomas_e_prioridades.put("Não reage aos pais", 2);
		sintomas_e_prioridades.put("PFE muito baixo", 2);
		sintomas_e_prioridades.put("Prostração", 2);
		sintomas_e_prioridades.put("Púrpura", 2);
		sintomas_e_prioridades.put("Resposta à voz ou a dor apenas", 2);
		sintomas_e_prioridades.put("Sat O2 muito baixa", 2);
		sintomas_e_prioridades.put("Sinais de dor intensa", 2);
		sintomas_e_prioridades.put("Sinais de meningismo", 2);
		sintomas_e_prioridades.put("Vômito de sangue", 2);
		sintomas_e_prioridades.put("Hipotonia", 2);
		// Amarelo
		sintomas_e_prioridades.put("Choro prolongado e initerrupto", 3);
		sintomas_e_prioridades.put("Distúrbio de coagulação", 3);
		sintomas_e_prioridades.put("Dor ao movimento articular", 3);
		sintomas_e_prioridades.put("Dor pleuritica", 3);
		sintomas_e_prioridades.put("Fezes pretas ou em groselha", 3);
		sintomas_e_prioridades.put("História aguda de vômito de sangue", 3);
		sintomas_e_prioridades.put("HIstória de hemoptise", 3);
		sintomas_e_prioridades.put("História de inconsciência", 3);
		sintomas_e_prioridades.put("História discordante", 3);
		sintomas_e_prioridades.put("Incapaz de se alimentar", 3);
		sintomas_e_prioridades.put("Inconsolável pelos pais", 3);
		sintomas_e_prioridades.put("Massa abdominal visivel", 3);
		sintomas_e_prioridades.put("Não entretível", 3);
		sintomas_e_prioridades.put("Não se alimenta", 3);
		sintomas_e_prioridades.put("PFE baixo", 3);
		sintomas_e_prioridades.put("Sat O2 baixa", 3);
		sintomas_e_prioridades.put("Sem urinar", 3);
		sintomas_e_prioridades.put("Sinais de desidração", 3);
		sintomas_e_prioridades.put("Sinais de dor moderada", 3);
		sintomas_e_prioridades.put("Vômitos persistentes", 3);
		// Verde
		sintomas_e_prioridades.put("Chieira", 4);
		sintomas_e_prioridades.put("Comportamento atípico", 4);
		sintomas_e_prioridades.put("Deformidade", 4);
		sintomas_e_prioridades.put("Evento recente", 4);
		sintomas_e_prioridades.put("Febril", 4);
		sintomas_e_prioridades.put("Inchaço", 4);
		sintomas_e_prioridades.put("Sinais de dor leve", 4);
		sintomas_e_prioridades.put("Sinais de dor leve recente", 4);
		sintomas_e_prioridades.put("Tosse produtiva", 4);
		sintomas_e_prioridades.put("Vômitos", 4);

		for (int i = 0; i < sintomasSelecionados.size(); i++) {
			for (int j = 0; j < sintomas_e_prioridades.size(); j++) {
				if (sintomas_e_prioridades.get(sintomasSelecionados.get(i)) < maiorPrioridade) {
					maiorPrioridade = sintomas_e_prioridades.get(sintomasSelecionados.get(i)).intValue();
					sintomaMaisGrave = sintomasSelecionados.get(i);
					scm.setSintomas(sintomaMaisGrave);
					System.out.println("Sintoma String: " + scm.getSintomas());
				}
			}
		}
		
		System.out.println("Sintoma mais grave: " + sintomaMaisGrave);
		System.out.println("Prioridade: " + maiorPrioridade);
		return "/classificacao_final";

	}

	public String sintomaString() {
		scm.setSintomas(sintomaMaisGrave);
		return scm.getSintomas();
	}

}
