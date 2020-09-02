
package ptplatformnys.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="Pttrainer", url="http://Pttrainer:8080")
public interface PttrainerService {

    @RequestMapping(method= RequestMethod.POST, path="/pttrainers")
    public void ptScheduleCancellation(@RequestBody Pttrainer pttrainer);

}