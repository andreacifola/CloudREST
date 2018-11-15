package cloudrest.rest;

import cloudrest.entities.LightTask;
import cloudrest.handler.InterruptionHandler;
import cloudrest.solver.LightTaskSolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "lightCloud")
public class LightTaskService {


    /**
     * REST method: middleware sends light tasks to solve
     */
    @RequestMapping(path = "{id}", method = RequestMethod.POST)
    public ResponseEntity<LightTask> solveLightTask(@PathVariable int id, @RequestBody LightTask lightTask, HttpServletResponse response) throws IOException, InterruptedException {

        //responseWriter.sendResponse("Processing Task...",response);
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("lightTask Received - NODE");
        lightTask.setID(id);

        //aggiungo task a lista task
        InterruptionHandler.getInstance().addTaskToList(lightTask);


        Thread t = new Thread(() -> {
            LightTaskSolver solver = new LightTaskSolver();
            try {
                lightTask.setEncrypted(solver.CaesarCode(lightTask, lightTask.getLoopCount()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();

        System.out.println("lightTask Eseguito. Testo cifrato: " + lightTask.getEncrypted() + "\n");
        InterruptionHandler.getInstance().removeTask(lightTask.getID());

        return new ResponseEntity<>(lightTask, HttpStatus.OK);
    }
}
