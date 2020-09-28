//Client
public class GUIBuilder{
  public void buildGUI(AbstractWidgetFactory widgetFactory){
    Window window = widgetFactory.createWindow();
    window.setTitle("New Window");
    window.repaint();
  }
}
