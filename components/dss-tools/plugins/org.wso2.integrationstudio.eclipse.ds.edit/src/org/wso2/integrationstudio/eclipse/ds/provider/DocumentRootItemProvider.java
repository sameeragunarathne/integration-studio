/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.integrationstudio.eclipse.ds.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.integrationstudio.eclipse.ds.DocumentRoot;
import org.wso2.integrationstudio.eclipse.ds.DsFactory;
import org.wso2.integrationstudio.eclipse.ds.DsPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.integrationstudio.eclipse.ds.DocumentRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DocumentRootItemProvider extends ItemProviderAdapter implements
                                                                 IEditingDomainItemProvider,
                                                                 IStructuredItemContentProvider,
                                                                 ITreeItemContentProvider,
                                                                 IItemLabelProvider,
                                                                 IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRootItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DsPackage.Literals.DOCUMENT_ROOT__CALL_QUERY);
			childrenFeatures.add(DsPackage.Literals.DOCUMENT_ROOT__DATA);
			childrenFeatures.add(DsPackage.Literals.DOCUMENT_ROOT__HASHEADER);
			childrenFeatures.add(DsPackage.Literals.DOCUMENT_ROOT__MAXROWCOUNT);
			childrenFeatures.add(DsPackage.Literals.DOCUMENT_ROOT__PROPERTY);
			childrenFeatures.add(DsPackage.Literals.DOCUMENT_ROOT__SQL);
			childrenFeatures.add(DsPackage.Literals.DOCUMENT_ROOT__STARTINGROW);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DocumentRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DocumentRoot"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getText(Object object) {
		return getString("_UI_DocumentRoot_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DocumentRoot.class)) {
			case DsPackage.DOCUMENT_ROOT__CALL_QUERY:
			case DsPackage.DOCUMENT_ROOT__DATA:
			case DsPackage.DOCUMENT_ROOT__HASHEADER:
			case DsPackage.DOCUMENT_ROOT__MAXROWCOUNT:
			case DsPackage.DOCUMENT_ROOT__PROPERTY:
			case DsPackage.DOCUMENT_ROOT__SQL:
			case DsPackage.DOCUMENT_ROOT__STARTINGROW:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DOCUMENT_ROOT__CALL_QUERY,
				 DsFactory.eINSTANCE.createCallQuery()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DOCUMENT_ROOT__DATA,
				 DsFactory.eINSTANCE.createDataService()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DOCUMENT_ROOT__HASHEADER,
				 DsFactory.eINSTANCE.createHasHeader()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DOCUMENT_ROOT__MAXROWCOUNT,
				 DsFactory.eINSTANCE.createMaxRowCount()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DOCUMENT_ROOT__PROPERTY,
				 DsFactory.eINSTANCE.createConfigurationProperty()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DOCUMENT_ROOT__SQL,
				 DsFactory.eINSTANCE.createSql()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DOCUMENT_ROOT__STARTINGROW,
				 DsFactory.eINSTANCE.createStartingRow()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public ResourceLocator getResourceLocator() {
		return DsEditPlugin.INSTANCE;
	}

}
