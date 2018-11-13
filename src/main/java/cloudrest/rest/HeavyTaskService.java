package cloudrest.rest;

import cloudrest.entities.HeavyTask;
import cloudrest.handler.InterruptionHandler;
import cloudrest.solver.HeavyTaskSolver;
import cloudrest.utils.ResponseWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "heavyCloud")
public class HeavyTaskService {

    ResponseWriter responseWriter = new ResponseWriter();

    @RequestMapping(path = "{id}", method = RequestMethod.POST)
    public ResponseEntity<HeavyTask> solveHeavyTask(@PathVariable int id, @RequestBody HeavyTask heavyTask, HttpServletResponse response) throws IOException, InterruptedException {

        //responseWriter.sendResponse("Processing Task...",response);
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("heavyTask Received - NODE");
        heavyTask.setID(id);

        //aggiungo task a lista task
        InterruptionHandler.getInstance().addTaskToList(heavyTask);

        Thread t = new Thread(() -> {
            HeavyTaskSolver solver = new HeavyTaskSolver();
            heavyTask.setResponse(solver.factorial(heavyTask, heavyTask.getN(), heavyTask.getPartial(), heavyTask.getLast()));

        });
        t.start();
        t.join();

        System.out.println("heavyTask Eseguito. Il fattoriale è " + heavyTask.getResponse() + "\n");
        InterruptionHandler.getInstance().removeTask(heavyTask.getID());

        return new ResponseEntity<>(heavyTask, HttpStatus.OK);
    }
}
