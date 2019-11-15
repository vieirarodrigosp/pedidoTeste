package br.com.meuprojeto.pedidoTeste.mapper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import br.com.meuprojeto.pedidoTeste.domain.Pedido;
import br.com.meuprojeto.pedidoTeste.entity.PedidoEntity;
import br.com.meuprojeto.pedidoTeste.util.FerramentasSystemaUtil;

@Component
public class PedidoMapper {
	
	public Pedido construirPedido(String pedidoString) {
		
		if(pedidoString!=null) {
			
			JSONObject pedidoJson = new JSONObject(pedidoString);
			Pedido pedido = new Pedido();
			
			pedido.setId(pedidoJson.getInt("id"));
			pedido.setCliente(pedidoJson.getString("cliente"));
			pedido.setDt(FerramentasSystemaUtil.converteStringParaLocalDateTime(pedidoJson.getString("dt")));
			pedido.setVlrTotal(pedidoJson.getBigDecimal("vlrTotal"));
			pedido.setItems(ItemMapper.construirItemPeloObjetoJson(pedidoJson));

			return pedido;			
		}
		return null;
	}
	
	public List<PedidoEntity> construirPedidoEntity(String pedidoString) {
		
		if(pedidoString!=null) {
			
			JSONObject json = new JSONObject(pedidoString);
			JSONArray listPedidoJson = json.getJSONArray("pedidos");
			
			PedidoEntity pedidoEntity = new PedidoEntity();
			List<PedidoEntity> listaPedidos = new ArrayList<PedidoEntity>();
			
			for(int pedidoIndex = 0; pedidoIndex < listPedidoJson.length(); pedidoIndex++) {
				
				JSONObject pedidoJson = listPedidoJson.getJSONObject(pedidoIndex);
				
				pedidoEntity.setId(pedidoJson.getInt("id"));
				pedidoEntity.setCliente(pedidoJson.getString("cliente"));
				pedidoEntity.setDt(FerramentasSystemaUtil.converteStringParaLocalDateTime(pedidoJson.getString("dt")));
				pedidoEntity.setVlrTotal(pedidoJson.getBigDecimal("vlrTotal"));
				
				listaPedidos.add(pedidoIndex, pedidoEntity);
			}
			
			
			return listaPedidos;
		}
		return null;
	}
}
