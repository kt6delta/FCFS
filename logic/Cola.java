package logic;

import gui.Gantt;
import gui.Tabla;

public class Cola extends Thread{
  Nodo first;
  Nodo last;
  Tabla n;
  Gantt g;
  private int num_deal=8, time= 2000;
  private int num,l=1;
  private int [] deal;
private int[] llegada;

    @Override
  public void run(){ //corre tabla o Gant
    for(int n=0; n<num; n++){
      this.Insert(l,n,deal[n],llegada[n]);//entre 1- 8 transacciones
      l++;
    }
    this.Calcula();
    if(n!=null){
    	n.SeeTabla();
      this.DeployColaT();
      
    }
    if(g != null){
    	this.DeployColaG();
    	g.SeeGantt();
    }  
    this.Change();
  }
  
  public Cola(Tabla t){
    first= null;
    last= null;
    this.n=t;
  }
  public Cola(Gantt g1){
    first= null;
    last= null;
    this.g=g1;
  }
  
  private void Insert(int id_client, int posicion,int deal2, int llegada){
    Nodo new1= new Nodo();
    new1.deal = deal2; //entre 1- 8 transacciones
    new1.id_client=id_client;
    new1.posicion=posicion;
    new1.llegada=llegada;
    
    if(first == null){ //crea
      first= new1;
      last=new1;
      first.next=first;
    }
    else{ //encadena al existente
      last.next=new1;
      new1.next= first;
      last= new1;
    }
  }

  private void DeployColaG(){//solo imprime
    Nodo Actual= new Nodo();
    Actual = first;
    if(first != null){
    	g.tamaño=num;
    	g.initArray();
      do{
    	  if(Actual!=last) {
        g.Tdeal[Actual.posicion]=Actual.deal;
        g.Tstart[Actual.posicion]=Actual.start;
        g.idName[Actual.posicion]=Actual.id_client;
    	  }
       //System.out.println(Actual.id_client+" "+Actual.deal+" "+Actual.posicion+" "+Actual.start+" "+Actual.end+" "+Actual.back+" "+Actual.wait);
        Actual= Actual.next;
    }while(Actual != first);
    }else{
      System.out.println("Lista vacia");
    }
  }
  
  private void DeployColaT(){//solo imprime
    Nodo Actual= new Nodo();
    Actual = first;
    if(first != null){
    	n.BorraDeal(); //la primera ejecucion no	
      do{
        //System.out.println("   "+Actual.id_client +"          "+Actual.deal+"          "+Actual.posicion);
    	  if(Actual.back!=0) {
    switch(Actual.posicion){
      case 0:
        n.deal[0][0].setText(String.valueOf(Actual.id_client));
        n.deal[0][1].setText(String.valueOf(Actual.deal));
        n.deal[0][2].setText(String.valueOf(Actual.llegada));
        n.deal[0][3].setText(String.valueOf(Actual.start));
        n.deal[0][4].setText(String.valueOf(Actual.end));
        n.deal[0][5].setText(String.valueOf(Actual.back));
        n.deal[0][6].setText(String.valueOf(Actual.wait));
        break;
      case 1:
        n.deal[1][0].setText(String.valueOf(Actual.id_client));
        n.deal[1][1].setText(String.valueOf(Actual.deal));
        n.deal[1][2].setText(String.valueOf(Actual.llegada));
        n.deal[1][3].setText(String.valueOf(Actual.start));
        n.deal[1][4].setText(String.valueOf(Actual.end));
        n.deal[1][5].setText(String.valueOf(Actual.back));
        n.deal[1][6].setText(String.valueOf(Actual.wait));
        break;
      case 2:
        n.deal[2][0].setText(String.valueOf(Actual.id_client));
        n.deal[2][1].setText(String.valueOf(Actual.deal));
        n.deal[2][2].setText(String.valueOf(Actual.llegada));
        n.deal[2][3].setText(String.valueOf(Actual.start));
        n.deal[2][4].setText(String.valueOf(Actual.end));
        n.deal[2][5].setText(String.valueOf(Actual.back));
        n.deal[2][6].setText(String.valueOf(Actual.wait));
        break;
      case 3:
        n.deal[3][0].setText(String.valueOf(Actual.id_client));
        n.deal[3][1].setText(String.valueOf(Actual.deal));
        n.deal[3][2].setText(String.valueOf(Actual.llegada));
        n.deal[3][3].setText(String.valueOf(Actual.start));
        n.deal[3][4].setText(String.valueOf(Actual.end));
        n.deal[3][5].setText(String.valueOf(Actual.back));
        n.deal[3][6].setText(String.valueOf(Actual.wait));
        break;
      case 4:
        n.deal[4][0].setText(String.valueOf(Actual.id_client));
        n.deal[4][1].setText(String.valueOf(Actual.deal));
        n.deal[4][2].setText(String.valueOf(Actual.llegada));
        n.deal[4][3].setText(String.valueOf(Actual.start));
        n.deal[4][4].setText(String.valueOf(Actual.end));
        n.deal[4][5].setText(String.valueOf(Actual.back));
        n.deal[4][6].setText(String.valueOf(Actual.wait));
        break;
      }
    	  }
        Actual= Actual.next;
    }while(Actual != first);
    try{
      Thread.sleep(time);
    }catch(InterruptedException e ) {}
    }else{
      System.out.println("Lista vacia");
    }
  }

