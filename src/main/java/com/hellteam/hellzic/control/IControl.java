package com.hellteam.hellzic.control;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface IControl<B> {

    @PostMapping("/create")
    B create(@RequestBody B b);

    @PutMapping("/update/{id}")
    B update(@RequestBody B b, @PathVariable("id") String id);

    @GetMapping("select/{id}")
    B select(@PathVariable("id") String id);

    @GetMapping("find")
    List<B> findByLabel(@RequestParam("label") String label);

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id);

}
