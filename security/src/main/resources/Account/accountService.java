package.example.demo.AccountService

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {
	private final AccountRepository accounts;

	public public AccountService(AccountRepository accounts) {
		// TODO Auto-generated constructor stub
		this.accounts = accounts;
	}// 빈에 생성자 하나만 있고 매개변수들이 모두 들어가게 할수있다.

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
Account accounts.findByEmail(username);
//어카운트를 유저 디테일로 바꿔야한ㄴ다. 
@Override
public Collection<? extends GrantedAuthority> gETGrantedAuthorities{


}
return null;
}

}
