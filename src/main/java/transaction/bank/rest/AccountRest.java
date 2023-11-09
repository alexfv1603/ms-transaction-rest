package transaction.bank.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import transaction.bank.bean.amount.UpdateAmountRQ;
import transaction.bank.bean.amount.UpdateAmountRS;
import transaction.bank.configuration.ProviderProperties;

@Component
public class AccountRest {

	@Autowired
	private ProviderProperties providerProperties;
	private RestTemplate restTemplate;
	
	public UpdateAmountRS updateAmount(UpdateAmountRQ updateAmountRQ) {
		UpdateAmountRS updateAmountRS = new UpdateAmountRS();
		try {
			this.restTemplate = new RestTemplate();
			updateAmountRS = restTemplate.postForObject(providerProperties.getAmount_update(), 
					updateAmountRQ, UpdateAmountRS.class);
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
		return updateAmountRS;
	}
}
