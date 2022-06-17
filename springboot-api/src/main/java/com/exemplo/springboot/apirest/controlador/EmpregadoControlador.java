package com.exemplo.springboot.apirest.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.exemplo.springboot.apirest.excecao.RecursoNaoEncontrado;
import com.exemplo.springboot.apirest.modelo.Empregado;
import com.exemplo.springboot.apirest.repositorio.EmpregadoRepositorio;

@RestController
@RequestMapping("/api/v1")
public class EmpregadoControlador{
	
	@Autowired
	private EmpregadoRepositorio empregadoRepositorio;
	
	@GetMapping("/empregados")
	
	public List<Empregado> getTodosEmpregados(){
		return empregadoRepositorio.findAll();
	}
	
	@GetMapping("/empregados/{id}")
	public ResponseEntity <Empregado> getEmpregadoId(@PathVariable(value="id")Long empregadoId)
	throws RecursoNaoEncontrado{
		Empregado empregado = empregadoRepositorio.findById(empregadoId).orElseThrow(
				() -> new RecursoNaoEncontrado("Não é possível encontrar o empregado com este código: " + empregadoId));
		return ResponseEntity.ok().body(empregado);
	}
	
	@PostMapping("/empregados")
	
	public Empregado inserirEmpregado(@Valid @RequestBody Empregado empregado) {
		return empregadoRepositorio.save(empregado);
	}
	
	@PutMapping("/empregados/{id}")
	public ResponseEntity <Empregado> atualizarEmpregado(@PathVariable(value="id") Long empregadoId,
			@Valid @RequestBody Empregado empregadoDetalhes) throws RecursoNaoEncontrado{
		Empregado empregado = empregadoRepositorio.findById(empregadoId).orElseThrow(() -> new RecursoNaoEncontrado("Não é"
				+ " possível atualizar o empregado com este código: " + empregadoId));
		empregado.setEmail(empregadoDetalhes.getEmail());
		empregado.setUltimoNome(empregadoDetalhes.getUltimoNome());
		empregado.setPrimeiroNome(empregadoDetalhes.getPrimeiroNome());
		final Empregado empregadoAtualizado = empregadoRepositorio.save(empregado);
		return ResponseEntity.ok(empregadoAtualizado);
	}
	
	@DeleteMapping("/empregados/{id}")
	public Map<String, Boolean> deletarEmpregado(@PathVariable(value="id") Long empregadoId)
	throws RecursoNaoEncontrado{
		Empregado empregado = empregadoRepositorio.findById(empregadoId).orElseThrow(()-> new RecursoNaoEncontrado
				("Não é possível deletar o empregado com este código: " + empregadoId));
		
		empregadoRepositorio.delete(empregado);
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Deletado: ", Boolean.TRUE);
		return resposta;
	}
		
}

