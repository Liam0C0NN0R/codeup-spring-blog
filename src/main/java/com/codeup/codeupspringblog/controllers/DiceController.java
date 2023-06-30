package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;
import java.util.stream.IntStream;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        Random random = new Random();
        int[] rolls = IntStream.range(0, 5).map(i -> random.nextInt(6) + 1).toArray();
        long matches = IntStream.of(rolls).filter(roll -> roll == n).count();
        model.addAttribute("rolls", rolls);
        model.addAttribute("guess", n);
        model.addAttribute("matches", matches);
        return "dice-result";
    }
}
