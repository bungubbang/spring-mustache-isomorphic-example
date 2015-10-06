package mustache;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.ksug.isomorphic.mustache.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class SpringMustacheIsomorphicExampleApplicationTests {

	@Value("${local.server.port}")
	Integer port;

	@Test
	public void index() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = webClient.getPage(
                    fromHttpUrl("http://localhost").port(port).build().toUriString()
            );
            assertThat(page.getTitleText(), is("KSUG 2015 Web Seminar"));
        }
	}

}
