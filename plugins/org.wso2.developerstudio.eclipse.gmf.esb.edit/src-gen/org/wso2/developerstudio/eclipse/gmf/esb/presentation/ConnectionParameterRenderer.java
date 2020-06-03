/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * 
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeGroupValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Element;

public class ConnectionParameterRenderer {

    HashMap<String, Control> controlList;
    HashMap<String, Composite> compositeList;
    HashMap<String, Control> requiredList;
    PropertiesWidgetProvider widgetProvider;
    private FormToolkit widgetFactory;
    private boolean isFirstTime = true;
    private CTabFolder tabFolder;
    private Group tabSection;
    private Map<String, String> connectionTitleTypeMap = new HashMap<>();

    public ConnectionParameterRenderer(FormToolkit widgetFactory) {
        this.widgetFactory = widgetFactory;
        this.controlList = new HashMap<>();
        this.compositeList = new HashMap<>();
        this.requiredList = new HashMap<>();
        this.widgetProvider = new PropertiesWidgetProvider(controlList, compositeList, requiredList);
    }

    public HashMap<String, Control> generate(Composite parent, ConnectorRoot connectorRoot,
            Map<String, String> updateConfigMap, AttributeValue allowedConnectionTypes, String connectorName) {
        parent.setBackgroundMode(SWT.INHERIT_FORCE);

        //connectionName
        for (Element elem : connectorRoot.getElements()) {
            if (elem.getType().equals("attribute")) {
                evaluateAttribute((AttributeValue) elem.getValue(), parent, widgetFactory, 0);
                break;
            }
        }
        
        List<String> connectorConnectionTypes = allowedConnectionTypes.getAllowedConnectionTypes();
        allowedConnectionTypes.setName("connectionType");
        String connectionTypes[] = new String[connectorConnectionTypes.size()]; 
        for (int j = 0; j < connectorConnectionTypes.size(); j++) { 
            ConnectorRoot newConnectorRoot = ConnectorSchemaHolder.getInstance()
                    .getConnectorConnectionSchema(connectorName + "-" + connectorConnectionTypes.get(j));
            connectionTypes[j] = newConnectorRoot.getTitle(); 
            connectionTitleTypeMap.put(newConnectorRoot.getTitle(), connectorConnectionTypes.get(j));
        } 
        
        //create dropdown for connection types
        Composite composite = widgetFactory.createComposite(parent, SWT.NO_BACKGROUND);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 2;
        propertiesGroupLayout.marginLeft = 0;
        propertiesGroupLayout.horizontalSpacing = 20;
        propertiesGroupLayout.verticalSpacing = 0;
        composite.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 2;
        composite.setLayoutData(propertiesSectionData);
        compositeList.put(allowedConnectionTypes.getName(), composite);
        Label label = new Label(composite, SWT.NO_BACKGROUND);
        label.setText("Connection Type:");
        GridData labelRefData = new GridData();
        labelRefData.widthHint = 120;
        label.setLayoutData(labelRefData);
        final Combo configRef = new Combo(composite, SWT.READ_ONLY | SWT.DROP_DOWN);
        controlList.put(allowedConnectionTypes.getName(), configRef);
        if(allowedConnectionTypes.getRequired()) {
            requiredList.put(allowedConnectionTypes.getName(), configRef);
        }
        configRef.setItems(connectionTypes);
        configRef.setData("conenctionTitles", connectionTitleTypeMap);
        configRef.select(0);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        configRef.setLayoutData(configRefData);
        configRef.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                ConnectorRoot newConnectorRoot = ConnectorSchemaHolder.getInstance()
                        .getConnectorConnectionSchema(connectorName + "-" + connectionTitleTypeMap.get(configRef.getText()));
                tabFolder.dispose();
                tabSection.dispose();
                isFirstTime = true;
                
                //remove dispose items from controlList
                List<String> controlListItems = new ArrayList<>();
                for (Map.Entry<String, Control> entry : controlList.entrySet()) {
                    if (!entry.getKey().equals("connectionName") && !entry.getKey().equals("connectionType")) {
                        controlListItems.add(entry.getKey());
                    }
                }
                for (String item : controlListItems) {
                    controlList.remove(item);
                }
                //render new UI based on dropdown value
                renderContentOfConenction(newConnectorRoot, parent);
            }
        });

        //load rest of the connection components
        renderContentOfConenction(connectorRoot, parent);

        if (updateConfigMap != null && updateConfigMap.size() > 0) {
            for (Map.Entry<String, String> entry : updateConfigMap.entrySet()) {
                if (controlList.containsKey(entry.getKey())) {
                    Control control = controlList.get(entry.getKey());
                    if (control instanceof Text) {
                        if (entry.getKey().equals("connectionName")) {
                            control.setEnabled(false);
                        }
                        ((Text) control).setText(entry.getValue());
                    } else if (control instanceof Combo) {
                        if (entry.getKey().equals("connectionType")) {
                            control.setEnabled(false);
                        }
                        for (Map.Entry<String, String> titleItem : connectionTitleTypeMap.entrySet()) {
                            if (titleItem.getValue().equals(entry.getValue())) {
                                ((Combo) control).setText(titleItem.getKey());
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return controlList;
    }
    
    private void renderContentOfConenction(ConnectorRoot connectorRoot, Composite parent) {
        for (Element elem : connectorRoot.getElements()) {
            if (elem.getType().equals("attributeGroup")) {
                if (isFirstTime) {
                    tabSection = widgetProvider.createGroup(parent, "");
                    tabFolder = new CTabFolder(tabSection, SWT.NONE);
                    GridData tableLayoutData = new GridData(GridData.FILL_HORIZONTAL);
                    tabFolder.setLayoutData(tableLayoutData);
                    tabFolder.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
                    isFirstTime = false;
                }
                AttributeGroupValue agv = (AttributeGroupValue) elem.getValue();
                CTabItem tabGeneralSection = new CTabItem(tabFolder, SWT.NULL);
                tabGeneralSection.setText(agv.getGroupName());

                Composite tabComposite = new Composite(tabFolder, SWT.NONE);
                GridLayout tabCompositeGroupLayout = new GridLayout();
                tabComposite.setLayout(tabCompositeGroupLayout);
                tabGeneralSection.setControl(tabComposite);
                for (Element ele : agv.getElements()) {
                    createDynamicWidgetComponents(ele, tabComposite);
                }
            }
        }
        
        parent.layout();
        tabFolder.setSelection(0);
    }

    public void createDynamicWidgetComponents(Element element, Composite parent) {
        if (element.getType().equals("attribute")) {
            evaluateAttribute((AttributeValue) element.getValue(), parent, widgetFactory, 0);
        } else {
            AttributeGroupValue agv = (AttributeGroupValue) element.getValue();
            Group subGroup = widgetProvider.createGroup(parent, agv.getGroupName());
            for (Element elem : agv.getElements()) {
                createDynamicWidgetComponents(elem, subGroup);
            }
        }
    }

    public void evaluateAttribute(AttributeValue value, Composite parent, FormToolkit widgetFactory, int level) {
        if (AttributeValueType.STRING.equals(value.getType())) {
            widgetProvider.createTextBoxFieldWithButton(widgetFactory, parent, value);
        } else if (AttributeValueType.BOOLEANOREXPRESSION.equals(value.getType())) {
            widgetProvider.createDropDownField(widgetFactory, parent, new String[] { "true", "false" }, value);
        } else if (AttributeValueType.COMBO.equals(value.getType())) {
            widgetProvider.createDropDownField(widgetFactory, parent, value.getComboValues().toArray(new String[0]),
                    value);
        }
    }

}
