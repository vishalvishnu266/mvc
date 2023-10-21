package mvc;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

import static mvc.tables.Task.TASK;

import mvc.tables.Task;
import mvc.tables.records.TaskRecord;
import org.jooq.DSLContext;

@Path("/some-page")
public class SomePage {
    @Inject
    DSLContext dslContext;
    private final Template page;

    public SomePage(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        Integer i = dslContext.selectCount().from(TASK).fetchOneInto(Integer.class);
        var task =dslContext.selectFrom(TASK).where(TASK.ID.eq(1L)).fetchOne();
        return page.data("name", task.getName());
    }

}
