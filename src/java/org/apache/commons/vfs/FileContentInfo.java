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
package org.apache.commons.vfs;

/**
 * Interface to the content info
 *
 * @author <a href="mailto:imario@apache.org">Mario Ivanovits</a>
 * @version $Revision: 1.1 $ $Date: 2004/05/21 20:43:29 $
 */
public interface FileContentInfo
{
    /**
     * the content type
     */
    public String getContentType();

    /**
     * the content encoding
     */
    public String getContentEncoding();
}