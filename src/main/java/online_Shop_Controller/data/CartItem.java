package online_Shop_Controller.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;


@Builder
public class CartItem{

	@SerializedName("amount")
	private int amount;

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("name")
	private String name;

	@SerializedName("currency")
	private String currency;

	@SerializedName("id")
	private int id;

	public int getAmount(){
		return amount;
	}

	public int getQuantity(){
		return quantity;
	}

	public String getName(){
		return name;
	}

	public String getCurrency(){
		return currency;
	}

	public int getId(){
		return id;
	}
}