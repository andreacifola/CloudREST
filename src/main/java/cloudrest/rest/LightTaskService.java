package cloudrest.rest;

import cloudrest.entities.LightTask;
import cloudrest.solver.LightTaskSolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "lightCloud")
public class LightTaskService {

    //ResponseWriter responseWriter = new ResponseWriter();

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<LightTask> solveLightTask(@RequestBody LightTask lightTask, HttpServletResponse response) throws IOException, InterruptedException {

        //responseWriter.sendResponse("Processing Task...",response);
        System.out.println("lightTask Received - NODE");

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

        System.out.println("lightTask Eseguito. Testo cifrato: " + lightTask.getEncrypted());
        return new ResponseEntity<>(lightTask, HttpStatus.OK);
    }
}