  private void Calcula(){
    Nodo Actual= new Nodo();
    Actual = first;
    
    if(first != null){
      do{
      if(Actual.id_client==1){ //inicia
        Actual.start=0;
        Actual.next.start=Actual.deal;
        Actual.end=Actual.deal;
        Actual.back=Actual.deal;
        Actual.wait=0;
      }else{ //infinito
        if(Actual == last){//encadenar al siguiente
          Actual.end=Actual.deal+Actual.start;
          Actual.back=Actual.end-Actual.posicion;
          Actual.wait=Actual.back-Actual.deal;
          Insert(Actual.id_client+1, Actual.posicion+1,deal[0],llegada[num-1]+1);
          Actual.next.start=Actual.deal+Actual.start;
          break;
        }else{//rellena
          Actual.next.start=Actual.deal+Actual.start;
          Actual.end=Actual.deal+Actual.start;
          Actual.back=Actual.end-Actual.posicion;
          Actual.wait=Actual.back-Actual.deal;

        }
      }
        Actual= Actual.next;
      }while(Actual != first);
    }
  }
  
  private void move(){ //-1 a todos
    Nodo Actual= new Nodo();
    Actual = first;
    if(first != null){
      do{
        Actual.posicion--;
        Actual= Actual.next;
      }while(Actual != first);
    }
  }

  private void Change(){ //ultimo no se modifica
    Nodo Actual= new Nodo();
    Actual = first;
    Nodo Anterior = new Nodo();
    Anterior =null;
    boolean find=false;
    
    if(first != null){//si lista vacia
      do{//recorre cola         
        if(Actual.deal > num_deal ){ //-4 deals
          Actual.deal=Actual.deal-num_deal;
          Actual.posicion=last.posicion+1;
          last=Actual;
          find = true;
          //System.out.println("repite");
        }else{ //delete
          if(Actual== first){
            first= first.next;
            last.next = first;            
          }else{
            if(Actual == last){
              Anterior.next = first;
              last = Anterior;            
            }else{
              Anterior.next = Actual.next;
            }
          }
          //System.out.println("Eliminado");
          find = true;
        }
        this.move();
        if(n != null){
          this.DeployColaT();
        }
        //System.out.println("");
        
        Anterior= Actual;
        Actual= Actual.next;
      }while(Actual!=last); 
      if(!find){
        System.out.println("Cola vacia");
      }
      
    }
  }

  public void SetNum(int num1){
    this.num=num1;
  }
  
  public void SetDeal(int[] deal1){
    this.deal=deal1;
  }

public void setLlegada(int[] tllegada) {
	this.llegada=tllegada;
	
}
}