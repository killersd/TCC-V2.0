package br.com.ifs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GrupoController {
	public static String grupo;

	@GetMapping("/grupos")
	public String mostrarEscolhaGrupos(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "grupos";
	}

	@PostMapping("/grupos")
	public String submeterGrupo(
			@ModelAttribute("sintomasclassificacao") @Validated SintomasClassificacaoModel sintomasClassificacaoModel) {

		try {
			grupo = sintomasClassificacaoModel.getGrupo();

			System.out.println(grupo);

			if (grupo.equals("criancas")) {
				//return "redirect:/criancas";
				return "redirect:/criancas_02";
			}
			if (grupo.equals("traumas")) {
				//return "redirect:/traumas";
				return "redirect:/traumas_02";
			}
			if (grupo.equals("dores")) {
				//return "redirect:/dores";
				return "redirect:/dores_02";
			}
			if (grupo.equals("partes_do_corpo")) {
				//return "redirect:/partes_do_corpo";
				return "redirect:/partes_do_corpo_02";
			}
			if (grupo.equals("sintomas_comuns")) {
				//return "redirect:/sintomas_comuns";
				return "redirect:/sintomas_comuns_02";
			}
			if (grupo.equals("outros")) {
				//return "redirect:/outros";
				return "redirect:/outros_02";
			}
		} catch (Exception e) {
			System.out.println("Grupo não pode ser vazio");
			return "redirect:/erroClassificacao";
		}

		return "";
	}

	public String grupoString() {
		if (grupo.equals("criancas")) {
			return "criancas";
		}
		if (grupo.equals("traumas")) {
			return "traumas";
		}
		if (grupo.equals("dores")) {
			return "dores";
		}
		if (grupo.equals("partes_do_corpo")) {
			return "partes_do_corpo";
		}
		if (grupo.equals("outros")) {
			return "outros";
		}
		if (grupo.equals("sintomas_comuns")) {
			return "sintomas_comuns";
		}
		return "";
	}
}
