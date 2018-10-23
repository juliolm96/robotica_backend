package com.robotica.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.robotica.security.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
public class UserPrincipal implements UserDetails {

	private int id;

	private String username;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;

	private List<GrantedAuthority> authorities;

	public UserPrincipal(int id, String username, String email, String password,
			List<GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrincipal create(User user) {
		
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>(); 
		authority.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
	
		return new UserPrincipal(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),
				authority);
		
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		UserPrincipal that = (UserPrincipal) o;

		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return "UserPrincipal [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", authorities=" + authorities + "]";
	}

}
