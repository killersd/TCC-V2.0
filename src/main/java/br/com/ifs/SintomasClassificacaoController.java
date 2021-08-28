package br.com.ifs;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST para a triagem de pacientes")
@CrossOrigin(origins = "*")
public class SintomasClassificacaoController {
	@Autowired
	public KieSession session;
	@Autowired
	private SintomasClassificacaoRepository sintomasClassificacaoRepository;
	SintomasClassificacaoModel objeto = new SintomasClassificacaoModel();
	@PostMapping("/SintomasClassificacao")
	@ApiOperation(value = "Insere a classificação de risco no banco de dados logo após o drools ter inferido-a")
	public SintomasClassificacaoModel classificarPaciente(SintomasClassificacaoModel sintomasClassificacao) {
															//@RequestBody 
		
		GrupoController gc = new GrupoController();
		CriancasController bcc = new CriancasController();

		sintomasClassificacao.setGrupo(gc.grupoString());
		System.out.println("Grupo que veio de GrupoController: " + gc.grupoString());
		System.out.println("Grupo que chegou no controller: " + sintomasClassificacao.getGrupo());

		sintomasClassificacao.setSintomas(bcc.sintomaString());
		System.out.println("Sintoma que veio de BebeChorandoController: " + bcc.sintomaString());
		System.out.println("Sintoma que chegou no controller: " + sintomasClassificacao.getSintomas());

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
		System.out.println(objeto.getClassificacao());
		System.out.println(objeto.getTempoAtendimentoMinutos());
		System.out.println(objeto.getLocal());		
		return sintomasClassificacaoRepository.save(sintomasClassificacao);
	}

	public void classificaPaciente() {
		classificarPaciente(objeto);
	}
	
	
//
//	@RequestMapping(value = "/SintomasClassificacao", method = RequestMethod.POST)
//	public String cadastro(SintomasClassificacaoModel sintomasClassificacaoModel) {
//		GrupoController gc = new GrupoController();
//		BebeChorandoController bcc = new BebeChorandoController();
//
//		sintomasClassificacaoModel.setGrupo(gc.grupoString());
//		System.out.println("Grupo que veio de GrupoController: " + gc.grupoString());
//		System.out.println("Grupo que chegou no controller: " + sintomasClassificacaoModel.getGrupo());
//
//		sintomasClassificacaoModel.setSintomas(bcc.sintomaString());
//		System.out.println("Sintoma que veio de BebeChorandoController: " + bcc.sintomaString());
//		System.out.println("Sintoma que chegou no controller: " + sintomasClassificacaoModel.getSintomas());
//
//		session.insert(sintomasClassificacaoModel);
//		session.fireAllRules();
//
//		if (!sintomasClassificacaoModel.getClassificacao().equalsIgnoreCase("VERDE")) {
//			sintomasClassificacaoModel.setLocal("HOSPITAL");
//		} else {
//			sintomasClassificacaoModel.setLocal("POSTO DE SAUDE");
//		}
//		switch (sintomasClassificacaoModel.getClassificacao()) {
//		case "VERMELHA":
//			sintomasClassificacaoModel.setTempoAtendimentoImediato("ATENDIMENTO IMEDIATO");
//			break;
//		case "LARANJA":
//			sintomasClassificacaoModel.setTempoAtendimentoImediato("ATENDIMENTO MUITO URGENTE");
//			sintomasClassificacaoModel.setTempoAtendimentoMinutos(10);
//			break;
//		case "AMARELA":
//			sintomasClassificacaoModel.setTempoAtendimentoImediato("ATENDIMENTO URGENTE");
//			sintomasClassificacaoModel.setTempoAtendimentoMinutos(50);
//			break;
//		case "VERDE":
//			sintomasClassificacaoModel.setTempoAtendimentoImediato("ATENDIMENTO POUCO URGENTE");
//			sintomasClassificacaoModel.setTempoAtendimentoMinutos(120);
//			break;
//		}
//		System.out.println("Salvando objeto no banco...");
//		SintomasClassificacaoModel objeto = new SintomasClassificacaoModel();
//		objeto.setClassificacao(sintomasClassificacaoModel.getClassificacao());
//		System.out.println(objeto.getClassificacao());
//		sintomasClassificacaoRepository.save(sintomasClassificacaoModel);
//
//		return "redirect:/sintomas_classificacao";
//	}
//
//	@RequestMapping("/sintomas_classificacao")
//	public ModelAndView listaAlunos() {
//		ModelAndView mv = new ModelAndView("sintomas_classificacao");
//		Iterable<SintomasClassificacaoModel> scm = sintomasClassificacaoRepository.findAll();
//		mv.addObject("alunos", scm);
//		return mv;
//	}

//	@GetMapping("/SintomasClassificacao")
//	public String listaClassificacoes() {
//		return "redirect:/classificacao_final";
//	}

//	@GetMapping("/SintomasClassificacao")
//	@ApiOperation(value = "Retorna todas as classificações existentes no banco de dados")
//	public List<SintomasClassificacaoModel> listaClassificacoes() {
//		return sintomasClassificacaoRepository.findAll();
//	}

//	@GetMapping("/SintomasClassificacao/{id}")
//	@ApiOperation(value = "Retorna uma classificação do banco quando passado um ID")
//	public SintomasClassificacaoModel listaClassificacao(@PathVariable(value = "id") long id) {
//		return sintomasClassificacaoRepository.findById(id);
//	}
//
//	@DeleteMapping("/SintomasClassificacao")
//	@ApiOperation(value = "Este método deleta uma classificação existente no banco")
//	public void deletaRegistro(@RequestBody SintomasClassificacaoModel sintomasClassificacaoModel) {
//		sintomasClassificacaoRepository.delete(sintomasClassificacaoModel);
//	}
//	
//	@RequestMapping(value = "/classificacao_final", method = RequestMethod.POST)
//	public String cadastro(SintomasClassificacaoModel sintomasClassificacao) {
//		
//		sintomasClassificacaoRepository.save(sintomasClassificacao);
//		
//		return "redirect:/classificacao_final";
//	}
	
}
