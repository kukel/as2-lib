/**
 * The FreeBSD Copyright
 * Copyright 1994-2008 The FreeBSD Project. All rights reserved.
 * Copyright (C) 2013-2018 Philip Helger philip[at]helger[dot]com
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE FREEBSD PROJECT ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE FREEBSD PROJECT OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation
 * are those of the authors and should not be interpreted as representing
 * official policies, either expressed or implied, of the FreeBSD Project.
 */
package com.helger.as2lib.util.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import com.helger.as2lib.exception.OpenAS2Exception;

/**
 * Interface for Http connection, for set and get headers, content, etc.
 *
 * @author Ziv Harpaz
 */
public interface IAS2HttpConnection
{
  /**
   * Set an HTTP header
   *
   * @param sName
   *        Header name
   * @param sValue
   *        Header value
   */
  void setHttpHeader (@Nonnull String sName, @Nonnull String sValue);

  /**
   * Get URL
   */
  URL getURL () throws OpenAS2Exception;

  /**
   * Get OutputStream
   */
  OutputStream getOutputStream () throws IOException;

  /**
   * Get InputStream
   */
  InputStream getInputStream () throws OpenAS2Exception, IOException;

  /**
   * Get response HTTP Status as integer
   */
  int getResponseCode () throws OpenAS2Exception, IOException;

  /**
   * Get the response message
   */
  String getResponseMessage () throws OpenAS2Exception, IOException;

  /**
   * Close the connection
   */
  void disconnect ();

  /**
   * Get the headers of the request
   */
  Map <String, List <String>> getHeaderFields () throws OpenAS2Exception;

  default public void send (final InputStream toSend) throws OpenAS2Exception, IOException
  {
    throw new OpenAS2Exception ("Method not implemented in class " + this.getClass ().getName ());
  }
}