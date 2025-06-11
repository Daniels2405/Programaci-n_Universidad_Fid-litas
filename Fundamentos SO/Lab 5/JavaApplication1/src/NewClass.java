
class Counter implements Runnable {

private int counter = 0;
  private final int rounds = 100000;

  public void run () {
      int id;
      String name = Thread.currentThread().getName();
      id = name.equals("thread1") ? 1 : 2;
      for(int i = 0; i < rounds; i++) {
        
        int tmp = counter;
       // para sincronizar los proceses asigne como comentario la linea siguiente (15) 
       //counter = tmp + 1;
        // Elimine los comentarios de las 3 siguientes líneas 
        // para sincronizar hilos debe asignar como comentario la linea 15
     synchronized (this) {
        counter++;
     }
      }
  }

  public static void main (String[] args) {
    try {
      Counter c = new Counter ();
      // Crea dos hilos que corren en el metodo run().
      Thread t1 = new Thread (c, "thread1");
      Thread t2 = new Thread (c, "thread2");
      // Método usado para iniciar el cuerpo de la thread 
      // definido por el método run()
      t1.start (); t2.start ();

      // Espera por la finalizacion del hilo.
      t1.join (); t2.join ();

      // Muestra counter
      System.out.println(c.counter);
      
    } catch (InterruptedException e) {
      System.out.println ("Interrupted!");
    }
  }
}

