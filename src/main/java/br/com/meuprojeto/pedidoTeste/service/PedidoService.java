package br.com.meuprojeto.pedidoTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meuprojeto.pedidoTeste.entity.PedidoEntity;
import br.com.meuprojeto.pedidoTeste.mapper.ItemMapper;
import br.com.meuprojeto.pedidoTeste.mapper.PedidoMapper;
import br.com.meuprojeto.pedidoTeste.repository.ItemRepository;
import br.com.meuprojeto.pedidoTeste.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoMapper pedidoMapper;
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	public String construirListaPedidosEItems(String pedidoString) {
		
		if(pedidoString!=null) {
			
			itemMapper.construirItemEntity(pedidoString);
			
			pedidoMapper.construirPedidoEntity(pedidoString);
			
			return "Pedido(s) salvo(s) com sucesso.";
		}
		
		return null;
	}
	
	public String salvarListaPedidosEItems(String pedidoString) {
		
		if(pedidoString!=null) {
			pedidoRepository.saveAll(pedidoMapper.construirPedidoEntity(pedidoString));
			itemRepository.saveAll(itemMapper.construirItemEntity(pedidoString));
			
			return "Pedido(s) salvo(s) com sucesso.";
		}
		
		
		return null;
	}
	
	public String salvarListaPedidos(String pedidoString) {
		return null;
	}
}