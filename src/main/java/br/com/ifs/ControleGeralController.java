package br.com.ifs;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControleGeralController {

	public static List<String> sintomasSelecionados;
	public static HashMap<String, Integer> sintomas_e_prioridades = new HashMap<>();
	public static SintomasClassificacaoModel scm = new SintomasClassificacaoModel();;

	final String[] sintomasVetor = {
			"Apresentacao_de_partes_fetais","Baba-se","Choque","Convulsionando","Crianca_nao_reativa",
			"Estridor","Hemorragia_hexanguinante","Hiperglicemia","Hipoglicemia","Lesao_ocular_quimica_aguda",
			"Nao_reativa","Obstrucao_das_vias_aereas","Prolapso_de_cordao_umbilical","Respiracao_inadequada",
			
			"Adulto_muito_quente", "Inicio_abrupto", "Alteracao_da_consciencia_nao_totalmente_atribuida_ao_alcool","Alteracao_subita_da_consciencia","Alto_risco_de_agredir_os_outros","Alto_risco_de autoagressao","Alto_risco_de_nova_agressao",
			"Comprometimento_vascular_distal","Crianca_quente","Deficit_neurologico_agudo","Dispineia_aguda","Dor_abdominal",
			"Dor_epigastrica","Dor_intensa","Dor_que_irradia_para_o_dorso","Dor_ou_coceira_intensas","Dor_precordial_ou_cardiaca",
			"Edema_de_lingua","Edema_facial","Erupcao_cultanea_fixa","Erupcao_fixa","Esforco_respiratorio_aumentado",
			"Evacuacao_de_sangue_vivo_ou_escurecido","Exaustao","Evisceracao","Frases_entrecortadas","Gangrena_de_escroto","Hemoptise",
			"Hemorragia_maior_incontrolavel","Hiperglicemia_com_cetose","Hipotermia","Hipotonia","Historia_alergica_importante",
			"Historia_de_alergia_importante","Historia_de_overdose_ou_envenenamento","Historia_inadequada","Historia_respiratoria_significativa","Historia_de_convulsao",
			"Idade_menor_que_25_anos","Inicio_agudo_apos_trauma","Mecanismo_de_trauma_significativo","Mortalidade_alta","Nao_reage_aos_pais",
			"Perda_total_da_visao_aguda","PFE_muito_baixo","Prostracao","Prostracao_e_hipotonia","Pulso_anormal",
			"Purpura","Resposta_a_voz_ou_a_dor_apenas","Risco_de_contaminacao_persistente","Sangramento_vaginal_mais_de_20_semanas_de_gravidez","Sangramento_vaginal_intenso",
			"Sat_O2_muito_baixa","Priaprismo","Pele_critica","Sinais_de_dor_intensa","Sinais_de_meningismo","Trabalho_de_parto","Trauma_ocular_penetrante","Vomito_de_sangue",
			
			"Adulto_quente","Agitacao_psicomotora","Alteracao_da_consciencia_totalmente_atribuida_ao_alcool","Articulacao_quente", "Celulite_de_escroto",
			"Choro_prolongado_e_initerrupto","Colicas","Comportamento_conturbador","Couro_cabeludo_temporal_dolorido","Deficit_neurologico_novo",
			"Disturbio_de_coagulacao","Dor_abdominal","Dor_ao_movimento_articular","Dor_irradiada_para_o_ombro","Dor_moderada",
			"Dor_ou_coceira_moderadas","Dor_pleuritica","Dor_testicular","Erupcao_ou_vesiculas_disseminadas","Fezes_pretas_ou_em_groselha",
			"Gravidez_possivel","Hemorragia_menor_incontrolavel","Hiperglicemia","Historia_aguda_de_vomito_de_sangue","Historia_cardiaca_importante",
			"Historia_de_convulsao","Historia_de_hemoptise","Historia_de_inconsciencia","Historia_de_trauma","Historia_de_trauma_cranioencefalico",
			"Historia_de_viagem_recente","Historia_discordante","Historia_psiquiatrica_importante","Imunosupressao_conhecida","Incapaz_de_andar",
			"Incapaz_de_se_alimentar","Inconsolavel_pelos_pais","Inicio_subito","Massa_abdominal_visivel","Mortalidade_moderada",
			"Nao_entretivel","Nao_se_alimenta","PFE_baixo","Pressao_arterial_elevada","Reducao_recente_da_acuidade_visual",
			"Risco_moderado_de_agredir_os_outros","Risco_moderado_de_autoagressao","Risco_moderado_de_nova_autoagressao","Sangramento_vaginal","Sat_O2_baixa",
			"Sem_melhora_com_sua_medicacao_habitual","Comorbidade_importante","Sinais_de_desidracao","Sinais_de_dor_moderada","Trauma_direto_no_dorso", "Trauma_direto_no_pescoco","Vomitos_persistentes","Sem_urinar",
			"Avulcao_dentaria_aguda","Deformidade_grosseira","Fratura_exposta","Hematuria_franca","Retencao_urinaria","Trauma_vaginal",
			
			"Cefaleia","Chieira","Comportamento_atipico","Corrimento","Deformidade",
			"Dor_leve_recente","Dor_ou_coceira_leve_recente","Edema","Evento_recente","Eventos_recentes",
			"Febril","Hematoma_de_couro_cabeludo","Inchaco","Infeccao_local","Inflamacao_local","Olho_vermelho",
			"Sinais_de_dor_leve","Sinais_de_dor_leve_recente","Tosse_produtiva","Trauma_de_escroto","Trauma_recente",
			"Trauma_toraxico","Vomitos","Diplopia","Disuria","Edema_facial","Hematoma_de_orelha","Inchaco_na_face",
			"Olhos_vermelhos","Perda_recente_da_audicao","Sensacao_de_corpo_estranho","Sensibilidade_na_face_alterada","Vertigem"
			
	};

	public void preencheSintomas() {
		// Vermelha
		sintomas_e_prioridades.put("Apresentacao_de_partes_fetais", 1);
		sintomas_e_prioridades.put("Baba-se", 1);
		sintomas_e_prioridades.put("Choque", 1);
		sintomas_e_prioridades.put("Convulsionando", 1);
		sintomas_e_prioridades.put("Crianca_nao_reativa", 1);
		sintomas_e_prioridades.put("Estridor", 1);
		sintomas_e_prioridades.put("Hemorragia_hexanguinante", 1);
		sintomas_e_prioridades.put("Hiperglicemia", 1);//verificar esse
		sintomas_e_prioridades.put("Hipoglicemia", 1);
		sintomas_e_prioridades.put("Lesao_ocular_quimica_aguda", 1);
		sintomas_e_prioridades.put("Nao_reativa", 1);
		sintomas_e_prioridades.put("Obstrucao_das_vias_aereas", 1);
		sintomas_e_prioridades.put("Prolapso_de_cordao_umbilical", 1);
		sintomas_e_prioridades.put("Respiracao_inadequada", 1);
		// Laranja
		sintomas_e_prioridades.put("Adulto_muito_quente", 2);
		sintomas_e_prioridades.put("Alteracao_da_consciencia_nao_totalmente_atribuida_ao_alcool", 2);
		sintomas_e_prioridades.put("Alteracao_subita_da_consciencia", 2);
		sintomas_e_prioridades.put("Alto_risco_de_agredir_os_outros", 2);
		sintomas_e_prioridades.put("Alto_risco_de autoagressao", 2);
		sintomas_e_prioridades.put("Alto_risco_de_nova_agressao", 2);
		sintomas_e_prioridades.put("Comprometimento_vascular_distal", 2);
		sintomas_e_prioridades.put("Crianca_quente", 2);
		sintomas_e_prioridades.put("Deficit_neurologico_agudo", 2);
		sintomas_e_prioridades.put("Dispineia_aguda", 2);
		sintomas_e_prioridades.put("Dor_abdominal", 2);//verificar esse
		sintomas_e_prioridades.put("Dor_epigastrica", 2);
		sintomas_e_prioridades.put("Dor_intensa", 2);
		sintomas_e_prioridades.put("Dor_que_irradia_para_o_dorso", 2);
		sintomas_e_prioridades.put("Dor_ou_coceira_intensas", 2);
		sintomas_e_prioridades.put("Dor_precordial_ou_cardiaca", 2);
		sintomas_e_prioridades.put("Edema_de_lingua", 2);
		sintomas_e_prioridades.put("Edema_facial", 2);
		sintomas_e_prioridades.put("Erupcao_cultanea_fixa", 2);
		sintomas_e_prioridades.put("Erupcao_fixa", 2);
		sintomas_e_prioridades.put("Esforco_respiratorio_aumentado", 2);
		sintomas_e_prioridades.put("Evacuacao_de_sangue_vivo_ou_escurecido", 2);
		sintomas_e_prioridades.put("Exaustao", 2);
		sintomas_e_prioridades.put("Evisceracao", 2);
		sintomas_e_prioridades.put("Frases_entrecortadas", 2);
		sintomas_e_prioridades.put("Gangrena_de_escroto", 2);
		sintomas_e_prioridades.put("Hemoptise", 2);
		sintomas_e_prioridades.put("Hemorragia_maior_incontrolavel", 2);
		sintomas_e_prioridades.put("Hiperglicemia_com_cetose", 2);
		sintomas_e_prioridades.put("Hipotermia", 2);
		sintomas_e_prioridades.put("Hipotonia", 2);
		sintomas_e_prioridades.put("Historia_alergica_importante", 2);
		sintomas_e_prioridades.put("Historia_de_alergia_importante", 2);
		sintomas_e_prioridades.put("Historia_de_overdose_ou_envenenamento", 2);
		sintomas_e_prioridades.put("Historia_inadequada", 2);
		sintomas_e_prioridades.put("Historia_respiratoria_significativa", 2);
		sintomas_e_prioridades.put("Historia_de_convulsao", 2);//verificar esse
		sintomas_e_prioridades.put("Idade_menor_que_25_anos", 2);
		sintomas_e_prioridades.put("Inicio_abrupto", 2);
		sintomas_e_prioridades.put("Inicio_agudo_apos_trauma", 2);
		sintomas_e_prioridades.put("Mecanismo_de_trauma_significativo", 2);
		sintomas_e_prioridades.put("Mortalidade_alta", 2);
		sintomas_e_prioridades.put("Nao_reage_aos_pais", 2);	
		sintomas_e_prioridades.put("Pele_critica", 2);
		sintomas_e_prioridades.put("Perda_total_da_visao_aguda", 2);
		sintomas_e_prioridades.put("PFE_muito_baixo", 2);
		sintomas_e_prioridades.put("Priaprismo", 2);
		sintomas_e_prioridades.put("Prostracao", 2);
		sintomas_e_prioridades.put("Prostracao_e_hipotonia", 2);
		sintomas_e_prioridades.put("Pulso_anormal", 2);
		sintomas_e_prioridades.put("Purpura", 2);
		sintomas_e_prioridades.put("Resposta_a_voz_ou_a_dor_apenas", 2);
		sintomas_e_prioridades.put("Risco_de_contaminacao_persistente", 2);
		sintomas_e_prioridades.put("Sangramento_vaginal_mais_de_20_semanas_de_gravidez", 2);
		sintomas_e_prioridades.put("Sangramento_vaginal_intenso", 2);
		sintomas_e_prioridades.put("Sat_O2_muito_baixa", 2);
		sintomas_e_prioridades.put("Sinais_de_dor_intensa", 2);
		sintomas_e_prioridades.put("Sinais_de_meningismo", 2);
		sintomas_e_prioridades.put("Trabalho_de_parto", 2);
		sintomas_e_prioridades.put("Trauma_ocular_penetrante", 2);
		sintomas_e_prioridades.put("Vomito_de_sangue", 2);
		// Amarelo		
		sintomas_e_prioridades.put("Adulto_quente", 3);
		sintomas_e_prioridades.put("Agitacao_psicomotora", 3);
		sintomas_e_prioridades.put("Alteracao_da_consciencia_totalmente_atribuida_ao_alcool", 3);
		sintomas_e_prioridades.put("Articulacao_quente", 3);
		sintomas_e_prioridades.put("Avulcao_dentaria_aguda", 3);
		sintomas_e_prioridades.put("Celulite_de_escroto", 3);
		sintomas_e_prioridades.put("Choro_prolongado_e_initerrupto", 3);
		sintomas_e_prioridades.put("Colicas", 3);
		sintomas_e_prioridades.put("Comorbidade_importante", 3);
		sintomas_e_prioridades.put("Comportamento_conturbador", 3);
		sintomas_e_prioridades.put("Couro_cabeludo_temporal_dolorido", 3);
		sintomas_e_prioridades.put("Deficit_neurologico_novo", 3);
		sintomas_e_prioridades.put("Deformidade_grosseira", 3);
		sintomas_e_prioridades.put("Disturbio_de_coagulacao", 3);
		sintomas_e_prioridades.put("Dor_abdominal", 3);//verificar esse
		sintomas_e_prioridades.put("Dor_ao_movimento_articular", 3);
		sintomas_e_prioridades.put("Dor_irradiada_para_o_ombro", 3);
		sintomas_e_prioridades.put("Dor_moderada", 3);
		sintomas_e_prioridades.put("Dor_ou_coceira_moderadas", 3);
		sintomas_e_prioridades.put("Dor_pleuritica", 3);
		sintomas_e_prioridades.put("Dor_testicular", 3);
		sintomas_e_prioridades.put("Erupcao_ou_vesiculas_disseminadas", 3);
		sintomas_e_prioridades.put("Fezes_pretas_ou_em_groselha", 3);
		sintomas_e_prioridades.put("Fratura_exposta", 3);
		sintomas_e_prioridades.put("Gravidez_possivel", 3);
		sintomas_e_prioridades.put("Hematuria_franca", 3);
		sintomas_e_prioridades.put("Hemorragia_menor_incontrolavel", 3);
		sintomas_e_prioridades.put("Hiperglicemia", 3);//verificar esse
		sintomas_e_prioridades.put("Historia_aguda_de_vomito_de_sangue", 3);
		sintomas_e_prioridades.put("Historia_cardiaca_importante", 3);
		sintomas_e_prioridades.put("Historia_de_convulsao", 3);//verificar esse
		sintomas_e_prioridades.put("Historia_de_hemoptise", 3);
		sintomas_e_prioridades.put("Historia_de_inconsciencia", 3);
		sintomas_e_prioridades.put("Historia_de_trauma", 3);
		sintomas_e_prioridades.put("Historia_de_trauma_cranioencefalico", 3);
		sintomas_e_prioridades.put("Historia_de_viagem_recente", 3);
		sintomas_e_prioridades.put("Historia_discordante", 3);
		sintomas_e_prioridades.put("Historia_psiquiatrica_importante", 3);
		sintomas_e_prioridades.put("Imunosupressao_conhecida", 3);
		sintomas_e_prioridades.put("Incapaz_de_andar", 3);
		sintomas_e_prioridades.put("Incapaz_de_se_alimentar", 3);
		sintomas_e_prioridades.put("Inconsolavel_pelos_pais", 3);
		sintomas_e_prioridades.put("Inicio_subito", 3);
		sintomas_e_prioridades.put("Massa_abdominal_visivel", 3);
		sintomas_e_prioridades.put("Mortalidade_moderada", 3);
		sintomas_e_prioridades.put("Nao_entretivel", 3);
		sintomas_e_prioridades.put("Nao_se_alimenta", 3);
		sintomas_e_prioridades.put("PFE_baixo", 3);
		sintomas_e_prioridades.put("Pressao_arterial_elevada", 3);
		sintomas_e_prioridades.put("Reducao_recente_da_acuidade_visual", 3);
		sintomas_e_prioridades.put("Retencao_urinaria", 3);
		sintomas_e_prioridades.put("Risco_moderado_de_agredir_os_outros", 3);
		sintomas_e_prioridades.put("Risco_moderado_de_autoagressao", 3);
		sintomas_e_prioridades.put("Risco_moderado_de_nova_autoagressao", 3);
		sintomas_e_prioridades.put("Sangramento_vaginal", 3);//verificar esse
		sintomas_e_prioridades.put("Sat_O2_baixa", 3);
		sintomas_e_prioridades.put("Sem_melhora_com_sua_medicacao_habitual", 3);
		sintomas_e_prioridades.put("Sinais_de_desidracao", 3);
		sintomas_e_prioridades.put("Sinais_de_dor_moderada", 3);
		sintomas_e_prioridades.put("Trauma_direto_no_dorso", 3);
		sintomas_e_prioridades.put("Trauma_direto_no_pescoco", 3);
		sintomas_e_prioridades.put("Trauma_vaginal", 3);
		sintomas_e_prioridades.put("Vomitos_persistentes", 3);
		sintomas_e_prioridades.put("Sem_urinar", 3);//verificar esse		
		// Verde
		sintomas_e_prioridades.put("Cefaleia", 4);
		sintomas_e_prioridades.put("Chieira", 4);
		sintomas_e_prioridades.put("Comportamento_atipico", 4);
		sintomas_e_prioridades.put("Corrimento", 4);
		sintomas_e_prioridades.put("Deformidade", 4);
		sintomas_e_prioridades.put("Diplopia", 4);
		sintomas_e_prioridades.put("Disuria", 4);
		sintomas_e_prioridades.put("Dor_leve_recente", 4);
		sintomas_e_prioridades.put("Dor_ou_coceira_leve_recente", 4);
		sintomas_e_prioridades.put("Edema", 4);
		sintomas_e_prioridades.put("Edema_facial", 4);
		sintomas_e_prioridades.put("Evento_recente", 4);
		sintomas_e_prioridades.put("Eventos_recentes", 4);
		sintomas_e_prioridades.put("Febril", 4);
		sintomas_e_prioridades.put("Hematoma_de_couro_cabeludo", 4);
		sintomas_e_prioridades.put("Hematoma_de_orelha", 4);
		sintomas_e_prioridades.put("Inchaco", 4);
		sintomas_e_prioridades.put("Inchaco_na_face", 4);
		sintomas_e_prioridades.put("Infeccao_local", 4);
		sintomas_e_prioridades.put("Inflamacao_local", 4);
		sintomas_e_prioridades.put("Olho_vermelho", 4);	
		sintomas_e_prioridades.put("Olhos_vermelhos", 4);
		sintomas_e_prioridades.put("Perda_recente_da_audicao", 4);
		sintomas_e_prioridades.put("Sensacao_de_corpo_estranho", 4);
		sintomas_e_prioridades.put("Sensibilidade_na_face_alterada", 4);	
		sintomas_e_prioridades.put("Sinais_de_dor_leve", 4);
		sintomas_e_prioridades.put("Sinais_de_dor_leve_recente", 4);
		sintomas_e_prioridades.put("Tosse_produtiva", 4);
		sintomas_e_prioridades.put("Trauma_de_escroto", 4);
		sintomas_e_prioridades.put("Trauma_recente", 4);
		sintomas_e_prioridades.put("Trauma_toraxico", 4);
		sintomas_e_prioridades.put("Vertigem", 4);	
		sintomas_e_prioridades.put("Vomitos", 4);
	}

	public void definirPrioridade() {
		String sintomaMaisGrave;
		int maiorPrioridade = 10;

		for (int i = 0; i <= 171; i++) {
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

	public String sintomaString() {
		scm.setSintomas(scm.getSintomas());
		return scm.getSintomas();
	}

	// A partir deste ponto iniciam-se os mapeamentos das URL's para o grupo de
	// crianças
	@GetMapping("/Criancas/bebeChorando")
	public String mostrarEscolhaSintomas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Criancas/bebeChorando";
	}

	@PostMapping("/Criancas/bebeChorando")
	public String selecionandoSintomas(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	@GetMapping("/Criancas/crianca_irritadica")
	public String mostrarCriancaIrritadica(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Criancas/crianca_irritadica";
	}

	@PostMapping("/Criancas/crianca_irritadica")
	public String criancaIrritadica(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	@GetMapping("/Criancas/criancaMancando")
	public String mostrarCriancaMancando(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Criancas/criancaMancando";
	}

	@PostMapping("/Criancas/criancaMancando")
	public String criancaMancando(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	@GetMapping("/Criancas/malEstarEmCriancas")
	public String mostrarMalEstarEmCriancas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Criancas/malEstarEmCriancas";
	}

	@PostMapping("/Criancas/malEstarEmCriancas")
	public String malEstarEmCriancas(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	@GetMapping("/Criancas/dispineiaEmCriancas")
	public String dispineiaEmCriancas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Criancas/dispineiaEmCriancas";
	}

	@PostMapping("/Criancas/dispineiaEmCriancas")
	public String dispineiaEmCriancas(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	@GetMapping("/Criancas/dorAbdominalEmCriancas")
	public String dorAbdominalEmCriancas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Criancas/dorAbdominalEmCriancas";
	}

	@PostMapping("/Criancas/dorAbdominalEmCriancas")
	public String dorAbdominalEmCriancas(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	// A partir deste ponto iniciam-se os mapeamentos das URL's para o grupo de
	// traumas
	@GetMapping("/Traumas/traumaCranioencefalico")
	public String traumaCranioencefalico(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Traumas/traumaCranioencefalico";
	}

	@PostMapping("/Traumas/traumaCranioencefalico")
	public String traumaCranioencefalico(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	@GetMapping("/Traumas/traumaMaior")
	public String traumaMaior(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Traumas/traumaMaior";
	}

	@PostMapping("/Traumas/traumaMaior")
	public String traumaMaior(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}

	@GetMapping("/Traumas/traumaToracoabdominal")
	public String traumaToracoabdominal(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Traumas/traumaToracoabdominal";
	}

	@PostMapping("/Traumas/traumaToracoabdominal")
	public String traumaToracoabdominal(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	// A partir deste ponto iniciam-se os mapeamentos das URL's para o grupo de
	// problemas em partes do corpo	
	@GetMapping("/ProblemasEmPartesDoCorpo/problemasDentarios")
	public String problemasDentarios(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "ProblemasEmPartesDoCorpo/problemasDentarios";
	}

	@PostMapping("/ProblemasEmPartesDoCorpo/problemasDentarios")
	public String problemasDentarios(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	
	@GetMapping("/ProblemasEmPartesDoCorpo/problemasEmExtremidades")
	public String problemasEmExtremidades(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "ProblemasEmPartesDoCorpo/problemasEmExtremidades";
	}

	@PostMapping("/ProblemasEmPartesDoCorpo/problemasEmExtremidades")
	public String problemasEmExtremidades(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/ProblemasEmPartesDoCorpo/problemasEmFace")
	public String problemasEmFace(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "ProblemasEmPartesDoCorpo/problemasEmFace";
	}

	@PostMapping("/ProblemasEmPartesDoCorpo/problemasEmFace")
	public String problemasEmFace(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	
	@GetMapping("/ProblemasEmPartesDoCorpo/problemasEmOlhos")
	public String problemasEmOlhos(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "ProblemasEmPartesDoCorpo/problemasEmOlhos";
	}

	@PostMapping("/ProblemasEmPartesDoCorpo/problemasEmOlhos")
	public String problemasEmOlhos(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/ProblemasEmPartesDoCorpo/problemasEmOuvidos")
	public String problemasEmOuvidos(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "ProblemasEmPartesDoCorpo/problemasEmOuvidos";
	}

	@PostMapping("/ProblemasEmPartesDoCorpo/problemasEmOuvidos")
	public String problemasEmOuvidos(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/ProblemasEmPartesDoCorpo/problemasUrinarios")
	public String problemasUrinarios(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "ProblemasEmPartesDoCorpo/problemasUrinarios";
	}

	@PostMapping("/ProblemasEmPartesDoCorpo/problemasUrinarios")
	public String problemasUrinarios(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/ProblemasEmPartesDoCorpo/sangramentoVaginal")
	public String sangramentoVaginal(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "ProblemasEmPartesDoCorpo/sangramentoVaginal";
	}

	@PostMapping("/ProblemasEmPartesDoCorpo/sangramentoVaginal")
	public String sangramentoVaginal(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	// A partir deste ponto iniciam-se os mapeamentos das URL's para o grupo de
	// dores
	@GetMapping("/Dores/dorCervical")
	public String dorCervical(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Dores/dorCervical";
	}

	@PostMapping("/Dores/dorCervical")
	public String dorCervical(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/Dores/dorDeGarganta")
	public String dorDeGarganta(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Dores/dorDeGarganta";
	}

	@PostMapping("/Dores/dorDeGarganta")
	public String dorDeGarganta(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/Dores/dorLombar")
	public String dorLombar(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Dores/dorLombar";
	}

	@PostMapping("/Dores/dorLombar")
	public String dorLombar(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/Dores/dorTesticular")
	public String dorTesticular(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Dores/dorTesticular";
	}

	@PostMapping("/Dores/dorTesticular")
	public String dorTesticular(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	
	@GetMapping("/Dores/dorToraxica")
	public String dorToraxica(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Dores/dorToraxica";
	}

	@PostMapping("/Dores/dorToraxica")
	public String dorToraxica(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/Dores/cefaleia")
	public String cefaleia(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "Dores/cefaleia";
	}

	@PostMapping("/Dores/cefaleia")
	public String cefaleia(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	// A partir deste ponto iniciam-se os mapeamentos das URL's para o grupo de
	// Sintomas Comuns
	
	@GetMapping("/SintomasComuns/desmaioNoAdulto")
	public String desmaioNoAdulto(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/desmaioNoAdulto";
	}

	@PostMapping("/SintomasComuns/desmaioNoAdulto")
	public String desmaioNoAdulto(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/sintomas_classificacao";

	}
	
	@GetMapping("/SintomasComuns/embriaguezAparente")
	public String embriaguezAparente(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/embriaguezAparente";
	}

	@PostMapping("/SintomasComuns/embriaguezAparente")
	public String embriaguezAparente(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/embriaguezAparente";

	}
	
	@GetMapping("/SintomasComuns/feridas")
	public String feridas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/feridas";
	}

	@PostMapping("/SintomasComuns/feridas")
	public String feridas(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/feridas";

	}
	
	@GetMapping("/SintomasComuns/infeccoesLocaisAbcessos")
	public String infeccoesLocaisAbcessos(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/infeccoesLocaisAbcessos";
	}

	@PostMapping("/SintomasComuns/infeccoesLocaisAbcessos")
	public String infeccoesLocaisAbcessos(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/infeccoesLocaisAbcessos";

	}
	
	
	@GetMapping("/SintomasComuns/malEstarEmAdultos")
	public String malEstarEmAdultos(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/malEstarEmAdultos";
	}

	@PostMapping("/SintomasComuns/malEstarEmAdultos")
	public String malEstarEmAdultos(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/malEstarEmAdultos";

	}
	
	@GetMapping("/SintomasComuns/diarreiaVomitos")
	public String diarreiaVomitos(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/diarreiaVomitos";
	}

	@PostMapping("/SintomasComuns/diarreiaVomitos")
	public String diarreiaVomitos(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/diarreiaVomitos";

	}
	
	@GetMapping("/SintomasComuns/agressao")
	public String agressao(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/agressao";
	}

	@PostMapping("/SintomasComuns/agressao")
	public String agressao(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/agressao";

	}
	
	
	@GetMapping("/SintomasComuns/palpitacoes")
	public String palpitacoes(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/palpitacoes";
	}

	@PostMapping("/SintomasComuns/palpitacoes")
	public String palpitacoes(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/palpitacoes";

	}
	
	@GetMapping("/SintomasComuns/diabetes")
	public String diabetes(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/diabetes";
	}

	@PostMapping("/SintomasComuns/diabetes")
	public String diabetes(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/diabetes";

	}
	
	@GetMapping("/SintomasComuns/erupcaoCultanea")
	public String erupcaoCultanea(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/erupcaoCultanea";
	}

	@PostMapping("/SintomasComuns/erupcaoCultanea")
	public String erupcaoCultanea(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/erupcaoCultanea";

	}
	
	@GetMapping("/SintomasComuns/dorAbdominalEmAdultos")
	public String dorAbdominalEmAdultos(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/dorAbdominalEmAdultos";
	}

	@PostMapping("/SintomasComuns/dorAbdominalEmAdultos")
	public String dorAbdominalEmAdultos(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/dorAbdominalEmAdultos";

	}
	
	@GetMapping("/SintomasComuns/gravidez")
	public String gravidez(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/gravidez";
	}

	@PostMapping("/SintomasComuns/gravidez")
	public String gravidez(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/gravidez";

	}
	
	@GetMapping("/SintomasComuns/quedas")
	public String quedas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/quedas";
	}

	@PostMapping("/SintomasComuns/quedas")
	public String quedas(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/quedas";

	}
	
	@GetMapping("/SintomasComuns/queimaduras")
	public String queimaduras(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "SintomasComuns/queimaduras";
	}

	@PostMapping("/SintomasComuns/queimaduras")
	public String queimaduras(

			@ModelAttribute("sintomasmodel") SintomasModel sintomasModel) {
		ControleGeralController.sintomasSelecionados = sintomasModel.getSintomas();

		preencheSintomas();
		definirPrioridade();

		return "redirect:/queimaduras";

	}
	// A partir deste ponto iniciam-se os mapeamentos das URL's para o grupo de
	// Outros
}
