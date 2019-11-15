package br.com.meuprojeto.pedidoTeste.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.meuprojeto.pedidoTeste.entity.PedidoEntity;
import br.com.meuprojeto.pedidoTeste.repository.PedidoRepository;
import br.com.meuprojeto.pedidoTeste.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "pedidoTeste")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/pedidos", method = RequestMethod.GET)
	@ApiOperation(value = "Retorna uma lista de pedidos")
	public ResponseEntity<List<PedidoEntity>> buscar(){
		
		if(pedidoRepository.findAll().isEmpty()) {
			return new ResponseEntity<List<PedidoEntity>>(pedidoRepository.findAll(), HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<List<PedidoEntity>>(pedidoRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pedido/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Retorna o pedido pelo número dele")
	public ResponseEntity<Optional<PedidoEntity>> buscarPedidoPorId(@PathVariable("id") Integer id){
		
		if(!pedidoRepository.findById(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Optional<PedidoEntity>>(pedidoRepository.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pedido", method = RequestMethod.POST)
	@ApiOperation(value = "Insere uma lista de pedidos")
	public HttpStatus adicionarPedido(@RequestBody @Valid final String pedidoString){
		
		if(pedidoString!=null) {
			pedidoService.salvarListaPedidosEItems(pedidoString);
			
			return HttpStatus.NO_CONTENT;
		}
		
		return HttpStatus.NOT_IMPLEMENTED;
	}
	
	@RequestMapping(value = "/pedido/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Exclui um pedido da lista pelo número dele")
	public ResponseEntity<?> excluirPedido(@PathVariable("id") Integer id) {
		 
		  if (!pedidoRepository.findById(id).isPresent()) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
		 
		  pedidoRepository.deleteById(id);
		  
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}