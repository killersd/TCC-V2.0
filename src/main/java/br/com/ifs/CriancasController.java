package br.com.ifs;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CriancasController {

	public static List<String> sintomasSelecionados;
	public static HashMap<String, Integer> sintomas_e_prioridades = new HashMap<>();
	public static SintomasClassificacaoModel scm = new SintomasClassificacaoModel();;

	final String[] sintomasVetor = { "Baba-se", "Convulsionando", "Crianca_nao_reativa", "Estridor", "Hipoglicemia",
			"Obstrucao_das_vias_aereas", "Respiracao_inadequada", "Choque", "Nao_reativa",
			"Comprometimento_vascular_distal", "Crianca_quente", "Erupcao_cultanea_fixa",
			"Esforco_respiratorio_aumentado", "Evacuacao_de_sangue_vivo_ou_escurecido", "Exaustão",
			"Frases_entrecortadas", "Hemoptise", "Hipotermia", "Historia_de_overdose_ou_envenenamento",
			"Historia_respiratoria significativa", "Inicio_agudo_apos_trauma", "Nao_reage_aos_pais", "PFE_muito_baixo",
			"Prostracao", "Purpura", "Resposta_a_voz_ou_a_dor_apenas", "Sat_O2_muito_baixa", "Sinais_de_dor_intensa",
			"Sinais_de_meningismo", "Vomito_de_sangue", "Hipotonia", "Choro_prolongado_e_initerrupto",
			"Disturbio_de_coagulacao", "Dor_ao_movimento_articular", "Dor_pleuritica", "Fezes_pretas_ou_em_groselha",
			"Historia_aguda_de_vomito_de_sangue", "Historia_de_hemoptise", "Historia_de_inconsciencia",
			"Historia_discordante", "Incapaz_de_se_alimentar", "Inconsolavel_pelos_pais", "Massa_abdominal_visivel",
			"Nao_entretivel", "Nao_se_alimenta", "PFE_baixo", "Sat_O2_baixa", "Sem_urinar", "Sinais_de_desidracao",
			"Sinais_de_dor_moderada", "Vomitos_persistentes", "Chieira", "Comportamento_atipico", "Deformidade",
			"Evento_recente", "Febril", "Inchaco", "Sinais_de_dor_leve", "Sinais_de_dor_leve_recente",
			"Tosse_produtiva", "Vomitos" };

	public void preencheSintomas() {
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
		sintomas_e_prioridades.put("Erupcao_cultanea_fixa", 2);
		sintomas_e_prioridades.put("Esforco_respiratorio_aumentado", 2);
		sintomas_e_prioridades.put("Evacuacao_de_sangue_vivo_ou_escurecido", 2);
		sintomas_e_prioridades.put("Exaustão", 2);
		sintomas_e_prioridades.put("Frases_entrecortadas", 2);
		sintomas_e_prioridades.put("Hemoptise", 2);
		sintomas_e_prioridades.put("Hipotermia", 2);
		sintomas_e_prioridades.put("Historia_de_overdose_ou_envenenamento", 2);
		sintomas_e_prioridades.put("Historia_respiratoria significativa", 2);
		sintomas_e_prioridades.put("Inicio_agudo_apos_trauma", 2);
		sintomas_e_prioridades.put("Nao_reage_aos_pais", 2);
		sintomas_e_prioridades.put("PFE_muito_baixo", 2);
		sintomas_e_prioridades.put("Prostracao", 2);
		sintomas_e_prioridades.put("Purpura", 2);
		sintomas_e_prioridades.put("Resposta_a_voz_ou_a_dor_apenas", 2);
		sintomas_e_prioridades.put("Sat_O2_muito_baixa", 2);
		sintomas_e_prioridades.put("Sinais_de_dor_intensa", 2);
		sintomas_e_prioridades.put("Sinais_de_meningismo", 2);
		sintomas_e_prioridades.put("Vomito_de_sangue", 2);
		sintomas_e_prioridades.put("Hipotonia", 2);
		// Amarelo
		sintomas_e_prioridades.put("Choro_prolongado_e_initerrupto", 3);
		sintomas_e_prioridades.put("Disturbio_de_coagulacao", 3);
		sintomas_e_prioridades.put("Dor_ao_movimento_articular", 3);
		sintomas_e_prioridades.put("Dor_pleuritica", 3);
		sintomas_e_prioridades.put("Fezes_pretas_ou_em_groselha", 3);
		sintomas_e_prioridades.put("Historia_aguda_de_vomito_de_sangue", 3);
		sintomas_e_prioridades.put("Historia_de_hemoptise", 3);
		sintomas_e_prioridades.put("Historia_de_inconsciencia", 3);
		sintomas_e_prioridades.put("Historia_discordante", 3);
		sintomas_e_prioridades.put("Incapaz_de_se_alimentar", 3);
		sintomas_e_prioridades.put("Inconsolavel_pelos_pais", 3);
		sintomas_e_prioridades.put("Massa_abdominal_visivel", 3);
		sintomas_e_prioridades.put("Nao_entretivel", 3);
		sintomas_e_prioridades.put("Nao_se_alimenta", 3);
		sintomas_e_prioridades.put("PFE_baixo", 3);
		sintomas_e_prioridades.put("Sat_O2_baixa", 3);
		sintomas_e_prioridades.put("Sem_urinar", 3);
		sintomas_e_prioridades.put("Sinais_de_desidracao", 3);
		sintomas_e_prioridades.put("Sinais_de_dor_moderada", 3);
		sintomas_e_prioridades.put("Vomitos_persistentes", 3);
		// Verde
		sintomas_e_prioridades.put("Chieira", 4);
		sintomas_e_prioridades.put("Comportamento_atipico", 4);
		sintomas_e_prioridades.put("Deformidade", 4);
		sintomas_e_prioridades.put("Evento_recente", 4);
		sintomas_e_prioridades.put("Febril", 4);
		sintomas_e_prioridades.put("Inchaco", 4);
		sintomas_e_prioridades.put("Sinais_de_dor_leve", 4);
		sintomas_e_prioridades.put("Sinais_de_dor_leve_recente", 4);
		sintomas_e_prioridades.put("Tosse_produtiva", 4);
		sintomas_e_prioridades.put("Vomitos", 4);

	}

	public void definirPrioridade() {
		String sintomaMaisGrave;
		int maiorPrioridade = 10;

		for (int i = 0; i < 61; i++) {
			if (sintomasSelecionados.contains(sintomasVetor[i])) {
				System.out.println("ENTROU AQUI");
				if (sintomas_e_prioridades.get(sintomasVetor[i]).intValue() < maiorPrioridade) {
					maiorPrioridade = sintomas_e_prioridades.get(sintomasVetor[i]).intValue();
					sintomaMaisGrave = sintomasVetor[i];
					scm.setSintomas(sintomaMaisGrave);
					System.out.println("Sintoma String: " + scm.getSintomas());
				}

			}
		}
	}

	@GetMapping("/bebeChorando")
	public String mostrarEscolhaSintomas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "bebeChorando";
	}

	@PostMapping("/bebeChorando")
	public String selecionandoSintomas(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		CriancasController.sintomasSelecionados = sintomasModel.getSintomas();
		
		preencheSintomas();
		definirPrioridade();
		
//		System.out.println("Sintomas Model: " + sintomasModel);
//		sintomasModel.setSintomas(sintomasSelecionados);
//		System.out.println("Sintomas Selecionados: " + sintomasSelecionados);
//		System.out.println("Sintoma mais grave: " + scm.getSintomas());
//		System.out.println("Prioridade: " + maiorPrioridade);

		return "redirect:/sintomas_classificacao";

	}

	@GetMapping("/crianca_irritadica")
	public String mostrarCriancaIrritadica(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "crianca_irritadica";
	}

	@PostMapping("/crianca_irritadica")
	public String criancaIrritadica(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		CriancasController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	public String sintomaString() {
		scm.setSintomas(scm.getSintomas());
		return scm.getSintomas();
	}

}
