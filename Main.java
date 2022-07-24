import java.awt.EventQueue;
import gui.GetData;

public class Main {

	  public static void main(String[] args) {
		  
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GetData frame = new GetData();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
}