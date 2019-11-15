package br.com.meuprojeto.pedidoTeste.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.meuprojeto.pedidoTeste.domain.Item;
import br.com.meuprojeto.pedidoTeste.entity.ItemEntity;

@Component
public class ItemMapper {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemMapper.class);

	public Item construirItemPeloString(String itemString) {
		return null;
	}
	
	public static List<Item> construirItemPeloObjetoJson(JSONObject pedidoJson) {
		
		List<Item> listItem = new ArrayList<Item>();
		Item item = new Item();
		JSONArray itemJsonjArray = pedidoJson.getJSONArray("items");
		
		for(int i = 0; i < itemJsonjArray.length(); i++) {
			
			JSONObject itemJson = itemJsonjArray.getJSONObject(i);
			
			item.setId(itemJson.getInt("id"));
			item.setNome(itemJson.getString("nome"));
			item.setQtd(itemJson.getInt("qtd"));
			item.setVlrTotal(itemJson.getBigDecimal("vlrUnitario"));
			item.setVlrTotal(itemJson.getBigDecimal("vlrTotal"));
		}
		listItem.add(item);
		
		return listItem;
	}
	
	public List<ItemEntity> construirItemEntity(String pedidos){
		
		if(pedidos!=null) {
			
			ItemEntity itemEntity = new ItemEntity();
			List<ItemEntity> listItemsEntity = new ArrayList<ItemEntity>();
			
			JSONObject json = new JSONObject(pedidos);
			JSONArray listPedidosJson = json.getJSONArray("pedidos");
			
			for(int pedidoIndex = 0; pedidoIndex < listPedidosJson.length(); pedidoIndex++) {
				
				JSONObject pedidoJson = listPedidosJson.getJSONObject(pedidoIndex);
				JSONArray listItemsJson = pedidoJson.getJSONArray("items");
				
				for(int itemIndex = 0; itemIndex < listItemsJson.length(); itemIndex++) {
					
					JSONObject itemJson = listItemsJson.getJSONObject(itemIndex);
					
					itemEntity.setId(itemJson.getInt("id"));
					itemEntity.setIdPedido(pedidoIndex);
					itemEntity.setNome(itemJson.getString("nome"));
					itemEntity.setQtd(itemJson.getInt("qtd"));
					itemEntity.setVlrUnitario(itemJson.getBigDecimal("vlrUnitario"));
					itemEntity.setVlrTotal(itemJson.getBigDecimal("vlrTotal"));
					
					listItemsEntity.add(itemEntity);
				}
				
			}
			return listItemsEntity;
		}
		return null;
	}
}
