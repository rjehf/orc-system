package pl.kazmierski.orcsystem2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OcrApi {

    private OcrService ocrService;
    private  GraphicRepo graphicRepo;
    private List<Graphic> graphics;

    @Autowired
    public OcrApi(OcrService ocrService, GraphicRepo graphicRepo) {
        this.ocrService = ocrService;
        this.graphicRepo = graphicRepo;
        this.graphics = new ArrayList<>();
    }

    @PostMapping("/api/ocr")
    public String doOcr(@RequestBody Graphic graphic) {
        String ocr = ocrService.doOCR(graphic.getUrl());
        graphic.setContent(ocr);
   //     graphics.add(graphic);
        graphicRepo.save(graphic);
        return ocr;
    }

    @GetMapping("/api/ocr")
    public List<Graphic> getGraphic() {
      //  return this.graphics;
        return (List<Graphic>) graphicRepo.findAll();
    }

}
