package.example.demo.AcountController
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
@RestController
public class AcountController {
	
	@Autowired
	AccountRepository accounts;
	
@GetMapping("/create")
public Accunt create() {
	Account account =new Account();
	account.setEmail("aaa@naver.com");
	account.setPassword("pass");
	
return account.save(account);
}
}
