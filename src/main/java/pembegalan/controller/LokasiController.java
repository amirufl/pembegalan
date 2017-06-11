package pembegalan.controller;

import pembegalan.entity.Lokasi;
import pembegalan.service.LokasiService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lokasi")
public class LokasiController {
    
    @Autowired
    private LokasiService br;

    @RequestMapping("list")
    public void daftarLokasi(ModelMap mm, Pageable page){
        Page<Lokasi> data = br.findAll(page);        
        mm.addAttribute("daftarLokasi", data);        
    }
    
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public ModelMap tampilkanForm(@RequestParam(required = false) Integer id){
        ModelMap mm = new ModelMap();
        
        mm.addAttribute("lokasi", new Lokasi());
        
        if(id != null){
            Lokasi b = br.findOne(id);
            if(b != null){
                mm.addAttribute("lokasi", b);
            }
        }
        
        return mm;
    }
    
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Lokasi b, BindingResult hasilValidasi){
        if(hasilValidasi.hasErrors()) {
            return "/lokasi/form";
        }
        
        br.save(b);
        return "redirect:list";
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String hapusLokasi(@RequestParam(required = true) Integer id){
        br.delete(id);
        return "redirect:list";
    }

}
