package br.com.ifs;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homeApp() {
		return "index";
	}

	@RequestMapping("/criancas")
	public String criancas() {
		return "grupos/criancas";
	}

	@RequestMapping("/traumas")
	public String traumas() {
		return "grupos/traumas";
	}

	@RequestMapping("/bebeChorando")
	public String bebeChorando() {
		return "criancas/bebeChorando";
	}

	@RequestMapping("/teste")
	public String teste() {
		return "teste";
	}

	@GetMapping("/grupos")
	public String showForm(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);	
		return "grupos";
	}

	@PostMapping("/grupos")
	public String submitForm(@ModelAttribute("sintomasclassificacao") SintomasClassificacaoModel sintomasClassificacaoModel) {
		System.out.println(sintomasClassificacaoModel);
		return "grupo_registrado";
	}
	
	
	
	
}
