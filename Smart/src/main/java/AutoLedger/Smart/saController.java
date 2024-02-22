package AutoLedger.Smart;

import AutoLedger.Smart.Entities.Batch;
import AutoLedger.Smart.Service.batchService;
import AutoLedger.Smart.Service.transacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class saController {
    @Autowired
    batchService batchservice;
    @Autowired
    transacService tservice;
    @GetMapping("/")
    public String index(Model md){
        md.addAttribute("allbatches",batchservice.getall());
        return "index";
    }
    @GetMapping("/insertbatch")
    public String insertbatch(@ModelAttribute Batch batch){
        batch.cash=batch.capital;
        batchservice.insert(batch);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
public String deletebatch(@PathVariable String id){
    Batch b=batchservice.findbyid(id);
    batchservice.deletebatch(b);
    return "redirect:/";

}
}
