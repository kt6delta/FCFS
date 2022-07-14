public class HiloG extends Thread{
  Gantt g;
  ColaGantt cg;
  
  @Override
  public void run(){
    GanttInf();
  }

  public HiloG(){
    g= new Gantt();
    cg= new ColaGantt(g);
  }
  
  public void GanttInf(){//infinito
  int l=1;
  int l2=0;
  for(int i=0; i<1; i++){
    int num = (int)(Math.random()*4+2); //2-4
    for(int n=0; n<num; n++){
      cg.Insert(l,(n+l2));
      l++;
    }
    if(l2==0){
      l2++;
    }
    cg.Calcula();
    l++;
    cg.DeployCola();
    cg.Change();
    }
  }
}