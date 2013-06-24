package security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public class SimpleAuthenticationProvider implements AuthenticationProvider {
	
        @Override
	public Authentication authenticate(Authentication auth)	throws AuthenticationException {
            
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) auth;
		String username = token.getName();
		String senha    = token.getCredentials() != null ? token.getCredentials().toString() : null;
                
                SimpleAuthentication resultado;
                
                if(username.equals("user")){
                    
                    //Informacoes de usuario
                    HashMap<String,String> usuario = new HashMap<String, String>();
                    usuario.put("nome", "Usuario Normal");
                    usuario.put("login", "user");
                    usuario.put("senha", "123");
                    
                    //Permissoes
                    List<SimpleGrantedAuthority> permisao = new ArrayList<SimpleGrantedAuthority>();
                    permisao.add(new SimpleGrantedAuthority("ROLE_MEMBRO"));
                    
                    resultado = new SimpleAuthentication(usuario, permisao);
                    resultado.setAuthenticated(true);
                    
                }else if(username.equals("admin")){
                    
                    //Informacoes de usuario
                    HashMap<String,String> usuario = new HashMap<String, String>();
                    usuario.put("nome", "Administrador");
                    usuario.put("login", "admin");
                    usuario.put("senha", "456");
                    
                    //Permissoes
                    List<SimpleGrantedAuthority> permisao = new ArrayList<SimpleGrantedAuthority>();
                    permisao.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    permisao.add(new SimpleGrantedAuthority("ROLE_MEMBRO"));
                    
                    resultado = new SimpleAuthentication(usuario, permisao);
                    resultado.setAuthenticated(true);
                    
                }else{
                    return null;
                }
                
		return resultado;
	}

        @Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
