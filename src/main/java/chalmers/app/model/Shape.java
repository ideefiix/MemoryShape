package chalmers.app.model;

import java.awt.*;

public class Shape {
    private Image image;
    private boolean isSelected = false;
    int size = 1;


    public Shape(Image image) {
        this.image = image;
    }

    public boolean getShapeSelected(){
        return isSelected;
    }

    public void setShapeSelected(boolean setting){
        isSelected = setting;
    }

    public Image getImage() {
        return image;
    }
}
