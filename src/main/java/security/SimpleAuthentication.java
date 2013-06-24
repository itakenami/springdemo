package security;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public class SimpleAuthentication implements Authentication {

    private HashMap<String, String> usuario;
    private boolean autenticado;
    private List<SimpleGrantedAuthority> permissoes;

    public SimpleAuthentication(HashMap<String, String> usuario, List<SimpleGrantedAuthority> permissoes) {
        this.usuario = usuario;
        this.permissoes = permissoes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissoes;
    }
    
    @Override
    public String getName() {
        return usuario.get("nome");
    }

    @Override
    public Object getCredentials() {
        return usuario.get("senha");
    }

    @Override
    public Object getDetails() {
        return usuario;
    }

    @Override
    public Object getPrincipal() {
        return usuario.get("login");
    }

    @Override
    public boolean isAuthenticated() {
        return this.autenticado;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.autenticado = isAuthenticated;
    }
}
