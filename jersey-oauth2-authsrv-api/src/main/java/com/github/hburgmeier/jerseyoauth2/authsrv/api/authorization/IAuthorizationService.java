package com.github.hburgmeier.jerseyoauth2.authsrv.api.authorization;

import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.hburgmeier.jerseyoauth2.api.protocol.IAuthorizationRequest;
import com.github.hburgmeier.jerseyoauth2.api.protocol.OAuth2ProtocolException;
import com.github.hburgmeier.jerseyoauth2.api.protocol.ResponseBuilderException;
import com.github.hburgmeier.jerseyoauth2.api.types.ResponseType;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IAuthorizedClientApp;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IRegisteredClientApp;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.ui.AuthorizationFlowException;


public interface IAuthorizationService {

	void evaluateAuthorizationRequest(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) 
			throws AuthorizationFlowException, IOException, ServletException, ResponseBuilderException;
	
	@Deprecated
	void sendAuthorizationReponse(HttpServletRequest request, HttpServletResponse response,
			ResponseType reqResponseType, IRegisteredClientApp regClientApp, IAuthorizedClientApp authorizedClientApp, String state)
			throws IOException, OAuth2ProtocolException, ResponseBuilderException;
	
	void sendAuthorizationReponse(HttpServletRequest request, HttpServletResponse response,
			IAuthorizationRequest originalRequest, IRegisteredClientApp regClientApp, IAuthorizedClientApp authorizedClientApp)
			throws IOException, OAuth2ProtocolException, ResponseBuilderException;	
	
	void sendErrorResponse(OAuth2ProtocolException ex,
			HttpServletResponse response, URI redirectUrl) throws ResponseBuilderException;	
}