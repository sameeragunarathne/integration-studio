/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface URLRewriteMediatorPropertiesEditionPart {

	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);


	/**
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * @param newValue the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToCommentsList(Object newValue);


	/**
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * @param newValue the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);




	/**
	 * Init the urlRewriteRules
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initUrlRewriteRules(ReferencesTableSettings settings);

	/**
	 * Update the urlRewriteRules
	 * @param newValue the urlRewriteRules to update
	 * 
	 */
	public void updateUrlRewriteRules();

	/**
	 * Adds the given filter to the urlRewriteRules edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToUrlRewriteRules(ViewerFilter filter);

	/**
	 * Adds the given filter to the urlRewriteRules edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToUrlRewriteRules(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the urlRewriteRules table
	 * 
	 */
	public boolean isContainedInUrlRewriteRulesTable(EObject element);


	/**
	 * @return the InProperty
	 * 
	 */
	public String getInProperty();

	/**
	 * Defines a new InProperty
	 * @param newValue the new InProperty to set
	 * 
	 */
	public void setInProperty(String newValue);


	/**
	 * @return the outProperty
	 * 
	 */
	public String getOutProperty();

	/**
	 * Defines a new outProperty
	 * @param newValue the new outProperty to set
	 * 
	 */
	public void setOutProperty(String newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
