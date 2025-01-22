package eu.durcak.security2fa.controller;

import eu.durcak.security2fa.security.UserDetailExtended;
import eu.durcak.security2fa.service.TotpService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Otp2faController {

    @GetMapping("/challenge")
    public String challenge(CsrfToken csrfToken,Authentication authentication, Model model, TotpService totpService) {

        /* if challenge is already completed */
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailExtended) {
            UserDetailExtended userDetails = (UserDetailExtended)authentication.getPrincipal();
            if (userDetails.isChallengeCompleted())
                return "redirect:/dashboard";


            model.addAttribute("_csrf", csrfToken.getToken());
            model.addAttribute("img64", totpService.generateQRUrl(userDetails.getOtpSecret(), authentication.getName()));
            return "otp2fa/challenge";
        }
        return "redirect:/login";
    }

    @PostMapping("/challenge")
    public String done(@RequestParam("otp") Integer otp, Authentication authentication, TotpService totpService){
        UserDetailExtended userDetail = (UserDetailExtended) authentication.getPrincipal();

        if(totpService.isValid(userDetail.getOtpSecret(), otp)) {
            userDetail.setChallengeCompleted(true);
            System.out.println("OTP Code valid");
        }
        else{
            System.out.println("OTP Code INvalid");
        }

        return "redirect:/dashboard";
    }
}
