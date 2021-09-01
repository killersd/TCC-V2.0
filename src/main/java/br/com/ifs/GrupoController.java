package br.com.ifs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.ApiOperation;

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
			@ModelAttribute("sintomasclassificacao") SintomasClassificacaoModel sintomasClassificacaoModel) {
		this.grupo = sintomasClassificacaoModel.getGrupo();
		System.out.println(grupo);
		
		if (grupo.equals("criancas")) {
			return "redirect:/criancas";
		}
		if (grupo.equals("traumas")) {
			return "redirect:/traumas";
		}
		if (grupo.equals("dores")) {
			return "redirect:/dores";
		}
		if (grupo.equals("partes_do_corpo")) {
			return "redirect:/partes_do_corpo";
		}
		if (grupo.equals("outros")) {
			return "outros";
		}
		if (grupo.equals("sintomas comuns")) {
			return "sintomas comuns";
		}
		return "";
	}
	
	@ApiOperation(value = "Armazena o grupo escolhido pelo usuário, para posteriormente setá-lo no objeto que será usado no "
			+ "no metodo para classificar o paciente")
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
		if (grupo.equals("sintomas comuns")) {
			return "sintomas comuns";
		}
		return "";
	}
}
