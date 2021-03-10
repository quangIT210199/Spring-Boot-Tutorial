package com.quang.springbootsecurityjwt.jwt;

//Mã hóa thông tin người dùng thành JWT

import com.quang.springbootsecurityjwt.user.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component // xác định 1 class là Bean
@Slf4j //xem log hả?
public class JwtTokenProvider {
    private final String JWT_SECRET = "lodaaaaaa";

    //Thời gian có hiện lực của JWT
    private final long JWT_EXPIRATION = 604800000L;

    //Tạo ra jwt từ thông tin user
    //JWT gồm 3 phần
    // Header: sẽ chứa dữ liệu và thuật toán sử dụng mã hóa JWT
    // Payload: "user_name": "admin", thằng này thì để public, nhưng sửa phải cần có secret key
    //  "user_id": "1513717410",
    //  "authorities": "ADMIN_USER",
    //  "jti": "474cb37f-2c9c-44e4-8f5c-1ea5e4cc4d18"

    // Signature: tạo ra bằng cách mã hóa header, payload (2 tk này mã hóa bằng base64UrlEncoder)
    // và 1 chuỗi secret( khóa bí mật). xong kết hợp 2 tk trên mã hóa xong mã hóa với thuật toán HS256
    public String generateToken(CustomUserDetails userDetails){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(Long.toString(userDetails.getUser().getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    // Lấy thông tin user từ jwt
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }
    //Kiểm tra token bằng secret key
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
//            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
//            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
//            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
//            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
