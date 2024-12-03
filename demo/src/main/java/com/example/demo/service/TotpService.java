package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

@Service
public class TotpService {
	
	private final GoogleAuthenticator gAuth;
	
	public TotpService(GoogleAuthenticator gAuth) {
		this.gAuth = gAuth;
	}
	
	public TotpService() {
		this.gAuth = new GoogleAuthenticator();
	}
	
	public GoogleAuthenticatorKey generateSecret() {
		return gAuth.createCredentials();
	}
	
	public String getQrCodeUrl(GoogleAuthenticatorKey secret, String username) {
		return GoogleAuthenticatorQRGenerator.getOtpAuthURL("Secure Notes Application", username, secret);
	}
	
	public boolean verifyCode(String secret, int code) {
		return gAuth.authorize(secret, code);
	}

}
