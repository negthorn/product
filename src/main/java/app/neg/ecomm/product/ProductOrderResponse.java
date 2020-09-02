package app.neg.ecomm.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductOrderResponse {
	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	@JsonProperty
	String status;
	@JsonProperty
	String message;
	
	public ProductOrderResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}
	

	
	static final class FAIL extends ProductOrderResponse{
		public FAIL(String msg) {
			super("error", msg);
		}
	}
	
	static final class SUCCESS extends ProductOrderResponse{
		public SUCCESS(String msg) {
			super("success", msg);
		}
	}
}
