package com.maxcpe.springsecurityoauth2login.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2LoginController {

	@GetMapping("/")
	public String index(Model model,
						@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
						@AuthenticationPrincipal OAuth2User oauth2User) {
		model.addAttribute("userName", oauth2User.getAttributes().get("name"));
		model.addAttribute("picture", oauth2User.getAttributes().get("picture"));
		model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
		model.addAttribute("userAttributes", oauth2User.getAttributes());
		return "index";
	}
	
	@GetMapping("/index2")
	public String index2(Model model,
						@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
						@AuthenticationPrincipal OAuth2User oauth2User) {

		return "index2";
	}
}