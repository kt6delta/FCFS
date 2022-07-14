class Main {
  public static void main(String[] args) {
  Tabla t = new Tabla(); 
  Cola ct = new Cola(t); //colaT
    
  Gantt g= new Gantt();
  Cola cg= new Cola(g); //colaG
  int num;
  int deal;
    
  ct.start();
  cg.start();

  }
}