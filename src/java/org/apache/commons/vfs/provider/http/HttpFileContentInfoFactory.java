/*
 * Copyright 2002, 2003,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.vfs.provider.http;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.vfs.FileContent;
import org.apache.commons.vfs.FileContentInfo;
import org.apache.commons.vfs.FileContentInfoFactory;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.impl.DefaultFileContentInfo;

/**
 * Description
 * 
 * @author <a href="mailto:imario@apache.org">Mario Ivanovits</a>
 * @version $Revision: 1.1 $ $Date: 2004/05/21 20:43:30 $
 */
public class HttpFileContentInfoFactory implements FileContentInfoFactory
{
    public FileContentInfo create(FileContent fileContent) throws FileSystemException
    {
        HttpFileObject httpFile = (HttpFileObject) fileContent.getFile();

        String contentType = null;
        String contentEncoding = null;

        Header header = httpFile.getHeadMethod().getResponseHeader("content-type");
        if (header != null)
        {
            HeaderElement[] element = new org.apache.commons.httpclient.HeaderElement[0];
            try
            {
                element = header.getValues();
            }
            catch (HttpException e)
            {
                throw new FileSystemException(e);
            }
            if (element != null && element.length > 0)
            {
                contentType = element[0].getName();
            }
        }

        contentEncoding = httpFile.getHeadMethod().getResponseCharSet();

        return new DefaultFileContentInfo(contentType, contentEncoding);
    }
}