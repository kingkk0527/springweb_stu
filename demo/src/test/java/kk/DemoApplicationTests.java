package kk;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class DemoApplicationTests {

	@Test
	void testGenJwt() {
		// 中间填充载荷内容
		Map<String , Object> claims = new HashMap<>();
		claims.put("id",1);
		claims.put("name","kk");

		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256,"kkkk")  //签名算法  密钥 必须四个字母以上
				.setClaims(claims) 								// 中间填充载荷内容
				.setExpiration(new Date(System.currentTimeMillis()+3600*1000))  // 有效时间
				.compact();
		System.out.println(jwt);
	}

}
