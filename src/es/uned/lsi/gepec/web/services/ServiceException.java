/* OpenMark Authoring Tool (GEPEQ)
 * Copyright (C) 2013 UNED
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package es.uned.lsi.gepec.web.services;

/**
 * Class that represents any exception produced working with GEPEQ service classes.<br/><br/>
 * It's a subclass of <i>RuntimeException</i> so it is not needed to catch it. 
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException
{
	public ServiceException()
	{
		super();
	}
	
	public ServiceException(String message,Throwable cause)
	{
		super(message,cause);
	}
	
	public ServiceException(String message)
	{
		super(message);
	}
	
	public ServiceException(Throwable cause)
	{
		super(cause);
	}
}
