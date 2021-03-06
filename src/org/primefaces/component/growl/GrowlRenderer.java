/*
 * Copyright 2009-2011 Prime Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.component.growl;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.renderkit.CoreRenderer;

public class GrowlRenderer extends CoreRenderer {

    @Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		Growl growl = (Growl) component;
		String clientId = growl.getClientId(context);
        String widgetVar = growl.resolveWidgetVar();
		
		writer.startElement("span", growl);
		writer.writeAttribute("id", clientId, "id");
		writer.endElement("span");
		
        startScript(writer, clientId);

        if(isAjaxRequest(context)) {
            writer.write(widgetVar + ".show(");
            encodeMessages(context, growl);
            writer.write(");");
        } 
        else {
            writer.write("$(function(){");
            
            writer.write("PrimeFaces.cw('Growl','" + widgetVar + "',{");
            writer.write("id:'" + clientId + "',msgs:");
            encodeMessages(context, growl);
            writer.write("});});");
        }
	
		endScript(writer);
	}

    protected void encodeMessages(FacesContext context, Growl growl) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        Iterator<FacesMessage> messages = growl.isGlobalOnly() ? context.getMessages(null) : context.getMessages();

        writer.write("[");

		while(messages.hasNext()) {
			FacesMessage message = messages.next();
			String severityImage = getImage(context, growl, message);
			String summary = message.getSummary().replaceAll("'", "\\\\'");
			String detail = message.getDetail().replaceAll("'", "\\\\'");

            writer.write("{");

			if(growl.isShowSummary() && growl.isShowDetail())
				writer.write("title:'" + summary + "',text:'" + detail + "'");
			else if(growl.isShowSummary() && !growl.isShowDetail())
				writer.write("title:'" + summary + "',text:''");
			else if(!growl.isShowSummary() && growl.isShowDetail())
				writer.write("title:'',text:'" + detail + "'");

			if(!isValueBlank(severityImage))
				writer.write(",image:'" + severityImage + "'");

			if(growl.isSticky())
				writer.write(",sticky:true");
			else
				writer.write(",sticky:false");

		    // UNED: 06-03-2013 - dballestin - Added support for a new attribute: 'itemClass' to be able 
			//                                 to assign a specific CSS class to growl messages
			if(growl.getItemClass()!=null) {
				writer.write(",class_name:'");
				writer.write(growl.getItemClass().replaceAll(","," "));
				writer.write("'");
			}
		    // UNED: 06-03-2013 - dballestin - END - Added support for a new attribute: 'itemClass' to be able 
			//                                 to assign a specific CSS class to growl messages

			if(growl.getLife() != 6000)
                writer.write(",time:" + growl.getLife());

            writer.write("}");

            if(messages.hasNext())
                writer.write(",");
            
			message.rendered();
		}

        writer.write("]");
    }
	
	protected String getImage(FacesContext facesContext, Growl growl, FacesMessage message) {
        FacesMessage.Severity severity = message.getSeverity();
        
		if(severity == null)
			return "";
		else if(severity.equals(FacesMessage.SEVERITY_INFO))
			return growl.getInfoIcon() != null ? getResourceURL(facesContext, growl.getInfoIcon()) : getResourceRequestPath(facesContext, Growl.INFO_ICON);
		else if(severity.equals(FacesMessage.SEVERITY_ERROR))
			return growl.getErrorIcon() != null ? getResourceURL(facesContext, growl.getErrorIcon()) : getResourceRequestPath(facesContext, Growl.ERROR_ICON);
		else if(severity.equals(FacesMessage.SEVERITY_WARN))
			return growl.getWarnIcon() != null ? getResourceURL(facesContext, growl.getWarnIcon()) : getResourceRequestPath(facesContext, Growl.WARN_ICON);
		else if(severity.equals(FacesMessage.SEVERITY_FATAL))
			return growl.getFatalIcon() != null ? getResourceURL(facesContext, growl.getFatalIcon()) : getResourceRequestPath(facesContext, Growl.FATAL_ICON);
		else
			return "";
	}
}