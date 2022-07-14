class Main {
  public static void main(String[] args) {
  int num;
  for(int i=0; i<1; i++){
    num = (int)(Math.random()*4+2); //2-4
    int[] deal = new int[num];
    for(int n=0; n<num; n++){
      deal[n]=(int)(Math.random()*8+1);//1- 8 
    }
    Tabla t = new Tabla(); 
    Cola ct = new Cola(t); //colaT
    ct.SetNum(num);
    ct.SetDeal(deal);  
    Gantt g= new Gantt();
    Cola cg= new Cola(g); //colaG
    cg.SetNum(num);
    cg.SetDeal(deal); 
    
    ct.start();
    cg.start();
  }
}
}