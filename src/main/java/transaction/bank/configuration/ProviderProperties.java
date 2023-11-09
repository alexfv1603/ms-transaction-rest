package transaction.bank.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("rest")
public class ProviderProperties {
	
	private String amount_update;

	public String getAmount_update() {
		return amount_update;
	}

	public void setAmount_update(String amount_update) {
		this.amount_update = amount_update;
	}

}
