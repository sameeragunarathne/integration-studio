/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.registry.propertytester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.wso2.integrationstudio.platform.core.utils.Constants;

/**
 * Class responsible for checking the selected resource is eligible to be shown in the context menu.
 */
public class RunResourcePropertyTester extends PropertyTester {

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        try {
            if (!((IResource) receiver).getProject().hasNature(Constants.GENERAL_PROJECT_NATURE)) {
                return false;
            }
            if (receiver instanceof IProject
                    || (receiver instanceof IFile && !(((IFile) receiver).getName().equals("pom.xml")))
                    || (receiver instanceof IFolder && !(((IFolder) receiver).getName().equals("target")))) {
                return true;
            }
        } catch (CoreException e) {
            // TODO Auto-generated catch block
        }
        return false;
    }
}
