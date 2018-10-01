package com.custom.ntlm;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, 
			property = {
			"javax.portlet.name=com_liferay_portal_settings_web_portlet_PortalSettingsPortlet",
			"mvc.command.name=/portal_settings/ntlm",
			"service.ranking:Integer=500" },
		service = MVCActionCommand.class
)		
public class CustomNTLMAction extends BaseMVCActionCommand {
	
	   @Reference(
	            target = 
	            "(&(mvc.command.name=/portal_settings/ntlm)" +
	            "(javax.portlet.name=com_liferay_portal_settings_web_portlet_PortalSettingsPortlet)" +
	            "(component.name=com.liferay.portal.settings.authentication.ntlm.web.internal.portlet.action.PortalSettingsNtlmFormMVCActionCommand))"
	            )
	   
	   
	   public void setMvcActionCommand(MVCActionCommand mvcActionCommand) {
           this.mvcActionCommand = mvcActionCommand;
         }
     protected MVCActionCommand mvcActionCommand;
	   
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		final String NTLM = "ntlm_";
		
		String enabled = ParamUtil.getString(request,NTLM+"enabled");
		String importFromLDAP = ParamUtil.getString(request,NTLM+"importFromLDAP");
		String loginURL = ParamUtil.getString(request,NTLM+"loginURL");
		String logoutOnSessionExpiration = ParamUtil.getString(request,NTLM+"logoutOnSessionExpiration");
		String logoutURL = ParamUtil.getString(request,NTLM+"logoutURL");
		String serverName = ParamUtil.getString(request,NTLM+"serverName");
		String serverURL = ParamUtil.getString(request,NTLM+"serverURL");
		
		System.out.println("**** NTLM ENABLED OUT ****" + enabled);
		System.out.println("**** NTLM IMPORT FROM LDAP OUT ****" + importFromLDAP );
		System.out.println("**** NTLM LOGIN URL OUT ****" + loginURL);
		System.out.println("**** NTLM LOGOUT SESSION EXPIRATION OUT ****" + logoutOnSessionExpiration);
		System.out.println("**** NTLM LOGOUT URL OUT ****" + logoutURL );
		System.out.println("**** NTLM SERVER NAME OUT ****" + serverName );
		System.out.println("**** NTLM SERVER URL OUT ****" + serverURL);

		mvcActionCommand.processAction(request, response);
	}

}