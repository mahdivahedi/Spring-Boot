package tacos.web;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.data.TacoRepository;
import tacos.dto.Ingredient;
import tacos.dto.Ingredient.Type;
import tacos.dto.Taco;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @Autowired
    private TacoRepository tacoRepository;

    @Autowired
    public DesignTacoController() {}

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                   ingredients);
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors())
            return "design";

        tacoRepository.save(design);

        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }


}