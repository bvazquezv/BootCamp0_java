import java.util.Comparator;
import java.util.PriorityQueue;

public class PrioridadOrden {

    public static void main(String[] args) {



        PriorityQueue<AlertType> queue = new PriorityQueue<>(
                Comparator.comparingInt(AlertType::getPriority).reversed()
        );

        queue.add(AlertType.SIN_MOVIMIENTO);
        queue.add(AlertType.STOCK_BAJO);
        queue.add(AlertType.STOCK_CRITICO);

/*Procesa las alertas en orden de prioridad sin imporatan como hallan lleado lo que importa el la priorización definida*/
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
