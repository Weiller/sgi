package br.com.sgi.controller.web;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import br.com.sgi.annotations.Action;

@Action
public abstract class SgiController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Conversation conversation;
	
	public void iniciarConversacao(){
		if(conversation.isTransient()){
			conversation.begin();
			conversation.setTimeout(300000);
		}
	}
	
	public void endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
	}

}
