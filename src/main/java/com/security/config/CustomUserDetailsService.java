package com.security.config;

import com.security.dao.CustomerRepository;
import com.security.model.Customer;
import com.security.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1 . load user from database
        Customer customer = customerRepository.findByEmailAddressLike(username).orElseThrow(() -> new UsernameNotFoundException("Not Found User"));


        // 2. load username, password, authorities
        List<GrantedAuthority> authorities = loadAuthorities(customer.getRoles());

        return new User("ericnguyen1606", "thuyHanh2002", authorities);
    }

    public List<GrantedAuthority> loadAuthorities(Set<Role> roles) {
        Iterator<Role> iteratorRole = roles.iterator();
        List<String> rolesName = new ArrayList<>();
        while(iteratorRole.hasNext()) {
            Role nextRole = iteratorRole.next();
            rolesName.add(nextRole.getRoleName());
        }
        List<GrantedAuthority> authorities = authorities(rolesName.toArray(new String[rolesName.size()]));
        return authorities;
    }

    public List<GrantedAuthority> authorities(String... roles) {
        int rolesLength = roles.length;
        List<GrantedAuthority> authorities = new ArrayList(roles.length);
        SimpleGrantedAuthority authority = null;
        for (int index = 0; index < rolesLength; index++) {
            authority = new SimpleGrantedAuthority(roles[index]);
            authorities.add(authority);
        }
        return authorities;
    }
}
