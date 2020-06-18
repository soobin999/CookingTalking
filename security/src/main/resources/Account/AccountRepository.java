package.example.demo.accountService.java
import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class AccountRepository {

	private Map<String,Account>accounts=new HashMap<>();
	private Random random=new Random();
	
	public vois save(Account account) {
		account.setId(random.nextInt());
		account.put(account.getEail(),account);
		return account;
	}
}
