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
	
	@RequestMapping("/sintomas_classificacao")
	public String sintomasClassificacao() {
		return "sintomas_classificacao";
	}
}
