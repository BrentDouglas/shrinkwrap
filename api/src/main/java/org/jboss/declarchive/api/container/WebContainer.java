/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.declarchive.api.container;

import org.jboss.declarchive.api.Archive;
import org.jboss.declarchive.api.Path;

/**
 * WebContainer
 *
 * Defines the contract for a component capable of storing 
 * Web related resources.
 * <br/><br/>
 * The actual path to the Web resources within the Archive 
 * is up to the implementations/specifications.
 *
 * @author <a href="mailto:aslak@conduct.no">Aslak Knutsen</a>
 * @version $Revision: $
 * @param <T>
 */
public interface WebContainer<T extends Archive<T>>
{
   //-------------------------------------------------------------------------------------||
   // Contracts --------------------------------------------------------------------------||
   //-------------------------------------------------------------------------------------||

   /**
    * Adds a resource to this Archive as web.xml.
    * <br/><br/>
    * The ClassLoader used to obtain the resource is up to
    * the implementation. 
    * <br/>
    * For instance a resourceName of "test/example.xml" could be placed in 
    * "/WEB-INF/web.xml"
    * 
    * @param resourceName Name of the ClassLoader resource to add 
    * @return This virtual archive
    * @throws IllegalArgumentException if resourceName is null
    */
   T setWebXML(String resourceName)  throws IllegalArgumentException;
   
   /**
    * Adds the resource with the specified name
    * to the container, returning the container itself.
    * <br/><br/>
    * The ClassLoader used to obtain the resource is up to
    * the implementation. 
    * <br/>
    * For instance a resourceName of "test/example.xml" could be placed in 
    * "/WEB-INF/test/example.xml"
    * 
    * @param resourceName
    * @return
    * @throws IllegalArgumentException
    */
   T addWebResource(String resourceName) throws IllegalArgumentException;
   
   /**
    * Adds the resource with the specified name
    * to the container, returning the container itself.
    * <br/><br/>
    * The ClassLoader used to obtain the resource is up to
    * the implementation. 
    * <br/>
    * For instance a resourceName of "test/library.xml" and target of "/test/example.xml" could be placed in
    * "/lib/test/example.xml".
    * 
    * @param target The target relative to Manifest path within the archive into which we'll place the resource
    * @param resourceName Name of the ClassLoader resource to add
    * @return This virtual archive
    * @throws IllegalArgumentException if target is null
    * @throws IllegalArgumentException if resourceName is null
    */
   T addWebResource(Path target, String resourceName) throws IllegalArgumentException;
}
