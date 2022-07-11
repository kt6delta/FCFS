class Main {
  public static void main(String[] args) {
    Cola c = new Cola();
    int l=1;
    int l2=0;
    //System.out.println("id cliente" +"  "+"transacciones");
    for(int i=0; true; i++){
      int num = (int)(Math.random()*8+2); //2-4
      for(int n=1; n<num; n++){
        c.Insert(l,(n+l2));
        l++;
      }
      if(l2==0){
        l2++;
      }
      c.DeployCola();
      System.out.println();
      c.Change();
    }
  }
}