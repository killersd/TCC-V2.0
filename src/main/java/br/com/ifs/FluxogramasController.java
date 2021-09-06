package br.com.ifs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FluxogramasController {
	public static String fluxograma;

	@GetMapping("/sintomas_comuns_02")
	public String mostrarSintomasComuns(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "sintomas_comuns_02";
	}

	@PostMapping("/sintomas_comuns_02")
	public String submeterSintomasComuns(
			@ModelAttribute("sintomasclassificacao") @Validated SintomasClassificacaoModel sintomasClassificacaoModel) {

		try {
			fluxograma = sintomasClassificacaoModel.getFluxograma();

			System.out.println(fluxograma);

			if (fluxograma.equals("agressao")) {
				return "redirect:/SintomasComuns/agressao";
			}
			if (fluxograma.equals("desmaioNoAdulto")) {
				return "redirect:/SintomasComuns/desmaioNoAdulto";
			}
			if (fluxograma.equals("diabetes")) {
				return "redirect:/SintomasComuns/diabetes";
			}
			if (fluxograma.equals("diarreiaVomitos")) {
				return "redirect:/SintomasComuns/diarreiaVomitos";
			}
			if (fluxograma.equals("dorAbdominalEmAdultos")) {
				return "redirect:/SintomasComuns/dorAbdominalEmAdultos";
			}
			if (fluxograma.equals("embriaguezAparente")) {
				return "redirect:/SintomasComuns/embriaguezAparente";
			}
			if (fluxograma.equals("erupcaoCultanea")) {
				return "redirect:/SintomasComuns/erupcaoCultanea";
			}
			if (fluxograma.equals("feridas")) {
				return "redirect:/SintomasComuns/feridas";
			}
			if (fluxograma.equals("gravidez")) {
				return "redirect:/SintomasComuns/gravidez";
			}
			if (fluxograma.equals("infeccoesLocaisAbcessos")) {
				return "redirect:/SintomasComuns/infeccoesLocaisAbcessos";
			}
			if (fluxograma.equals("malEtarEmAdultos")) {
				return "redirect:/SintomasComuns/malEstarEmAdultos";
			}
			if (fluxograma.equals("palpitacoes")) {
				return "redirect:/SintomasComuns/palpitacoes";
			}
			if (fluxograma.equals("quedas")) {
				return "redirect:/SintomasComuns/quedas";
			}
			if (fluxograma.equals("queimaduras")) {
				return "redirect:/SintomasComuns/queimaduras";
			}

		} catch (Exception e) {
			System.out.println("Fluxograma não pode ser vazio");
			return "redirect:/erroClassificacao";
		}

		return "";
	}

	@GetMapping("/criancas_02")
	public String mostrarCriancas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "criancas_02";
	}

	@PostMapping("/criancas_02")
	public String submeterCriancas(
			@ModelAttribute("sintomasclassificacao") @Validated SintomasClassificacaoModel sintomasClassificacaoModel) {

		try {
			fluxograma = sintomasClassificacaoModel.getFluxograma();

			System.out.println(fluxograma);

			if (fluxograma.equals("bebeChorando")) {
				return "redirect:/Criancas/bebeChorando";
			}
			if (fluxograma.equals("crianca_irritadica")) {
				return "redirect:/Criancas/crianca_irritadica";
			}
			if (fluxograma.equals("criancaMancando")) {
				return "redirect:/Criancas/criancaMancando";
			}
			if (fluxograma.equals("dispineiaEmCriancas")) {
				return "redirect:/Criancas/dispineiaEmCriancas";
			}
			if (fluxograma.equals("dorAbdominalEmCriancas")) {
				return "redirect:/Criancas/dorAbdominalEmCriancas";
			}
			if (fluxograma.equals("malEstarEmCriancas")) {
				return "redirect:/Criancas/malEstarEmCriancas";
			}
		} catch (Exception e) {
			System.out.println("Fluxograma não pode ser vazio");
			return "redirect:/erroClassificacao";
		}
		return "";
	}

	@GetMapping("/dores_02")
	public String mostrarDores(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "dores_02";
	}

	@PostMapping("/dores_02")
	public String submeterDores(
			@ModelAttribute("sintomasclassificacao") @Validated SintomasClassificacaoModel sintomasClassificacaoModel) {

		try {
			fluxograma = sintomasClassificacaoModel.getFluxograma();

			System.out.println(fluxograma);

			if (fluxograma.equals("cefaleia")) {
				return "redirect:/Dores/cefaleia";
			}
			if (fluxograma.equals("dorCervical")) {
				return "redirect:/Dores/dorCervical";
			}
			if (fluxograma.equals("dorDeGarganta")) {
				return "redirect:/Dores/dorDeGarganta";
			}
			if (fluxograma.equals("dorLombar")) {
				return "redirect:/Dores/dorLombar";
			}
			if (fluxograma.equals("dorTesticular")) {
				return "redirect:/Dores/dorTesticular";
			}
			if (fluxograma.equals("dorToraxica")) {
				return "redirect:/Dores/dorToraxica";
			}

		} catch (Exception e) {
			System.out.println("Fluxograma não pode ser vazio");
			return "redirect:/erroClassificacao";
		}
		return "";
	}

	@GetMapping("/outros_02")
	public String mostrarOutros(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "outros_02";
	}

	@PostMapping("/outros_02")
	public String submeterOutros(
			@ModelAttribute("sintomasclassificacao") @Validated SintomasClassificacaoModel sintomasClassificacaoModel) {

		try {
			fluxograma = sintomasClassificacaoModel.getFluxograma();

			System.out.println(fluxograma);

			if (fluxograma.equals("alergia")) {
				return "redirect:/Outros/alergia";
			}
			if (fluxograma.equals("alteracaoDoComportamento")) {
				return "redirect:/Outros/alteracaoDoComportamento";
			}
			if (fluxograma.equals("asma")) {
				return "redirect:/Outros/asma";
			}
			if (fluxograma.equals("autoagressao")) {
				return "redirect:/Outros/autoagressao";
			}
			if (fluxograma.equals("convulsoes")) {
				return "redirect:/Outros/convulsoes";
			}
			if (fluxograma.equals("corpoEstranho")) {
				return "redirect:/Outros/corpoEstranho";
			}
			if (fluxograma.equals("dispineiaEmAdultos")) {
				return "redirect:/Outros/dispineiaEmAdultos";
			}
			if (fluxograma.equals("doencaMental")) {
				return "redirect:/Outros/doencaMental";
			}
			if (fluxograma.equals("dst")) {
				return "redirect:/Outros/dst";
			}
			if (fluxograma.equals("exposicaoAgentesQuimicos")) {
				return "redirect:/Outros/exposicaoAgentesQuimicos";
			}
			if (fluxograma.equals("hemorragiaDigestiva")) {
				return "redirect:/Outros/hemorragiaDigestiva";
			}
			if (fluxograma.equals("mordeduraPicadas")) {
				return "redirect:/Outros/mordeduraPicadas";
			}
			if (fluxograma.equals("overdoseEnvenenamento")) {
				return "redirect:/Outros/overdoseEnvenenamento";
			}
			if (fluxograma.equals("paisPreocupados")) {
				return "redirect:/Outros/paisPreocupados";
			}

		} catch (Exception e) {
			System.out.println("Fluxograma não pode ser vazio");
			return "redirect:/erroClassificacao";
		}
		return "";
	}

	@GetMapping("/partes_do_corpo_02")
	public String mostrarProblemasEmPartesDoCorpo(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "partes_do_corpo_02";
	}

	@PostMapping("/partes_do_corpo_02")
	public String submeterProblemasEmPartesDoCorpo(
			@ModelAttribute("sintomasclassificacao") @Validated SintomasClassificacaoModel sintomasClassificacaoModel) {

		try {
			fluxograma = sintomasClassificacaoModel.getFluxograma();

			System.out.println(fluxograma);

			if (fluxograma.equals("problemasDentarios")) {
				return "redirect:/ProblemasEmPartesDoCorpo/problemasDentarios";
			}
			if (fluxograma.equals("problemasEmExtremidades")) {
				return "redirect:/ProblemasEmPartesDoCorpo/problemasEmExtremidades";
			}
			if (fluxograma.equals("problemasEmFace")) {
				return "redirect:/ProblemasEmPartesDoCorpo/problemasEmFace";
			}
			if (fluxograma.equals("problemasEmOlhos")) {
				return "redirect:/ProblemasEmPartesDoCorpo/problemasEmOlhos";
			}
			if (fluxograma.equals("problemasEmOuvidos")) {
				return "redirect:/ProblemasEmPartesDoCorpo/problemasEmOuvidos";
			}
			if (fluxograma.equals("problemasUrinarios")) {
				return "redirect:/ProblemasEmPartesDoCorpo/problemasUrinarios";
			}
			if (fluxograma.equals("sangramentoVaginal")) {
				return "redirect:/ProblemasEmPartesDoCorpo/sangramentoVaginal";
			}

		} catch (Exception e) {
			System.out.println("Fluxograma não pode ser vazio");
			return "redirect:/erroClassificacao";
		}
		return "";
	}

	@GetMapping("/traumas_02")
	public String mostrarTraumas(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "traumas_02";
	}

	@PostMapping("/traumas_02")
	public String submeterTraumas(
			@ModelAttribute("sintomasclassificacao") @Validated SintomasClassificacaoModel sintomasClassificacaoModel) {

		try {
			fluxograma = sintomasClassificacaoModel.getFluxograma();

			System.out.println(fluxograma);

			if (fluxograma.equals("traumaCranioencefalico")) {
				return "redirect:/Traumas/traumaCranioencefalico";
			}
			if (fluxograma.equals("traumaMaior")) {
				return "redirect:/Traumas/traumaMaior";
			}
			if (fluxograma.equals("traumaToracoabdominal")) {
				return "redirect:/Traumas/traumaToracoabdominal";
			}

		} catch (Exception e) {
			System.out.println("Fluxograma não pode ser vazio");
			return "redirect:/erroClassificacao";
		}
		return "";
	}

	public String fluxogramaString() {
		if (fluxograma.equals("embriaguezAparente")) {
			return "embriaguezAparente";
		}
		if (fluxograma.equals("diabetes")) {
			return "diabetes";
		}
		if (fluxograma.equals("dorLombar")) {
			return "dorLombar";
		}
		if (fluxograma.equals("gravidez")) {
			return "gravidez";
		}
		if (fluxograma.equals("sangramentoVaginal")) {
			return "sangramentoVaginal";
		}
		if (fluxograma.equals("convulsoes")) {
			return "convulsoes";
		}
		
		
		return "";
	}
}
