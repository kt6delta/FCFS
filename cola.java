import java.util.Scanner;
public class Cola{
  Scanner sc = new Scanner(System.in);
  Nodo first;
  Nodo last;
  private int num_deal=5;
  private int time=2500;
  GUI n = new GUI();

  
  public Cola(){
    first= null;
    last= null;
    n.setVisible(true);
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
    this.Empty();
    if(first != null){
      do{
        //System.out.println("   "+Actual.id_client +"          "+Actual.deal+"          "+Actual.posicion);

      switch(Actual.posicion){
      case 1:
        n.id1.setText(String.valueOf("id:"+Actual.id_client));
        n.deal1.setText(String.valueOf("tr:"+Actual.deal));
        break;
      case 2:
        n.id2.setText(String.valueOf("id:"+Actual.id_client));
        n.deal2.setText(String.valueOf("tr:"+Actual.deal));
        break;
      case 3:
        n.id3.setText(String.valueOf("id:"+Actual.id_client));
        n.deal3.setText(String.valueOf("tr:"+Actual.deal));
        break;
      case 4:
        n.id4.setText(String.valueOf("id:"+Actual.id_client));
        n.deal4.setText(String.valueOf("tr:"+Actual.deal));
        break;
      case 5:
        n.id5.setText(String.valueOf("id:"+Actual.id_client));
        n.deal5.setText(String.valueOf("tr:"+Actual.deal));
        break;
      case 6:
        n.id6.setText(String.valueOf("id:"+Actual.id_client));
        n.deal6.setText(String.valueOf("tr:"+Actual.deal));
        break;
      case 7:
        n.id7.setText(String.valueOf("id:"+Actual.id_client));
        n.deal7.setText(String.valueOf("tr:"+Actual.deal));
        break;
      case 8:
        n.id8.setText(String.valueOf("id:"+Actual.id_client));
        n.deal8.setText(String.valueOf("tr:"+Actual.deal));
        break;
      case 9:
        n.id9.setText(String.valueOf("id:"+Actual.id_client));
        n.deal9.setText(String.valueOf("tr:"+Actual.deal));
        break;
       case 10:
        n.id10.setText(String.valueOf("id:"+Actual.id_client));
        n.deal10.setText(String.valueOf("tr:"+Actual.deal));
        break;
      }
      Actual= Actual.next;
      }while(Actual != first);
      try{
        Thread.sleep(time);
      }catch(InterruptedException e ) {}
    }else{
      //System.out.println("Lista vacia");
    }
  }


  public void Empty(){//vaciar Jlabel
    n.id1.setText("");
    n.deal1.setText("");

    n.id2.setText("");
    n.deal2.setText("");

    n.id3.setText("");
    n.deal3.setText("");

    n.id4.setText("");
    n.deal4.setText("");

    n.id5.setText("");
    n.deal5.setText("");

    n.id6.setText("");
    n.deal6.setText("");

    n.id7.setText("");
    n.deal7.setText("");

    n.id8.setText("");
    n.deal8.setText("");

    n.id9.setText("");
    n.deal9.setText("");

    n.id10.setText("");
    n.deal10.setText("");

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
        //System.out.println("Cola vacia");
      }
      
    }
  }

}