class Main {
  public static void main(String[] args) {
  int num;
  int deal;
  for(int i=0; i<2; i++){
    num = (int)(Math.random()*4+2); //2-4
    deal=(int)(Math.random()*8+1);//1- 8 
    Tabla t = new Tabla(); 
    Cola ct = new Cola(t); //colaT
    ct.SetNum(num);
      
    Gantt g= new Gantt();
    Cola cg= new Cola(g); //colaG
    cg.SetNum(num);
    
    ct.start();
    cg.start();
  }
}
}