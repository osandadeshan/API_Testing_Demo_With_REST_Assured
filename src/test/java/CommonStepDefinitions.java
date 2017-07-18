import com.thoughtworks.gauge.Step;
import java.io.IOException;


/**
 * Created by Osanda on 7/18/2017.
 */


public class CommonStepDefinitions extends BaseClass{
	
	@Step("Given that the user invokes <apiEndpointName>")
	public void invokeApi(String apiEndpointName) throws IOException {
		super.invokeApi(apiEndpointName);
	}
	
	
}
