/**
 *
 * $Id$
 */
package org.wso2.integrationstudio.eclipse.ds.validation;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.wso2.integrationstudio.eclipse.ds.EventSubscriptionList;
import org.wso2.integrationstudio.eclipse.ds.Expression;
import org.wso2.integrationstudio.eclipse.ds.TargetTopic;

/**
 * A sample validator interface for {@link org.wso2.integrationstudio.eclipse.ds.EventTrigger}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EventTriggerValidator {
	boolean validate();

	boolean validateMixed(FeatureMap value);
	boolean validateExpression(Expression value);
	boolean validateTargetTopic(TargetTopic value);
	boolean validateSubscriptions(EventSubscriptionList value);
	boolean validateId(String value);
	boolean validateLanguage(String value);
}
