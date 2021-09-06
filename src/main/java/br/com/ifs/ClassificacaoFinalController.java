package br.com.ifs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassificacaoFinalController {
	@Autowired
	private SintomasClassificacaoRepository sr;
	public SintomasClassificacaoModel objetoMontado;

	@GetMapping("/classificacao_final")
	public ModelAndView mostrarClassificacao(Model model) {
		ModelAndView mv = new ModelAndView("classificacao_final");
		Iterable<SintomasClassificacaoModel> sintomasClassificacaoModel = sr.findAll();		
		mv.addObject("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return mv;
	}

	@PostMapping("/classificacao_final")
	public ModelAndView Classificar(Model model) {
		ModelAndView mv = new ModelAndView("classificacao_final");
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		mv.addObject("sintomasClassificacaoModel", sintomasClassificacaoModel);	
		return mv;
	}

	
}
