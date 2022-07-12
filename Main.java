class Main {
  public static void main(String[] args) {
    GUI g = new GUI();
    Cola c = new Cola(g);
      for(int n=0; n<5; n++){
        c.Insert2(g.date[n][0],g.date[n][1],n);//id, rafaga,posicion
      }
    c.Calcula();
    c.DeployCola();
    System.out.println();
    c.Change();

    int l=1;
    int l2=0;
    //System.out.println("id cliente" +"  "+"transacciones");
    for(int i=0; true; i++){
      int num = (int)(Math.random()*4+2); //2-4
      for(int n=1; n<num; n++){
         c.Insert(l,(n+l2));
         l++;
       }
        if(l2==0){
          l2++;
        }
        c.Calcula();
        c.DeployCola();
        System.out.println();
        c.Change();
      }
  }
}