package com.quang.springbootsecurityjwt.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

//Class này có chức năng chuyển User thành UserDetails, để Spring Security quản lý
@Data
//@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    User user;

    public CustomUserDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Mặc định mình sẽ để tất cả là ROLE_USER. Để demo cho đơn giản.
        // phương thức getAuthorities() sẽ trả về một tập hợp các đối tượng GrantedAuthority
        // Một GrantedAuthority là một quyền được ban cho principal. Các quyền đều có tiền tố là ROLE_
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { // trả về true nếu tài khoản của người dùng chưa hết hạn
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

    /*
    getAuthorities(): trả về danh sách các quyền của người dùng
    getPassword(): trả về password đã dùng trong qúa trình xác thực
    getUsername(): trả về username đã dùng trong qúa trình xác thực
    isAccountNonExpired(): trả về true nếu tài khoản của người dùng chưa hết hạn
    isAccountNonLocked(): trả về true nếu người dùng chưa bị khóa
    isCredentialsNonExpired(): trả về true nếu chứng thực (mật khẩu) của người dùng chưa hết hạn
    isEnabled(): trả về true nếu người dùng đã được kích hoạt
    *
    * */
}
