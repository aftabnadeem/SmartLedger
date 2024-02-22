package AutoLedger.Smart;

import AutoLedger.Smart.Entities.transactions;
import AutoLedger.Smart.Service.batchService;
import AutoLedger.Smart.Service.transacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("transaction")
public class tranController {
    @Autowired
    transacService tService;
    @Autowired
    batchService bService;
    @GetMapping("/getall/{id}")
   public String getall(@PathVariable String id, Model m){

        m.addAttribute("alltrans",tService.getall(id));
        m.addAttribute("id",id);
      return "Transactions";
    }
    @GetMapping("/addtransaction")
    public String addtransaction(@ModelAttribute transactions t){
        tService.addtrans(t);
        if(t.type.matches("purchase")){
            bService.totalpurchase(t.batch);
        } else if (t.type.matches("sales")) {
            bService.totalsales(t.batch);
        } else if (t.type.matches("expenses")) {
            bService.totalexpenses(t.batch);
        }
        bService.totalcash(t.batch);
        bService.totalprofit(t.batch);
        return "redirect:/transaction/getall/"+t.batch+"";
    }
}
