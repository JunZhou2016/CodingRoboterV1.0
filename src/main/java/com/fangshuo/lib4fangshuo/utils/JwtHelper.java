package com.fangshuo.lib4fangshuo.utils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: JwtHelper.java
 * @Description: JavaWebToken的解析和生成工具类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月15日 上午11:24:27
 */
public class JwtHelper {

	/**
	 * 
	 * @param jsonWebToken:token字符串;
	 * @param base64Security:秘钥[base64字符串];
	 * @return
	 */
	public static Claims parseJWT(String jsonWebToken, String base64Security) {
		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
					.parseClaimsJws(jsonWebToken).getBody();
			return claims;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 
	 * @param name:用户名;
	 * @param userId:用户Id;
	 * @param role:角色;
	 * @param audience:观众;
	 * @param issuer:签发者;
	 * @param TTLMillis:过期时长;
	 * @param base64Security:秘钥[base64字符串];
	 * @return
	 */
	public static String createJWT(String name, String userId, String role, String audience, String issuer,
			long TTLMillis, String base64Security) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// 生成签名密钥
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// 声明jwt的头部;
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("typ", "JWT");// 令牌类型;
		header.put("alg", "HS256");// 正在使用的散列算法，例如HMAC SHA256或RSA;

		// 添加构成JWT的参数---》iss（发行人）、 exp（到期时间）， sub（主题）， aud（观众）等,已注册的声明可以通过get方式获取;
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").claim("role", role).claim("unique_name", name)
				.claim("userid", userId).setIssuer(issuer).setAudience(audience)// 设置已经注册的声明;
				.signWith(signatureAlgorithm, signingKey);// 设置校验签名部分;

		// 添加Token过期时间
		if (TTLMillis >= 0) {
			long expMillis = nowMillis + TTLMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp).setNotBefore(now);
		}
		// 生成JWT;
		return builder.compact();
	}
}