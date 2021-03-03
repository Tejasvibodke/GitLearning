package online_Shop_Controller.data;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Response{
	@Expose
	private String name;
	@Expose
	private String currency;
	@Expose
	private String id;
	@Expose
	private String amount;

	@Expose
	private List<Response> cart;

	@Expose
	private double totalAmount;


	@Override
	public String toString() {
		return "Response{" +
				"name='" + name + '\'' +
				", currency='" + currency + '\'' +
				", id='" + id + '\'' +
				", amount='" + amount + '\'' +
				'}';
	}


}