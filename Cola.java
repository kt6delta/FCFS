import java.util.Scanner;
public class Cola{
  Scanner sc = new Scanner(System.in);
  Nodo first;
  Nodo last;
  private int num_deal=5, time= 500;
  GUI n;
  
  public Cola(GUI g){
    first= null;
    last= null;
    this.n=g;
  }
  public void Insert2(int id, int rafaga,int llega){
    Nodo new1= new Nodo();
    new1.id_client=id;
    new1.deal = rafaga;
    new1.posicion=llega;
    
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
      do{
        //System.out.println("   "+Actual.id_client +"          "+Actual.deal+"          "+Actual.posicion);
      
    switch(Actual.posicion){
      case 1:
        n.deal[0][0].setText(String.valueOf(Actual.id_client));
        n.deal[0][1].setText(String.valueOf(Actual.deal));
        n.deal[0][2].setText(String.valueOf(Actual.posicion));
        n.deal[0][3].setText(String.valueOf(Actual.start));
        n.deal[0][4].setText(String.valueOf(Actual.end));
        n.deal[0][5].setText(String.valueOf(Actual.back));
        n.deal[0][6].setText(String.valueOf(Actual.wait));
        break;
      case 2:
        n.deal[1][0].setText(String.valueOf(Actual.id_client));
        n.deal[1][1].setText(String.valueOf(Actual.deal));
        n.deal[1][2].setText(String.valueOf(Actual.posicion));
        n.deal[1][3].setText(String.valueOf(Actual.start));
        n.deal[1][4].setText(String.valueOf(Actual.end));
        n.deal[1][5].setText(String.valueOf(Actual.back));
        n.deal[1][6].setText(String.valueOf(Actual.wait));
        break;
      case 3:
        n.deal[2][0].setText(String.valueOf(Actual.id_client));
        n.deal[2][1].setText(String.valueOf(Actual.deal));
        n.deal[2][2].setText(String.valueOf(Actual.posicion));
        n.deal[2][3].setText(String.valueOf(Actual.start));
        n.deal[2][4].setText(String.valueOf(Actual.end));
        n.deal[2][5].setText(String.valueOf(Actual.back));
        n.deal[2][6].setText(String.valueOf(Actual.wait));
        break;
      case 4:
        n.deal[3][0].setText(String.valueOf(Actual.id_client));
        n.deal[3][1].setText(String.valueOf(Actual.deal));
        n.deal[3][2].setText(String.valueOf(Actual.posicion));
        n.deal[3][3].setText(String.valueOf(Actual.start));
        n.deal[3][4].setText(String.valueOf(Actual.end));
        n.deal[3][5].setText(String.valueOf(Actual.back));
        n.deal[3][6].setText(String.valueOf(Actual.wait));
        break;
      case 5:
        n.deal[4][0].setText(String.valueOf(Actual.id_client));
        n.deal[4][1].setText(String.valueOf(Actual.deal));
        n.deal[4][2].setText(String.valueOf(Actual.posicion));
        n.deal[4][3].setText(String.valueOf(Actual.start));
        n.deal[4][4].setText(String.valueOf(Actual.end));
        n.deal[4][5].setText(String.valueOf(Actual.back));
        n.deal[4][6].setText(String.valueOf(Actual.wait));
        break;
      }      
        try{
        Thread.sleep(time);
      }catch(InterruptedException e ) {}
        Actual= Actual.next;
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
      if(Actual.posicion==0 || Actual.posicion==1 ){
      Actual.start=0;
      }
      Actual.next.start=Actual.start+Actual.deal;
        
      Actual.end=Actual.deal+Actual.start;
      Actual.back=Actual.end-Actual.start;
      Actual.wait=Actual.back-Actual.deal;
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
          System.out.println("repite");
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
          System.out.println("Eliminado");
          find = true;
        }
        this.move();
        this.DeployCola();
        System.out.println("");
        
        Anterior= Actual;
        Actual= Actual.next;
      }while(Actual!=last); 
      if(!find){
        System.out.println("Cola vacia");
      }
      
    }
  }

}