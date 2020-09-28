//ConcreteProduct1
public class MSWindow implements Window{
  private String title;
  public void setTitle(String title){
    this.title = title;
    System.out.println("My Title is: " + title);
  }
  public void repaint(){
    System.out.println("Repainting MS Windows Window");
  }
}

