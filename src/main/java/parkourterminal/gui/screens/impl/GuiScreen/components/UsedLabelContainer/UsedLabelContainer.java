package parkourterminal.gui.screens.impl.GuiScreen.components.UsedLabelContainer;

import parkourterminal.gui.layout.Container;
import parkourterminal.gui.layout.ContainerKeyTypedAndOverlapped;
import parkourterminal.gui.layout.ContainerOverlapped;
import parkourterminal.gui.layout.UIComponent;
import parkourterminal.gui.screens.impl.GuiScreen.components.DisableTip;
import parkourterminal.gui.screens.impl.GuiScreen.components.Label;
import parkourterminal.gui.screens.impl.GuiScreen.components.UnusedLabelContainer.ListLabel;
import parkourterminal.gui.screens.impl.GuiScreen.components.UnusedLabelContainer.UnusedLabelContainer;

public class UsedLabelContainer extends ContainerKeyTypedAndOverlapped {
    private final DisableTip disableTip;
    private UnusedLabelContainer unusedLabelContainer;

    public UsedLabelContainer(DisableTip disableTip){
        this.disableTip=disableTip;
        this.setLayoutManagerEnabled(false);

    }
    public void SetUnusedLabelContainer(UnusedLabelContainer unusedLabelContainer){
        this.unusedLabelContainer=unusedLabelContainer;
    }
    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton){

//
//        super.mouseClicked(mouseX, mouseY, mouseButton);//delete??
//        for (UIComponent component:getComponents()){
//            if(component.isMouseOver(mouseX,mouseY)&&mouseButton!=2){
//                ((Label)component).SetIsPressing(true);
//                if(mouseButton==1){
//                    disableTip.setEnabled(true);
//                    disableTip.setPosition(mouseX,mouseY);
//                    disableTip.setChosenLabel((Label) component);
//                }
//                return true;
//            }
//        }
//        return false;
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }
    @Override
    public void mouseReleased(int mouseX, int mouseY,int state){
        if(this.getFocusedUI()!=null&&(this.getFocusedUI()).isFocused()&&unusedLabelContainer.isMouseOver(mouseX,mouseY)&&state==0){
            this.getFocusedUI().setEnabled(true);
            this.getFocusedUI().mouseReleased(mouseX,mouseY,state);
            unusedLabelContainer.addComponent(new ListLabel((Label)this.getFocusedUI(),disableTip,this,unusedLabelContainer));
            this.deleteComponent(this.getFocusedUI());
        }
        super.mouseReleased(mouseX,mouseY,state);
    }
    @Override
    public void draw(int mouseX, int mouseY, float partialTicks) {
        super.draw(mouseX, mouseY, partialTicks);

    }
    public void setIsOverlay(boolean isOverlay){
        for (UIComponent component:getComponents()){
            ((Label)component).setIsOverlay(isOverlay);
        }
    }
}
