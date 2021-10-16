package com.ehospital.service;

import static com.ehospital.pojos.StoreOtp.otp;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ehospital.pojos.EmailStructure;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;
//	private static String tempOtp="";
//	public void sendSimpleMail(EmailStructure es) {
//		
//		SimpleMailMessage message=new SimpleMailMessage();
//		message.setFrom("atulgauravcdac@gmail.com");
//		message.setTo(es.getToEmail());
//		message.setText(es.getBody());
//		message.setSubject("Otp Verification for eHospital Login");
//		mailSender.send(message);
//		System.out.println("in email sender service email sent..");
//	}
	public void sendHtmlMail(EmailStructure es) {
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		otp=generateOtp();
		
		try {
		helper.setFrom("atulgauravcdac@gmail.com","eHospital");
		helper.setTo(es.getToEmail());
		String mailContent="<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "  <title>\r\n"
				+ "  </title>\r\n"
				+ "  <!--[if !mso]><!-->\r\n"
				+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "  <!--<![endif]-->\r\n"
				+ "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <style type=\"text/css\">\r\n"
				+ "    #outlook a {\r\n"
				+ "      padding: 0;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    body {\r\n"
				+ "      margin: 0;\r\n"
				+ "      padding: 0;\r\n"
				+ "      -webkit-text-size-adjust: 100%;\r\n"
				+ "      -ms-text-size-adjust: 100%;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    table,\r\n"
				+ "    td {\r\n"
				+ "      border-collapse: collapse;\r\n"
				+ "      mso-table-lspace: 0pt;\r\n"
				+ "      mso-table-rspace: 0pt;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    img {\r\n"
				+ "      border: 0;\r\n"
				+ "      height: auto;\r\n"
				+ "      line-height: 100%;\r\n"
				+ "      outline: none;\r\n"
				+ "      text-decoration: none;\r\n"
				+ "      -ms-interpolation-mode: bicubic;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    p {\r\n"
				+ "      display: block;\r\n"
				+ "      margin: 13px 0;\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "  <!--[if mso]>\r\n"
				+ "        <noscript>\r\n"
				+ "        <xml>\r\n"
				+ "        <o:OfficeDocumentSettings>\r\n"
				+ "          <o:AllowPNG/>\r\n"
				+ "          <o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
				+ "        </o:OfficeDocumentSettings>\r\n"
				+ "        </xml>\r\n"
				+ "        </noscript>\r\n"
				+ "        <![endif]-->\r\n"
				+ "  <!--[if lte mso 11]>\r\n"
				+ "        <style type=\"text/css\">\r\n"
				+ "          .mj-outlook-group-fix { width:100% !important; }\r\n"
				+ "        </style>\r\n"
				+ "        <![endif]-->\r\n"
				+ "  <!--[if !mso]><!-->\r\n"
				+ "  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,700\" rel=\"stylesheet\" type=\"text/css\">\r\n"
				+ "  <style type=\"text/css\">\r\n"
				+ "    @import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,700);\r\n"
				+ "  </style>\r\n"
				+ "  <!--<![endif]-->\r\n"
				+ "  <style type=\"text/css\">\r\n"
				+ "    @media only screen and (min-width:480px) {\r\n"
				+ "      .mj-column-per-100 {\r\n"
				+ "        width: 100% !important;\r\n"
				+ "        max-width: 100%;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "  <style media=\"screen and (min-width:480px)\">\r\n"
				+ "    .moz-text-html .mj-column-per-100 {\r\n"
				+ "      width: 100% !important;\r\n"
				+ "      max-width: 100%;\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "  <style type=\"text/css\">\r\n"
				+ "    @media only screen and (max-width:480px) {\r\n"
				+ "      table.mj-full-width-mobile {\r\n"
				+ "        width: 100% !important;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      td.mj-full-width-mobile {\r\n"
				+ "        width: auto !important;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body style=\"word-spacing:normal;background-color:#fafbfc;\">\r\n"
				+ "  <div style=\"background-color:#fafbfc;\">\r\n"
				+ "    <!--[if mso | IE]><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"\" style=\"width:600px;\" width=\"600\" ><tr><td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\"><![endif]-->\r\n"
				+ "    <div style=\"margin:0px auto;max-width:600px;\">\r\n"
				+ "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width:100%;\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"direction:ltr;font-size:0px;padding:20px 0;padding-bottom:20px;padding-top:20px;text-align:center;\">\r\n"
				+ "              <!--[if mso | IE]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td class=\"\" style=\"vertical-align:middle;width:600px;\" ><![endif]-->\r\n"
				+ "              <div class=\"mj-column-per-100 mj-outlook-group-fix\" style=\"font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:100%;\">\r\n"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:middle;\" width=\"100%\">\r\n"
				+ "                  <tbody>\r\n"
				+ "                    <tr>\r\n"
				+ "                      <td align=\"center\" style=\"font-size:0px;padding:25px;word-break:break-word;\">\r\n"
				+ "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;border-spacing:0px;\">\r\n"
				+ "                          <tbody>\r\n"
				+ "                            <tr>\r\n"
				+ "                              <td style=\"width:125px;\">\r\n"
				+ "                                <img height=\"auto\" src=\"https://pbs.twimg.com/media/EsLw4GZXYAUWPq1.jpg\" style=\"border:0;display:block;outline:none;text-decoration:none;height:auto;width:100%;font-size:13px;\" width=\"125\" />\r\n"
				+ "                              </td>\r\n"
				+ "                            </tr>\r\n"
				+ "                          </tbody>\r\n"
				+ "                        </table>\r\n"
				+ "                      </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                  </tbody>\r\n"
				+ "                </table>\r\n"
				+ "              </div>\r\n"
				+ "              <!--[if mso | IE]></td></tr></table><![endif]-->\r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "    </div>\r\n"
				+ "    <!--[if mso | IE]></td></tr></table><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"\" style=\"width:600px;\" width=\"600\" bgcolor=\"#ffffff\" ><tr><td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\"><![endif]-->\r\n"
				+ "    <div style=\"background:#ffffff;background-color:#ffffff;margin:0px auto;max-width:600px;\">\r\n"
				+ "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"background:#ffffff;background-color:#ffffff;width:100%;\">\r\n"
				+ "        <tbody>\r\n"
				+ "          <tr>\r\n"
				+ "            <td style=\"direction:ltr;font-size:0px;padding:20px 0;padding-bottom:20px;padding-top:20px;text-align:center;\">\r\n"
				+ "              <!--[if mso | IE]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td class=\"\" style=\"vertical-align:middle;width:600px;\" ><![endif]-->\r\n"
				+ "              <div class=\"mj-column-per-100 mj-outlook-group-fix\" style=\"font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:100%;\">\r\n"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:middle;\" width=\"100%\">\r\n"
				+ "                  <tbody>\r\n"
				+ "                    <tr>\r\n"
				+ "                      <td align=\"center\" style=\"font-size:0px;padding:10px 25px;padding-right:25px;padding-left:25px;word-break:break-word;\">\r\n"
				+ "                        <div style=\"font-family:open Sans Helvetica, Arial, sans-serif;font-size:16px;line-height:1;text-align:center;color:#000000;\"><span>Hello,</span></div>\r\n"
				+ "                      </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr>\r\n"
				+ "                      <td align=\"center\" style=\"font-size:0px;padding:10px 25px;padding-right:25px;padding-left:25px;word-break:break-word;\">\r\n"
				+ "                        <div style=\"font-family:open Sans Helvetica, Arial, sans-serif;font-size:16px;line-height:1;text-align:center;color:#000000;\">Please use the verification code below on the eHospital website:</div>\r\n"
				+ "                      </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr>\r\n"
				+ "                      <td align=\"center\" style=\"font-size:0px;padding:10px 25px;word-break:break-word;\">\r\n"
				+ "                        <div style=\"font-family:open Sans Helvetica, Arial, sans-serif;font-size:24px;font-weight:bold;line-height:1;text-align:center;color:#000000;\">"+otp+"</div>\r\n"
				+ "                      </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr>\r\n"
				+ "                      <td align=\"center\" style=\"font-size:0px;padding:10px 25px;padding-right:16px;padding-left:25px;word-break:break-word;\">\r\n"
				+ "                        <div style=\"font-family:open Sans Helvetica, Arial, sans-serif;font-size:16px;line-height:1;text-align:center;color:#000000;\">If you didn't request this, you can ignore this email or let us know.</div>\r\n"
				+ "                      </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr>\r\n"
				+ "                      <td align=\"center\" style=\"font-size:0px;padding:10px 25px;padding-right:25px;padding-left:25px;word-break:break-word;\">\r\n"
				+ "                        <div style=\"font-family:open Sans Helvetica, Arial, sans-serif;font-size:16px;line-height:1;text-align:center;color:#000000;\">Thanks! <br />eHospital team</div>\r\n"
				+ "                      </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                  </tbody>\r\n"
				+ "                </table>\r\n"
				+ "              </div>\r\n"
				+ "              <!--[if mso | IE]></td></tr></table><![endif]-->\r\n"
				+ "            </td>\r\n"
				+ "          </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "      </table>\r\n"
				+ "    </div>\r\n"
				+ "    <!--[if mso | IE]></td></tr></table><![endif]-->\r\n"
				+ "  </div>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>";
		
		helper.setText(mailContent, true);
		helper.setSubject("Otp Verification for eHospital Login");
		mailSender.send(message);
		
		}catch(MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String generateOtp() {
		// It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
	public String verifyOtp(String enteredOtp) {
		if(otp.equals(enteredOtp))
			return "success";
		else
			return "failure";
		
	}
}
