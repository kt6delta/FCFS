public class ColaGantt{
  Nodo first;
  Nodo last;
  private int num_deal=5, time= 3000;
  Gantt n;
  
  public ColaGantt(Gantt g){
    first= null;
    last= null;
    this.n=g;
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
      //si es necesario borrar
      do{
    switch(Actual.posicion){
      case 0:
        
        break;
      case 1:
        
        break;
      case 2:

        break;
      case 3:

        break;
      case 4:

        break;
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
          System.out.println(Actual.back+" "+Actual.end+"-"+Actual.start);
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