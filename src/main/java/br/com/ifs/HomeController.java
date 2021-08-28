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
	
	@RequestMapping("/sintomas_classificacao")
	public String sintomasClassificacao() {
		return "sintomas_classificacao";
	}
}
