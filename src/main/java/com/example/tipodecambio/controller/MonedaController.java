package com.example.tipodecambio.controller;


import com.example.tipodecambio.service.MonedaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/currencies")
@Valid
public class MonedaController {

    private MonedaService moneda;

    @Autowired
    public MonedaController(MonedaService moneda) {

        this.moneda = moneda;
    }

    //GET /currencies -> Obtener todas las monedas
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String[] getMonedas() {
        return moneda.getAll();
    }

    //GET /currencies/{name} -> Obtener una moneda por nombre
    @GetMapping("/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> getTipoCambio(@PathVariable String codigo) {
        Map<String, Double> tipoCambio = new HashMap<>();

        switch (codigo) {
            case "MXN" -> {
                tipoCambio.put("USD", 0.056);
                tipoCambio.put("EUR", 0.052);
            }
            case "USD" -> {
                tipoCambio.put("MXN", 17.85);
                tipoCambio.put("EUR", 0.92);
            }
            case "EUR" -> {
                tipoCambio.put("MXN", 19.17);
                tipoCambio.put("USD", 1.09);
            }
            default -> throw new IllegalArgumentException("Código de moneda no válido: " + codigo);
        }

        return tipoCambio;
    }

}
