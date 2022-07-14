public class ColaGantt{
  Nodo first;
  Nodo last;
  private int num_deal=5, time= 1000;
  Gantt n;
  
  public ColaGantt(Gantt gui){
    first= null;
    last= null;
    this.n=gui;
  }
  
  public void Insert(int id_client, int posicion){
    Nodo new1= new Nodo();
    new1.deal = (int)(Math.random()*8+1); //entre 1- 8 transacciones
    new1.id_client=id_client;
    new1.posicion=posicion;
    
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

  public void DeployCola(){//solo imprime
    Nodo Actual= new Nodo();
    Actual = first;
    if(first != null){
      //por si es necesario borrar
      do{
        n.plH=(Actual.posicion+1);
        n.plVf=Actual.end;
        n.plVi=Actual.start;
       System.out.println(Actual.id_client+" "+Actual.deal+" "+Actual.posicion+" "+Actual.start+" "+Actual.end+" "+Actual.back+" "+Actual.wait);
        n.repaint();
        Actual= Actual.next;
      try{
      Thread.sleep(time);
    }catch(InterruptedException e ) {}
    }while(Actual != first);
    }else{
      System.out.println("Lista vacia");
    }
  }

  public void Calcula(){
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
          Insert(Actual.id_client+1, Actual.posicion+1);
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
  
  public void move(){ //-1 a todos
    Nodo Actual= new Nodo();
    Actual = first;
    if(first != null){
      do{
        Actual.posicion--;
        Actual= Actual.next;
      }while(Actual != first);
    }
  }

  public void Change(){ //ultimo no se modifica
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
        this.DeployCola();
        //System.out.println("");
        
        Anterior= Actual;
        Actual= Actual.next;
      }while(Actual!=last); 
      if(!find){
        System.out.println("Cola vacia");
      }
      
    }
  }

}