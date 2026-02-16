package Team_13.CdacPortalWithQuiz.services;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class OtpGenerator {

	static String otp;

	public String otpGen() {
		otp = "";
		Random rnd = new Random();
		String selectFrom = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		while (otp.length() < 6) {
			char ch = selectFrom.charAt(rnd.nextInt(selectFrom.length()));
			otp = otp + ch;
		}
		return otp;
	}

	public boolean verifyOtp(String userotp) {

		System.out.println(otp);
		if (otp.equals(userotp)) {
			return true;
		} else
			return false;
	}

}
