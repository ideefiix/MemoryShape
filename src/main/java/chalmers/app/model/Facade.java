package chalmers.app.model;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Facade {
     // ?? funderingar bara
     // skapar instanser av klaserna i vår modell
     private Image image; // bara för att skicka till Shape constructor, null just nu
     private List<Shape> shapeList = new ArrayList<Shape>();

     private Board board = new Board(1);
     private Shape shape = new Shape(image); // borde bilderna finnas i vyn egentilgen och att kontroller
                                             // har tillgång till dem
     private ShapeSelector display = new ShapeSelector( shapeList,5); // kommer vi alltid ha samma längd ??
                                                                                // borde shapeList finnas i vyn ??


    public Shape programstarted (){
         board.generateBoard(board.getCurrentLevel());
        return display.getSelectedShape();

    }





}
