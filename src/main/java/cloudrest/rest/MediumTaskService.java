package cloudrest.rest;

import cloudrest.entities.MediumTask;
import cloudrest.handler.InterruptionHandler;
import cloudrest.solver.MediumTaskSolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping(path = "mediumCloud")
public class MediumTaskService {

    /**
     * REST method: middleware sends medium tasks to solve
     */
    @RequestMapping(path = "{id}", method = RequestMethod.POST)
    public ResponseEntity<MediumTask> solveMediumTask(@PathVariable int id, @RequestBody MediumTask mediumTask, HttpServletResponse response) throws IOException, InterruptedException {
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("mediumTask Received - NODE");
        mediumTask.setID(id);

        //aggiungo task a lista task
        InterruptionHandler.getInstance().addTaskToList(mediumTask);

        Thread t = new Thread(() -> {
            MediumTaskSolver solver = new MediumTaskSolver();
            try {
                mediumTask.setTime(solver.count(mediumTask, mediumTask.getState(), mediumTask.getCurrentTime()));            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();

        System.out.println("mediumTask Eseguito in " + mediumTask.getTime() + " msec\n");
        InterruptionHandler.getInstance().removeTask(mediumTask.getID());

        return new ResponseEntity<>(mediumTask, HttpStatus.OK);
    }
}