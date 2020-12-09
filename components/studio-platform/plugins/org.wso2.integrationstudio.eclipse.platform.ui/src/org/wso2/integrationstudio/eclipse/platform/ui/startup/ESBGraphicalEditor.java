/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.eclipse.platform.ui.startup;

import org.wso2.integrationstudio.eclipse.platform.ui.editor.Openable;

public class ESBGraphicalEditor {

	private static Openable openable;

	public static void setOpenable(Openable openable) {
		ESBGraphicalEditor.openable = openable;
	}

	public static Openable getOpenable() {
		return openable;
	}

}
