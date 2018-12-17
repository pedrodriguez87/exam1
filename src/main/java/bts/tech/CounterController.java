package bts.tech;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/")
public class CounterController {

    private CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;

        TemplateLoader loader = new ClassPathTemplateLoader();
        loader.setPrefix("/templates");
        loader.setSuffix(".hbs");
        new Handlebars(loader);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCounter() throws IOException {

        Template template = HandleBarsUtil.compile("counter-list");
        Map<String, Object> values = new HashMap<>();
        values.put("x", counterService.getValue());
        return template.apply(values);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/increment")
    public void incrementCounter(HttpServletResponse response) throws IOException {

        counterService.incrementCounter();
        response.sendRedirect("/");

    }

    @RequestMapping(method = RequestMethod.GET, path = "/counters")
    public int addCounter(HttpServletResponse response) throws IOException {

        return counterService.createCounter();
    }
}
