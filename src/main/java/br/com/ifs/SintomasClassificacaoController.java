package br.com.ifs;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;

@Controller
public class SintomasClassificacaoController {
	@Autowired
	public KieSession session;
	@Autowired
	private SintomasClassificacaoRepository sintomasClassificacaoRepository;
	SintomasClassificacaoModel objeto = new SintomasClassificacaoModel();

	@PostMapping("/SintomasClassificacao")
	public String classificarPaciente(@ModelAttribute ("sintomasClassificacaoModel") @RequestBody SintomasClassificacaoModel sintomasClassificacao) {


		try {
			GrupoController gc = new GrupoController();
			ControleGeralController bcc = new ControleGeralController();
			
			sintomasClassificacao.setGrupo(gc.grupoString());
			sintomasClassificacao.setSintomas(bcc.sintomaString());

			session.insert(sintomasClassificacao);
			session.fireAllRules();

			if (!sintomasClassificacao.getClassificacao().equalsIgnoreCase("VERDE")) {
				sintomasClassificacao.setLocal("HOSPITAL");
			} else {
				sintomasClassificacao.setLocal("POSTO DE SAUDE");
			}
			switch (sintomasClassificacao.getClassificacao()) {
			case "VERMELHA":
				sintomasClassificacao.setTempoAtendimentoImediato("ATENDIMENTO IMEDIATO");
				break;
			case "LARANJA":
				sintomasClassificacao.setTempoAtendimentoImediato("ATENDIMENTO MUITO URGENTE");
				sintomasClassificacao.setTempoAtendimentoMinutos(10);
				break;
			case "AMARELA":
				sintomasClassificacao.setTempoAtendimentoImediato("ATENDIMENTO URGENTE");
				sintomasClassificacao.setTempoAtendimentoMinutos(50);
				break;
			case "VERDE":
				sintomasClassificacao.setTempoAtendimentoImediato("ATENDIMENTO POUCO URGENTE");
				sintomasClassificacao.setTempoAtendimentoMinutos(120);
				break;
			}
			System.out.println("Salvando objeto no banco...");
			objeto.setClassificacao(sintomasClassificacao.getClassificacao());
			objeto.setTempoAtendimentoMinutos(sintomasClassificacao.getTempoAtendimentoMinutos());
			objeto.setLocal(sintomasClassificacao.getLocal());
			objeto.setGrupo(sintomasClassificacao.getGrupo());
			objeto.setSintomas(sintomasClassificacao.getSintomas());
			objeto.setTempoAtendimentoImediato(sintomasClassificacao.getTempoAtendimentoImediato());
			System.out.println("CLassificação: " + objeto.getClassificacao());
			System.out.println("Tempo de atendimento: " + objeto.getTempoAtendimentoMinutos());
			System.out.println("Local de atendimento: " + objeto.getLocal());
			sintomasClassificacaoRepository.save(sintomasClassificacao);
			System.out.println("O objeto foi salvo com sucesso!");
			//return "redirect:/classificacao_final";
			return "redirect:/classificacaoPaciente";
		} catch (Exception e) {
			System.out.println("Houve um erro na classificação");
			return "redirect:/erroClassificacao";
		}
	}

	/*@GetMapping("/SintomasClassificacao")
	@ApiOperation(value = "Retorna todas as classificações existentes no banco de dados")
	public ModelAndView mostrarClassificacao(Model model) {
		ModelAndView mv = new ModelAndView("classificacao_final");
		Iterable<SintomasClassificacaoModel> sintomasClassificacaoModel = sintomasClassificacaoRepository.findAll();
		mv.addObject("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return mv;
	}*/

	@GetMapping("/SintomasClassificacao")
	public String showForm(Model model) {
		SintomasClassificacaoModel sintomasClassificacaoModel = new SintomasClassificacaoModel();
		model.addAttribute("sintomasClassificacaoModel", sintomasClassificacaoModel);
		return "classificacaoPaciente";
	} 
	
	
	@DeleteMapping("/SintomasClassificacao")
	@ApiOperation(value = "Este método deleta uma classificação existente no banco")
	public void deletaRegistro(@RequestBody SintomasClassificacaoModel sintomasClassificacaoModel) {
		sintomasClassificacaoRepository.delete(sintomasClassificacaoModel);
	}

}

