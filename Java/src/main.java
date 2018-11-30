import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class TestService{
  String landing = "http://localhost:8888/testWS"

  @WebMethod
  public String sayHell(String msg){
    return "Hello"+msg;
  }

  public static void main(String[] args){
    Endpoint.publish(landing,new TestService());
  }
}
