public class Hilos{
  GUI g; 
  Cola c;

  public Hilos(GUI n){
    this.g =n; 
    c = new Cola(g);
  }
  public void TablaF(){
  for(int n=0; n<5; n++){
  c.Insert2(g.date[n][0],g.date[n][1],n);//id, rafaga,posicion
  }
  c.Calcula();
  c.DeployCola();
  c.Change();
  }

  public void TablaInf(){//infinito
  int l=1;
  int l2=0;
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