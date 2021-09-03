package br.com.ifs;

import org.springframework.stereotype.Controller;
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

	@RequestMapping("/partes_do_corpo")
	public String problemasEmPartesDoCorpo() {
		return "grupos/partes_do_corpo";
	}

	@RequestMapping("/dores")
	public String dores() {
		return "grupos/dores";
	}

	@RequestMapping("/sintomas_comuns")
	public String sintomas_comuns() {
		return "grupos/sintomas_comuns";
	}

	@RequestMapping("/outros")
	public String outros() {
		return "grupos/outros";
	}

	@RequestMapping("/classificacao_final")
	public String cf() {
		return "classificacao_final";
	}

	@RequestMapping("/grupo_registrado")
	public String cff() {
		return "grupo_registrado";
	}

	@RequestMapping("/testeCheckbox")
	public String testeCheckbox() {
		return "testeCheckbox";
	}

	@RequestMapping("/sintomas_classificacao")
	public String sintomasClassificacao() {
		return "sintomas_classificacao";
	}
}
