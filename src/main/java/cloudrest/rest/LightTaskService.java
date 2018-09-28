package cloudrest.rest;

import cloudrest.entities.LightTask;
import cloudrest.tasksolver.LightTaskSolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.exit;

@RestController
@RequestMapping(path = "lightCloud")
public class LightTaskService {

    //ResponseWriter responseWriter = new ResponseWriter();

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<LightTask> solveLightTask(@RequestBody LightTask lightTask, HttpServletResponse response) throws IOException {

        //responseWriter.sendResponse("Processing Task...",response);
        System.out.println("lightTask Received - NODE");

        LightTaskSolver solver = new LightTaskSolver();
        lightTask.setEncrypted(solver.hash(lightTask));
        System.out.println("lightTask Eseguito");

        return new ResponseEntity<>(lightTask, HttpStatus.OK);
}
