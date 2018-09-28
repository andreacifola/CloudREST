package cloudrest.rest;

import cloudrest.entities.MediumTask;
import cloudrest.solver.MediumTaskSolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping(path = "mediumCloud")
public class MediumTaskService {
    //ResponseWriter responseWriter = new ResponseWriter();

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<MediumTask> solveMediumTask(@RequestBody MediumTask mediumTask, HttpServletResponse response) throws IOException {

        //responseWriter.sendResponse("Processing Task...",response);

        System.out.println("mediumTask Received - NODE");

        MediumTaskSolver solver = new MediumTaskSolver();
        mediumTask.setTime(solver.count(mediumTask));
        System.out.println("mediumTask Eseguito");

        return new ResponseEntity<>(mediumTask, HttpStatus.OK);
    }
}