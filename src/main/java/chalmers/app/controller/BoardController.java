package chalmers.app.controller;

public class BoardController implements ISceneController {

    private MainController mainController;

    @Override
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
