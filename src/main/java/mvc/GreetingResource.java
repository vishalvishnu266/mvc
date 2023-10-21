package mvc;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mvc.tables.Task;
import mvc.tables.records.TaskRecord;
import org.jooq.DSLContext;
import org.jooq.Field;


@Path("/hello")
public class GreetingResource {
    @Inject
    DSLContext dslContext;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        TaskRecord taskRecord = dslContext.newRecord(Task.TASK);
        taskRecord.setName("TOO");
        int store = taskRecord.store();
        return "Hello from RESTEasy Reactive"+store;
    }
}
