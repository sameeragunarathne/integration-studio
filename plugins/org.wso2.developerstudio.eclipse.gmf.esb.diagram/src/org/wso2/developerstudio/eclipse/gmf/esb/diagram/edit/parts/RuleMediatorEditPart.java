package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.DEFAULT_PROPERTY_VALUE_TEXT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.RULE_MEDIATOR_ICON_PATH;

import org.apache.commons.lang.StringUtils;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGroupingShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SingleCompartmentComplexFiguredAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CustomToolTip;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.RuleMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.RuleMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated NOT
 */
public class RuleMediatorEditPart extends SingleCompartmentComplexFiguredAbstractMediator {

    public IFigure childMediatorsOutputConnector;

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3523;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    public RuleMediatorEditPart(View view) {
        super(view);
    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new RuleMediatorItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new RuleMediatorCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // For handle Double click Event.
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (EsbVisualIDRegistry.getVisualID(childView)) {
                case RuleMediatorInputConnectorEditPart.VISUAL_ID:
                case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy();
                }
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated NOT
     */
    protected IFigure createNodeShape() {
        return primaryShape = new RuleMediatorFigure(new Color(null, 255, 246, 245), new Color(null, 121, 86, 73)) {
            public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
                super.setBounds(rect);
                if ((!connected) && (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0)) {
                    connectToMostSuitableElement();
                    reAllocate(rect);
                    connected = true;
                }
            };
        };
    }

    /**
     * @generated
     */
    public RuleMediatorFigure getPrimaryShape() {
        return (RuleMediatorFigure) primaryShape;
    }

    protected boolean addFixedChild(EditPart childEditPart) {

        if (childEditPart instanceof RuleMediatorInputConnectorEditPart) {

            IFigure borderItemFigure = ((RuleMediatorInputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.WEST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;

        } else if (childEditPart instanceof RuleMediatorOutputConnectorEditPart) {

            IFigure borderItemFigure = ((RuleMediatorOutputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.EAST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);

            return true;
        }
        if (childEditPart instanceof RuleMediatorChildMediatorsOutputConnectorEditPart) {
            childMediatorsOutputConnector = ((RuleMediatorChildMediatorsOutputConnectorEditPart) childEditPart)
                    .getFigure();
            childMediatorsOutputConnector.setEnabled(false);
        }
        /*
         * if (childEditPart instanceof LogMediatorLogCategoryEditPart) {
         * ((LogMediatorLogCategoryEditPart) childEditPart)
         * .setLabel(getPrimaryShape()
         * .getFigureLogCatogeryLogPropertyLabel());
         * return true;
         * }
         */
        return false;
    }

    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated NOT
     */
    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        addLayoutListner(figure);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
     * @param nodeShape instance of generated figure class
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof IBorderItemEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        return getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated NOT
     */
    public class RuleMediatorFigure extends EsbGroupingShape {

        /**
         * @generated
         */
        private WrappingLabel fFigureRuleMediatorPropertyValue;

        /**
         * @generated NOT
         */
        public RuleMediatorFigure(Color bgColor, Color boderColor) {
            super(bgColor, boderColor);
            ToolbarLayout layoutThis = new ToolbarLayout();
            layoutThis.setStretchMinorAxis(true);
            layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

            layoutThis.setSpacing(0);
            layoutThis.setVertical(false);

            this.setLayoutManager(layoutThis);
            this.setPreferredSize(new Dimension(getMapMode().DPtoLP(170), getMapMode().DPtoLP(100)));
            this.setOutline(false);
            this.setBackgroundColor(THIS_BACK);
            createContents();
        }

        public void add(IFigure figure, Object constraint, int index) {
            if (figure instanceof DefaultSizeNodeFigure) {
                GridData layoutData = new GridData();
                layoutData.grabExcessHorizontalSpace = true;
                layoutData.grabExcessVerticalSpace = true;
                layoutData.horizontalAlignment = GridData.FILL;
                layoutData.verticalAlignment = GridData.FILL;
                super.add(figure, layoutData, index);
            } else if (figure instanceof RoundedRectangle) {
                GridData layoutData = new GridData();
                layoutData.grabExcessHorizontalSpace = true;
                layoutData.grabExcessVerticalSpace = true;
                layoutData.horizontalAlignment = GridData.FILL;
                layoutData.verticalAlignment = GridData.FILL;
                super.add(figure, layoutData, index);
            }

            else {
                super.add(figure, constraint, index);
            }
        }

        /**
         * @generated NOT
         */
        private void createContents() {

            fFigureRuleMediatorPropertyValue = new WrappingLabel();
            fFigureRuleMediatorPropertyValue.setText(DEFAULT_PROPERTY_VALUE_TEXT);
            fFigureRuleMediatorPropertyValue.setAlignment(SWT.CENTER);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureRuleMediatorPropertyValue() {
            return fFigureRuleMediatorPropertyValue;
        }

        public String getIconPath() {
            return RULE_MEDIATOR_ICON_PATH;
        }

        public String getNodeName() {
            return Messages.RuleMediatorEditPart_NodeName;
        }

        public IFigure getToolTip() {
            if (StringUtils.isEmpty(toolTipMessage)) {
                toolTipMessage = Messages.RuleMediatorEditPart_ToolTipMessage;
            }
            return new CustomToolTip().getCustomToolTipShape(toolTipMessage);
        }
        
    }

    /**
     * @generated NOT
     */
    static final Color THIS_BACK = new Color(null, 255, 255, 255);

}
