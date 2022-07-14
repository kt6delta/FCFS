public class HiloT extends Thread{
  Tabla t; 
  ColaTable ct;
  
  @Override
  public void run(){
    TablaInf();
  }
  
  public HiloT(){
    t = new Tabla();
    ct = new ColaTable(t);
  }
  
  public void TablaInf(){//infinito
  int l=1;
  int l2=0;
  for(int i=0; i<2; i++){
    int num = (int)(Math.random()*4+2); //2-4
    for(int n=0; n<num; n++){
      ct.Insert(l,(n+l2));
      l++;
    }
    if(l2==0){
      l2++;
    }
    ct.Calcula();
    l++;
    ct.DeployCola();
    ct.Change();
    }
  }

}