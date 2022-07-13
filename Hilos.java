public class Hilos{
  GUI g; 
  Cola c;

  public Hilos(){
    g = new GUI();
    c = new Cola(g);
    //TablaInf();
  }

  public void TablaInf(){//infinito
  int l=1;
  int l2=0;
  for(int i=0; i<2; i++){
    int num = (int)(Math.random()*4+2); //2-4
    for(int n=0; n<num; n++){
      c.Insert(l,(n+l2));
      l++;
    }
    if(l2==0){
      l2++;
    }
    c.Calcula();
    l++;
    c.DeployCola();
    System.out.println();
    c.Change();
    }
  }
}