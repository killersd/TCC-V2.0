package br.com.ifs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BebeChorandoController {
	String sintomaMaisGrave;

	@PostMapping
	public String submeterSintoma(
			@ModelAttribute("sintomasclassificacao") SintomasClassificacaoModel sintomasClassificacaoModel) {

		System.out.println(sintomaMaisGrave);
		return "/classificacao_final";
	}
}
