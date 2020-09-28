public class Main{
  public static void main(String[] args){
    GUIBuilder builder = new GUIBuilder();
    AbstractWidgetFactory widgetFactory = null;
    
// This is how you can detect the actual OS platform
    String os = System.getProperty("os.name").toLowerCase();
//    String os = "osx";
    if (os.contains("win")){
       widgetFactory  = new MsWindowsWidgetFactory();
    }
    else if (os.contains("osx")){
        widgetFactory  = new MacOSXWidgetFactory();
    }
    else {
        System.out.println("Not supported");
        return;
    }
    builder.buildGUI(widgetFactory);
  }
}
